package com.jerry.medalcase.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jerry.medalcase.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class WelcomeFragment extends Fragment {

    Button about;
    Button profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupAppBar(getString(R.string.app_name));
        View rootView = inflater.inflate(R.layout.frag_welcome, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        about = view.findViewById(R.id.about);
        profile = view.findViewById(R.id.profile);
        bindUIAction();
    }

    private void bindUIAction() {
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentFragment(v.getId());
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentFragment(v.getId());
            }
        });
    }

    private void setContentFragment(int id) {
        Fragment switchTo;
        String title = "";
        if(id == R.id.about) {
            switchTo = new AboutFragment();
            title = getString(R.string.about);
        } else if(id == R.id.profile) {
            switchTo = new ProfileFragment();
            title = getString(R.string.profile);
        } else {
            return;
        }

        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, switchTo)
                .addToBackStack(null)
                .commitAllowingStateLoss();
        setupAppBar(title);
    }

    private void setupAppBar(String title) {
        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        TextView textView = new TextView(getContext());
        textView.setText(title);
        textView.setTextSize(20);
        if(!title.equals(getString(R.string.app_name))) {
            textView.setPadding(0, 0, getResources().getDimensionPixelOffset(R.dimen.actionBar_text_right_padding), 0);
        }
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.actionbarTitle));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.actionBar_text_size));
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(textView);
    }



}
