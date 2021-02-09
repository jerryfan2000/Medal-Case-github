package com.jerry.medalcase.data.ViewModel;

import com.jerry.medalcase.data.Repository;
import com.jerry.medalcase.data.gson.Achievement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AchievementViewModel extends ViewModel {

    private final LiveData<Achievement> achievementLiveData;

    public AchievementViewModel(Repository dataSrc) {
        achievementLiveData = dataSrc.getAchievement();
    }

    public LiveData<Achievement> getAchievementLiveData() {
        return achievementLiveData;
    }
}
