package com.jerry.medalcase.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jerry.medalcase.R;
import com.jerry.medalcase.data.ViewModel.AchievementViewModel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class AchievementFragment extends Fragment {

    RecyclerView medalCase;
    AchievementViewModel achievementViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.farg_achievement, null);
        return rootView;
    }

    private class MedalCaseAdapter extends RecyclerView.Adapter<MedalCaseViewHolder> {

        @NonNull
        @Override
        public MedalCaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull MedalCaseViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class MedalCaseViewHolder extends RecyclerView.ViewHolder {

        public MedalCaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
