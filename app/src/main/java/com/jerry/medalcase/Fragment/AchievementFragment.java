package com.jerry.medalcase.Fragment;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jerry.medalcase.R;
import com.jerry.medalcase.data.ViewModel.AchievementData;
import com.jerry.medalcase.data.ViewModel.AchievementViewModel;
import com.jerry.medalcase.data.gson.Achievement;
import com.jerry.medalcase.data.utils.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AchievementFragment extends Fragment {

    private RecyclerView recyclerView;
    private AchievementViewModel achievementViewModel;
    private MedalCaseAdapter medalCaseAdapter;
    private ArrayList<AchievementData> dataArrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.farg_achievement, null);
        recyclerView = rootView.findViewById(R.id.medalcase);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return dataArrayList.get(position).getDataType() == AchievementData.DataType.Header ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        medalCaseAdapter = new MedalCaseAdapter();

        recyclerView.setAdapter(medalCaseAdapter);
        achievementViewModel = new ViewModelProvider(this).get(AchievementViewModel.class);
        achievementViewModel.getAchievementLiveData()
                .observe(getViewLifecycleOwner(), this::handleResponse);
    }

    private void handleResponse(Achievement achievement) {
        //Populate data for grid view based on achievement
        dataArrayList = Utils.populateData(achievement);
        medalCaseAdapter.setData(dataArrayList);
        medalCaseAdapter.notifyDataSetChanged();
    }

    private class MedalCaseAdapter extends RecyclerView.Adapter<MedalCaseViewHolder> {

        final int HEADER = 0;
        final int DATA_CELL = 1;
        final int EMPTY_CELL = 2;

        ArrayList<AchievementData> data = new ArrayList<>();

        void setData(ArrayList<AchievementData> data) {
            this.data = data;
        }

        @Override
        public MedalCaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            if(viewType == HEADER) {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.pager_header, parent, false);
            } else {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.medal_cell, parent, false);
            }

            return new MedalCaseViewHolder(view, viewType);
        }

        public int getItemViewType (int position) {
            if(data.get(position).getDataType() == AchievementData.DataType.Header) {
                return HEADER;
            } else if(data.get(position).getDataType() == AchievementData.DataType.PersonalRecordData ||
                    data.get(position).getDataType() == AchievementData.DataType.VirtualRaceData ) {
                return DATA_CELL;
            } else {
                return EMPTY_CELL;
            }
        }

        @Override
        public void onBindViewHolder(@NonNull MedalCaseViewHolder holder, int position) {
            //Item is first header
            int dataType = getItemViewType(position);
            if(position == 0) {
                holder.title.setText(data.get(position).getHeaderTitle());
                holder.title.setVisibility(View.VISIBLE);
                holder.pageCount.setText("4 of 6");
                holder.pageCount.setVisibility(View.VISIBLE);
            } else if(dataType == HEADER && position > 0 ) {
                holder.title.setText(data.get(position).getHeaderTitle());
                holder.title.setVisibility(View.VISIBLE);
                holder.pageCount.setVisibility(View.INVISIBLE);
            } else if(dataType == DATA_CELL) {
                int id = getResources().getIdentifier(data.get(position).getMedal().icon, "drawable", getContext().getPackageName());
                holder.imageView.setImageResource(id);
            } else {
                holder.imageView.setImageDrawable(null);
            }
        }

        @Override
        public int getItemCount() {
            if(data == null) {
                return  0;
            }
            return data.size();
        }
    }

    private class MedalCaseViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        TextView pageCount;

        public MedalCaseViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            imageView = itemView.findViewById(R.id.medalImage);
            title = itemView.findViewById(R.id.pagerHeaderTitle);
            pageCount = itemView.findViewById(R.id.pagerHeaderCount);
        }
    }

}
