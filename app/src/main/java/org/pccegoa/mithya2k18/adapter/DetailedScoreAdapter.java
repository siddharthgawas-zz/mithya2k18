package org.pccegoa.mithya2k18.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pccegoa.mithya2k18.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Siddharth on 4/3/2018.
 */

public class DetailedScoreAdapter extends RecyclerView.Adapter<DetailedScoreAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout scoreListItem ;

        public ViewHolder(ConstraintLayout scoreListItem) {
            super(scoreListItem);
            this.scoreListItem = scoreListItem;
        }
    }
    private Context context;
    private List<Map<String,Object>> mEventScores = null;
    public static final String ETC_SCORE = "etc_score";
    public static final String CE_SCORE = "ce_score";
    public static final String ME_SCORE = "me_score";
    public static final String IT_SCORE = "it_score";
    private String mDepartment = null;

    public DetailedScoreAdapter(Context context,List<Map<String,Object>> eventScores, String dept) {
        super();
        this.context = context;
        this.mEventScores = eventScores;
        mDepartment = dept;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout rootView = (ConstraintLayout) LayoutInflater.from(
                parent.getContext()).inflate(R.layout.score_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.scoreListItem.setBackgroundColor(context.getResources().
                    getColor(R.color.leaderBoard1));
        else
            holder.scoreListItem.setBackgroundColor(context.getResources().
                    getColor(R.color.leaderBoard2));

        TextView eventName = holder.scoreListItem.findViewById(R.id.eventNameTextView);
        TextView eventType = holder.scoreListItem.findViewById(R.id.eventCategoryTextView);
        TextView eventScore = holder.scoreListItem.findViewById(R.id.eventScoreTextView);
        TextView eventPosition = holder.scoreListItem.findViewById(R.id.eventPositionTextView);

        Map<String,Object> event = mEventScores.get(position);
        eventName.setText((String)event.get("event_name"));
        eventScore.setText(getScoreOfEvent(position)+"");

        if(decidePosition(position)==1)
            eventPosition.setText("1st");

        else if(decidePosition(position)==2)
            eventPosition.setText("2nd");

        else if(decidePosition(position)==3)
            eventPosition.setText("3rd");
        else
            eventPosition.setText("Last");
        eventType.setText(getCategory(position));
    }

    @Override
    public int getItemCount() {
        return mEventScores.size();
    }

    public void sortBasedOnCategories()
    {
        List<Map<String,Object>> temp = new ArrayList<>();
        String[] sortEvent = {"A","K","Q","J"};
        for (int i = 0; i <sortEvent.length;i++)
        {
            for (int j  = 0; j < mEventScores.size();j++)
            {
                Map<String,Object> map = mEventScores.get(j);
                if(((String)map.get("category")).equals(sortEvent[i]))
                    temp.add(map);
            }
        }
        mEventScores = temp;
    }

    private String getCategory(int index)
    {
        Map<String,Object> event = mEventScores.get(index);
        if(event.get("category").equals("A"))
            return "Ace";
        if(event.get("category").equals("K"))
            return "King";
        if(event.get("category").equals("Q"))
            return "Queen";
        if(event.get("category").equals("J"))
            return "Jack";

        return "";
    }
    private int decidePosition(int index)
    {
        Map<String,Object> event = mEventScores.get(index);
        int score = getScoreOfEvent(index);
        ArrayList<Integer> scores = getScoresOfEvent(index);
        Collections.sort(scores);
        Collections.reverse(scores);
        return scores.indexOf(score)+1;
    }

    private int getScoreOfEvent(int index)
    {
        Map<String,Object> event = mEventScores.get(index);
        String score = (String) event.get(mDepartment);
        if (score.equals(""))
            return 0;
        return  Integer.parseInt(score);
    }

    private ArrayList<Integer> getScoresOfEvent(int index)
    {
        ArrayList<Integer> scores = new ArrayList<>();
        Map<String,Object> event = mEventScores.get(index);
        String score = (String) event.get(ETC_SCORE);
        if(score.equals(""))
            scores.add(0);
        else
            scores.add(Integer.parseInt(score));
        score = (String) event.get(CE_SCORE);
        if(score.equals(""))
            scores.add(0);
        else
            scores.add(Integer.parseInt(score));
        score = (String) event.get(IT_SCORE);
        if(score.equals(""))
            scores.add(0);
        else
            scores.add(Integer.parseInt(score));
        score = (String) event.get(ME_SCORE);
        if(score.equals(""))
            scores.add(0);
        else
            scores.add(Integer.parseInt(score));
        return scores;
    }
}
