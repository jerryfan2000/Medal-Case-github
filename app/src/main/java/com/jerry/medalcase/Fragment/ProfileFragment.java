package com.jerry.medalcase.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jerry.medalcase.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ProfileFragment extends Fragment {

    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_profile, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(new profilePagerAdapter(getChildFragmentManager()));
    }

    private class profilePagerAdapter extends FragmentPagerAdapter {

        public profilePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment switchTo;
            if(position == 3) {
                switchTo = new AchievementFragment();
            } else {
                switchTo = new DummyFragment();
                int pageNum = position + 1;
                ((DummyFragment) switchTo).setInfoText(pageNum, getCount());
            }
            return switchTo;
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}
