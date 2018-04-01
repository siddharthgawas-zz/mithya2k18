package org.pccegoa.mithya2k18.utility;

import java.util.List;
import java.util.Map;

/**
 * Created by Siddharth on 3/30/2018.
 */

public class ScoreCounter {
    public final static String CE = "CE";
    public  final static String ME = "ME";
    public  final static String IT = "IT";
    public  final static String ETC = "ETC";
    private List<Map<String,Object>> events;

    public List<Map<String, Object>> getEvents() {
        return events;
    }

    public void setEvents(List<Map<String, Object>> events) {
        this.events = events;
    }


    public int getTotalScoreOf(String department)
    {
        String dbKey = "";
        if(department.equals(CE))
            dbKey = "ce_score";
        else if(department.equals(ME))
            dbKey = "me_score";
        else if (department.equals(ETC))
            dbKey = "etc_score";
        else if (department.equals(IT))
            dbKey = "it_score";
        else
            return 0;
        int score = 0;
        for (Map<String,Object> event: events)
        {
            if (((String) event.get(dbKey)).equals(""))
                continue;
            score+=Integer.parseInt((String)event.get(dbKey));
        }
        return score;
    }
}
