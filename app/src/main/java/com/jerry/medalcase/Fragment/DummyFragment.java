package com.jerry.medalcase.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerry.medalcase.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DummyFragment extends Fragment {

    private TextView textView1;
    private int viewing;
    private int total;
    private TextView headerTitle;
    private TextView HeaderPagerCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_dummy, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView1 = view.findViewById(R.id.textView1);
        headerTitle = view.findViewById(R.id.pagerHeaderTitle);
        HeaderPagerCount = view.findViewById(R.id.pagerHeaderCount);

        String title = getActivity().getResources().getString(R.string.currentViewing);
        title = title.replace("%1","" + viewing);
        title = title.replace("%2","" + total);

        textView1.setText("You are viewing page: " + viewing);
        headerTitle.setText("Dummy Page" + viewing);
        HeaderPagerCount.setText(title);
    }

    public void setInfoText(int viewing, int total) {
        this.viewing = viewing;
        this.total = total;
    }
}
