package com.jerry.medalcase.data;

import android.util.Log;

import com.google.gson.Gson;
import com.jerry.medalcase.data.gson.Achievement;
import com.jerry.medalcase.data.gson.Medal;
import com.jerry.medalcase.data.gson.PersonalRecord;
import com.jerry.medalcase.data.gson.VirtualRace;

import java.util.ArrayList;
import java.util.List;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Repository {

    public static final String MockData = "{\n" +
            "  \"PersonalRecords\": {\n" +
            "    \"Medals\": [\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"ic_longest_run\",\n" +
            "        \"title\": \"Longest Run\",\n" +
            "        \"value\": \"100km\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"ic_highest_elevation\",\n" +
            "        \"title\": \"Highest Elevation\",\n" +
            "        \"value\": \"2095ft\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"ic_fastest_5k\",\n" +
            "        \"title\": \"Fastest 5k\",\n" +
            "        \"value\": \"00:32:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"ic_fastest_10k\",\n" +
            "        \"title\": \"10k\",\n" +
            "        \"value\": \"1:22:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"ic_fastest_half_marathon\",\n" +
            "        \"title\": \"Half Marathon\",\n" +
            "        \"value\": \"2:44:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": false,\n" +
            "        \"icon\": \"ic_fastest_marathon\",\n" +
            "        \"title\": \"Marathon\",\n" +
            "        \"value\": \"Not Yet\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"VirtualRaces\": {\n" +
            "    \"Medals\": [\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"virtual_half_marathon_race\",\n" +
            "        \"title\": \"Virtual Half Marathon\",\n" +
            "        \"value\": \"100km\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"tokyo_kakone_ekiden\",\n" +
            "        \"title\": \"Tokyo-Hakone Ekiden\",\n" +
            "        \"value\": \"2095ft\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"virtual_10k_race\",\n" +
            "        \"title\": \"Virtual 10k Race\",\n" +
            "        \"value\": \"01:22:22\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"hakone_ekiden\",\n" +
            "        \"title\": \"Hakone Ekiden\",\n" +
            "        \"value\": \"1:11:20\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"mizuno_singapore_ekiden\",\n" +
            "        \"title\": \"Mizuno Singapore Ekiden\",\n" +
            "        \"value\": \"2:44:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": true,\n" +
            "        \"icon\": \"virtual_5k_race\",\n" +
            "        \"title\": \"Virtual 5k\",\n" +
            "        \"value\": \"00:28:21\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"earned\": false,\n" +
            "        \"icon\": \"virtual_10k_race\",\n" +
            "        \"title\": \"Virtual 10k\",\n" +
            "        \"value\": \"Not Yet\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public void toJson() {
        Achievement achievement = new Achievement();

        PersonalRecord p1 = new PersonalRecord();
        List<Medal> medals = new ArrayList<>();
        Medal m1 = new Medal();
        m1.icon = "ic_longest_run";
        m1.title = "Longest Run";
        m1.value = "100km";
        m1.earned = true;

        Medal m2 = new Medal();
        m2.icon = "ic_highest_elevation";
        m2.title = "Highest Elevation";
        m2.value = "2095ft";
        m2.earned = true;

        Medal m3 = new Medal();
        m3.icon = "ic_fastest_5k";
        m3.title = "Fastest 5k";
        m3.value = "00:32:00";
        m3.earned = true;

        Medal m4 = new Medal();
        m4.icon = "ic_fastest_10k";
        m4.title = "10k";
        m4.value = "1:22:00";
        m4.earned = true;

        Medal m5 = new Medal();
        m5.icon = "ic_fastest_half_marathon";
        m5.title = "Half Marathon";
        m5.value = "2:44:00";
        m5.earned = true;

        Medal m6 = new Medal();
        m6.icon = "ic_fastest_marathon";
        m6.title = "Marathon";
        m6.value = "Not Yet";
        m6.earned = false;

        medals.add(m1);
        medals.add(m2);
        medals.add(m3);
        medals.add(m4);
        medals.add(m5);
        medals.add(m6);

        p1.Medals = medals;

        VirtualRace vr = new VirtualRace();
        medals = new ArrayList<>();
        m1 = new Medal();
        m1.icon = "virtual_half_marathon_race";
        m1.title = "Virtual Half Marathon";
        m1.value = "100km";
        m1.earned = true;

        m2 = new Medal();
        m2.icon = "tokyo_kakone_ekiden";
        m2.title = "Tokyo-Hakone Ekiden";
        m2.value = "2095ft";
        m2.earned = true;

        m3 = new Medal();
        m3.icon = "virtual_10k_race";
        m3.title = "Virtual 10k Race";
        m3.value = "01:22:22";
        m3.earned = true;

        m4 = new Medal();
        m4.icon = "hakone_ekiden";
        m4.title = "Hakone Ekiden";
        m4.value = "1:11:20";
        m4.earned = true;

        m5 = new Medal();
        m5.icon = "mizuno_singapore_ekiden";
        m5.title = "Mizuno Singapore Ekiden";
        m5.value = "2:44:00";
        m5.earned = true;

        m6 = new Medal();
        m6.icon = "virtual_5k_race";
        m6.title = "Virtual 5k";
        m6.value = "00:28:21";
        m6.earned = true;

        Medal m7 = new Medal();
        m7.icon = "virtual_10k_race";
        m7.title = "Virtual 10k";
        m7.value = "Not Yet";
        m7.earned = false;

        medals.add(m1);
        medals.add(m2);
        medals.add(m3);
        medals.add(m4);
        medals.add(m5);
        medals.add(m6);
        medals.add(m7);


        vr.Medals = medals;

        achievement.PersonalRecords = p1;
        achievement.VirtualRaces = vr;

        Gson gson = new Gson();
        String out = gson.toJson(achievement);
        Log.d("jerry", out);
    }

    public LiveData<Achievement> getAchievement() {
        Gson gson = new Gson();
        MutableLiveData<Achievement> ret = new MutableLiveData<Achievement>();
        ret.setValue(gson.fromJson(MockData, Achievement.class));
        return ret;
    }
}
