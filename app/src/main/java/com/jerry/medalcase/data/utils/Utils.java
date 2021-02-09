package com.jerry.medalcase.data.utils;

import com.jerry.medalcase.data.ViewModel.AchievementData;
import com.jerry.medalcase.data.gson.Achievement;
import com.jerry.medalcase.data.gson.Medal;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static ArrayList<AchievementData> populateData(Achievement achievement) {
        List<Medal> prMedals = achievement.PersonalRecords.Medals;
        List<Medal> vrMedals = achievement.VirtualRaces.Medals;
        ArrayList<AchievementData> processedData = new ArrayList<>();

        //Populate Personal Records. Insert Personal Recording header at the beginning
        processedData.add(AchievementData.newHeader("Personal Records"));
        for(int x=0; x<prMedals.size(); x++) {
            processedData.add(AchievementData.newPersonalRecordData(prMedals.get(x)));
        }

        if(prMedals.size()%2 != 0) {
            //If number of Personal Records is odd number, insert an empty cell
            processedData.add(AchievementData.newEmptyCell());
        }

        //Populate VR Race. Insert VR Race header at the beginning
        processedData.add(AchievementData.newHeader("Virtual Races"));
        for(int x=0; x<vrMedals.size(); x++) {
            processedData.add(AchievementData.newVirtualRaceData(vrMedals.get(x)));
        }

        if(vrMedals.size()%2 != 0) {
            //If number of Personal Records is odd number, insert an empty cell
            processedData.add(AchievementData.newEmptyCell());
        }

        return processedData;
    }
}
