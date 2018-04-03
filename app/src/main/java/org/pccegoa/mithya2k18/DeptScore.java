package org.pccegoa.mithya2k18;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pccegoa.mithya2k18.adapter.DetailedScoreAdapter;
import org.pccegoa.mithya2k18.utility.ScoreCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeptScore extends AppCompatActivity implements ValueEventListener {

    PieChart ScoreChart;
    private DatabaseReference ref = null;
    private Toolbar mToolbar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept_score);

        ScoreChart = (PieChart) findViewById(R.id.deptScorechart);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ref = FirebaseDatabase.getInstance().getReference("scores");
        ref.addValueEventListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> iterable  = dataSnapshot.getChildren();
        List<Map<String,Object>> events = new ArrayList<>();
        for(DataSnapshot s:iterable)
        {
            String key = s.getKey();
            Map<String, Object> event = (Map<String, Object> )s.getValue();
            events.add(event);
        }

        ScoreCounter counter = new ScoreCounter();
        counter.setEvents(events);
        int compScore = counter.getTotalScoreOf(ScoreCounter.CE);
        int mechScore = counter.getTotalScoreOf(ScoreCounter.ME);
        int itScore = counter.getTotalScoreOf(ScoreCounter.IT);
        int etcScore = counter.getTotalScoreOf(ScoreCounter.ETC);
        updatePieChart(mechScore,compScore,etcScore,itScore);
        ScoreChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                PieEntry entry = (PieEntry)e;
                String departmentScore = null;
                if (((PieEntry) e).getLabel().equals("MECH"))
                    departmentScore = DetailedScoreAdapter.ME_SCORE;
                else if (((PieEntry) e).getLabel().equals("COMP"))
                    departmentScore = DetailedScoreAdapter.CE_SCORE;
                else if (((PieEntry) e).getLabel().equals("ETC"))
                    departmentScore = DetailedScoreAdapter.ETC_SCORE;
                else if (((PieEntry) e).getLabel().equals("IT"))
                    departmentScore = DetailedScoreAdapter.IT_SCORE;
                else
                    return;
                Intent i = new Intent(getApplicationContext(),ScoreDetailsActivity.class);
                i.putExtra(ScoreDetailsActivity.DEPARTMENT_ARG,departmentScore);
                startActivity(i);
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    public void updatePieChart(int Mscore, int Cscore, int Escore, int Iscore) {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(Mscore, "MECH"));
        entries.add(new PieEntry(Cscore, "COMP"));
        entries.add(new PieEntry(Escore, "ETC"));
        entries.add(new PieEntry(Iscore, "IT"));
        PieDataSet set = new PieDataSet(entries, "");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(set);
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        ScoreChart.setData(data);
        set.setValueFormatter(new LargeValueFormatter());
        ScoreChart.getDescription().setEnabled(false);
        ScoreChart.setHoleRadius(5);
        ScoreChart.setExtraBottomOffset(25);
        ScoreChart.invalidate();
        ScoreChart.setTransparentCircleAlpha(0);
        Legend legend = ScoreChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        ScoreChart.animateXY(1000,1000);
    }
}
