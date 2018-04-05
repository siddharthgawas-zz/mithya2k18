package org.pccegoa.mithya2k18.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.pccegoa.mithya2k18.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sid on 4/4/18.
 */

public class ScheduleAdapter extends ArrayAdapter<Map<String,Object>>{
    private List<Map<String,Object>> mEvents = null;

    public ScheduleAdapter(@NonNull Context context, int resource, @NonNull List<Map<String, Object>> objects) {
        super(context, resource, objects);
        mEvents = objects;
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Nullable
    @Override
    public Map<String, Object> getItem(int position) {
        return mEvents.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.schedule_item,parent,
                false);
        if(position % 2 != 0)
            ((ConstraintLayout)rootView).setBackgroundColor(getContext().getResources().
                    getColor(R.color.leaderBoard1));
        TextView eventName = rootView.findViewById(R.id.eventNameTextView);
        TextView eventCategory = rootView.findViewById(R.id.eventCategoryTextView);
        TextView location = rootView.findViewById(R.id.locationTextView);
        TextView time = rootView.findViewById(R.id.timeTextView);

        Map<String,Object> event = mEvents.get(position);
        eventName.setText((String)mEvents.get(position).get("event_name"));
        location.setText((String)mEvents.get(position).get("location"));

        if(event.get("category").equals("A"))
            eventCategory.setText("Ace");
        else if(event.get("category").equals("K"))
            eventCategory.setText("King");
        else if(event.get("category").equals("Q"))
            eventCategory.setText("Queen");
        else if(event.get("category").equals("J"))
            eventCategory.setText("Jack");

        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date d = format2.parse((String) event.get("time"));
            String timeString = format.format(d);
            time.setText(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return rootView;

    }
}
