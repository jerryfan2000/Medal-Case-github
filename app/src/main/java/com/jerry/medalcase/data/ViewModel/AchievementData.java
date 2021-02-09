package com.jerry.medalcase.data.ViewModel;

import com.jerry.medalcase.data.gson.Achievement;
import com.jerry.medalcase.data.gson.Medal;

public class AchievementData {
    public enum DataType { PersonalRecordData, VirtualRaceData, Header, EmptyCell }
    private Medal data;
    private DataType dataType;
    private String headerTitle;

    private AchievementData(Medal data, DataType type) {
        this.data = data;
        this.dataType = type;
    }

    private AchievementData(String title) {
        this.dataType = DataType.Header;
        this.headerTitle = title;
    }

    private AchievementData() {
        this.dataType = DataType.EmptyCell;
    }

    public Medal getMedal() {
        return data;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public DataType getDataType() {
        return dataType;
    }

    public static AchievementData newVirtualRaceData(Medal data) {
        return new AchievementData(data, DataType.VirtualRaceData);
    }

    public static AchievementData newPersonalRecordData(Medal data) {
        return new AchievementData(data, DataType.PersonalRecordData);
    }

    public static AchievementData newHeader(String title) {
        return new AchievementData(title);
    }

    public static AchievementData newEmptyCell() {
        return new AchievementData();
    }
}
