package org.pccegoa.mithya2k18.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pccegoa.mithya2k18.R;
import org.pccegoa.mithya2k18.adapter.ScheduleAdapter;
import org.pccegoa.mithya2k18.utility.EventFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DAY1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DAY1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DAY1 extends Fragment implements ValueEventListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Date d1 = new Date();
    private Date d2 = new Date();
    private OnFragmentInteractionListener mListener;

    public DAY1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DAY1.
     */
    // TODO: Rename and change types and number of parameters
    public static DAY1 newInstance(String param1, String param2) {
        DAY1 fragment = new DAY1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private DatabaseReference reference = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Map<String,Object>> schedule = new ArrayList<>();
        for(DataSnapshot snapshot:dataSnapshot.getChildren())
            schedule.add((Map<String,Object>)snapshot.getValue());
        schedule = EventFilter.getEventsBetweenTime(d1,d2,schedule);
        schedule = EventFilter.sort(schedule);
        if(getContext() == null)
            return;
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getContext(),R.layout.schedule_item
        ,schedule);
        if(getView()==null)
            return;
        ListView listView = getView().findViewById(R.id.day1_list);
        listView.setAdapter(scheduleAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            d1 = format.parse("11-04-2018 00:00");
            d2 = format.parse("11-04-2018 23:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reference = FirebaseDatabase.getInstance().getReference("schedule");
        reference.addValueEventListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
