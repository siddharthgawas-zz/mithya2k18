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
    private int[] aceScore = {2000,1500,1000};
    private int[] kingScore = {1000,750,500};
    private int[] queenScore = {750,500,250};
    private int[] jackScore = {300,200,100};
    private List<Map<String,Object>> events;

    public List<Map<String, Object>> getEvents() {
        return events;
    }

    public void setEvents(List<Map<String, Object>> events) {
        this.events = events;
    }

    public int[] getAceScore() {
        return aceScore;
    }

    public void setAceScore(int[] aceScore) {
        this.aceScore = aceScore;
    }

    public int[] getKingScore() {
        return kingScore;
    }

    public void setKingScore(int[] kingScore) {
        this.kingScore = kingScore;
    }

    public int[] getQueenScore() {
        return queenScore;
    }

    public void setQueenScore(int[] queenScore) {
        this.queenScore = queenScore;
    }

    public int[] getJackScore() {
        return jackScore;
    }

    public void setJackScore(int[] jackScore) {
        this.jackScore = jackScore;
    }

    public int getTotalScoreOf(String department)
    {
        int score = 0;
        for (int i = 0; i <events.size();i++)
        {
            String id = (String) events.get(i).get("id");
            //MR and MISS PCCE
            if(id.equals("6"))
            {
                Map<String, String> firstPlace = (Map<String, String>)
                        events.get(i).get("first_place");
                Map<String, String> secondPlace =
                        (Map<String, String>) events.get(i).get("second_place");
                Map<String, String> thirdPlace =
                        (Map<String, String>) events.get(i).get("third_place");

                String[] departments = firstPlace.get("department").split(",");
                if (departments[0].equals(department)||departments[1].equals(department))
                    score += aceScore[0]/2;

            }
            Map<String, String> firstPlace = (Map<String, String>)
                    events.get(i).get("first_place");
            Map<String, String> secondPlace =
                    (Map<String, String>) events.get(i).get("second_place");
            Map<String, String> thirdPlace =
                    (Map<String, String>) events.get(i).get("third_place");

            if (firstPlace.get("department").equals(department))
            {
                if (events.get(i).get("category").equals("A"))
                    score += aceScore[0];
                else if (events.get(i).get("category").equals("K"))
                    score += kingScore[0];
                else if (events.get(i).get("category").equals("Q"))
                    score += queenScore[0];
                else if (events.get(i).get("category").equals("J"))
                    score += jackScore[0];
            }
            if (secondPlace.get("department").equals(department))
            {
                if (events.get(i).get("category").equals("A"))
                    score += aceScore[1];
                else if (events.get(i).get("category").equals("K"))
                    score += kingScore[1];
                else if (events.get(i).get("category").equals("Q"))
                    score += queenScore[1];
                else if (events.get(i).get("category").equals("J"))
                    score += jackScore[1];
            }
            if (thirdPlace.get("department").equals(department))
            {
                if (events.get(i).get("category").equals("A"))
                    score += aceScore[2];
                else if (events.get(i).get("category").equals("K"))
                    score += kingScore[2];
                else if (events.get(i).get("category").equals("Q"))
                    score += queenScore[2];
                else if (events.get(i).get("category").equals("J"))
                    score += jackScore[2];
            }

        }
        return score;
    }
}
