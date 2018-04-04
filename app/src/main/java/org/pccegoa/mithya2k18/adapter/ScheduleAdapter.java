package org.pccegoa.mithya2k18.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.pccegoa.mithya2k18.R;

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
        return rootView;

    }
}
