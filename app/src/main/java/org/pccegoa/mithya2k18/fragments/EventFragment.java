package org.pccegoa.mithya2k18.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.pccegoa.mithya2k18.R;
import org.pccegoa.mithya2k18.adapter.EventAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements  ValueEventListener {

    public static final String ACE_EVENT = "ace_event";
    public static final String KING_EVENT = "king_event";
    public static final String QUEEN_EVENT = "queen_event";
    public static final String JACK_EVENT = "jack_event";
    private String mEventType = null;
    private DatabaseReference reference = null;
    private GridView gridView = null;
    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState!=null)
            mEventType = savedInstanceState.getString("EVENT_TYPE");
        reference = FirebaseDatabase.getInstance().getReference("events");
        Query query = null;
        gridView = getView().findViewById(R.id.gridview);
        if (mEventType.equals(ACE_EVENT))
            query = reference.orderByChild("category").equalTo("A");
        else if(mEventType.equals(KING_EVENT))
            query = reference.orderByChild("category").equalTo("K");
        else if(mEventType.equals(QUEEN_EVENT))
            query = reference.orderByChild("category").equalTo("Q");
        else if(mEventType.equals(JACK_EVENT))
            query = reference.orderByChild("category").equalTo("J");
        query.addValueEventListener(this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventAdapter eventAdapter =(EventAdapter) parent.getAdapter();
                Map<String,Object> item = (Map<String,Object> )
                        eventAdapter.getItem(position);
                String idEvent = (String) item.get("id");
                String eventName = (String)item.get("event_name");
                String[] rules = getResources().getStringArray(R.array.event_rules);

                Bundle arguments = new Bundle();
                arguments.putString(RulesFragment.EVENT_NAME_ARG,eventName);
                arguments.putString(RulesFragment.EVENT_RULES_ARG,rules[Integer.parseInt(idEvent)]);
                RulesFragment rulesFragment = new RulesFragment();
                rulesFragment.setArguments(arguments);
                rulesFragment.show(getActivity().getSupportFragmentManager(),"fragment");
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("EVENT_TYPE",mEventType);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    public String getmEventType() {
        return mEventType;
    }

    public void setmEventType(String mEventType) {
        this.mEventType = mEventType;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
        List<Map<String,Object>> events = new ArrayList<>();
        for (DataSnapshot snapshot:iterable)
        {
            String key = snapshot.getKey();
            Map<String,Object> map = (Map<String, Object>) snapshot.getValue();
            if (key.equals("0"))
                map.put("event_name","Fashion Parade");
            else if (key.equals("2"))
                map.put("event_name","Show of Strength");
            else if (key.equals("1")||key.equals("3")||key.equals("4"))//sos and fashion parade
                continue;
            events.add(map);
        }

        EventAdapter eventAdapter = new EventAdapter(getContext(),events);
        gridView.setAdapter(eventAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
