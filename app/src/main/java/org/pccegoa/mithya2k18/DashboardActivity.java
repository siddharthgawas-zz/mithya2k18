package org.pccegoa.mithya2k18;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.pccegoa.mithya2k18.utility.ScoreCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        ValueEventListener, View.OnClickListener{

    private DatabaseReference mDatabase = null;
    private ImageView firstImageView = null;
    private ImageView secondImageView = null;
    private ImageView thirdImageView = null;
    private ImageView lastImageView = null;
        ImageView scoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance()
                .getReference("scores");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


        mDatabase.addValueEventListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        scoreButton=(ImageView) findViewById(R.id.ScorePic);
        ImageView scheduleButton=(ImageView) findViewById(R.id.schedulePic);
        ImageView eventsButton=(ImageView) findViewById(R.id.eventsPic);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        firstImageView = findViewById(R.id.firstPositionImageView);
        secondImageView = findViewById(R.id.secondPositionImageView);
        thirdImageView = findViewById(R.id.thirdPositionImageView);
        lastImageView = findViewById(R.id.lastPositionImageView);

        ImageView imageView = findViewById(R.id.schedulePic);
        imageView.setOnClickListener(this);
        imageView = findViewById(R.id.eventsPic);
        imageView.setOnClickListener(this);
        imageView = findViewById(R.id.ScorePic);
        imageView.setOnClickListener(this);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20

        MyBounceInterpolator interpolator1 = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator1);
        scheduleButton.startAnimation(myAnim);
        MyBounceInterpolator interpolator2 = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator2);
        eventsButton.startAnimation(myAnim);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        scoreButton.startAnimation(myAnim);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.eventsPic:
                Intent i = new Intent(this,EventsActivity.class);
                startActivity(i);
                break;
            case R.id.schedulePic:
                Intent schedulebutton=new Intent(this,ScheduleActivity.class);
                startActivity(schedulebutton);
                break;
            case R.id.ScorePic:
                Intent score=new Intent(this,DeptScore.class);
                startActivity(score);
                break;
            default:
                break;
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this,DashboardActivity.class);
            startActivity(intent);
        } else if (id == R.id.events) {
            Intent i = new Intent(this,EventsActivity.class);
            startActivity(i);

        } else if (id == R.id.schedule) {
            Intent intent = new Intent(this,ScheduleActivity.class);
            startActivity(intent);


        } else if (id == R.id.score) {
            Intent score=new Intent(this,DeptScore.class);
            startActivity(score);

        } else if (id == R.id.team) {
            Intent intent = new Intent(this,TeamActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.about)
        {
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.developers)
        {
            Intent intent = new Intent(this,DevelopersActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
        setPositions(compScore,mechScore,itScore,etcScore);
        handleSameScoreSituation();

    }

    private void setPositions(int comp, int mech, int it, int etc)
    {
        if(comp == 0 && mech == 0 && it == 0 && etc == 0)
        {
            firstImageView.setVisibility(View.GONE);
           secondImageView.setVisibility(View.GONE);
            thirdImageView.setVisibility(View.GONE);
            lastImageView.setVisibility(View.GONE);
            return;
        }
        firstImageView.setVisibility(View.VISIBLE);
        secondImageView.setVisibility(View.VISIBLE);
        thirdImageView.setVisibility(View.VISIBLE);
        lastImageView.setVisibility(View.VISIBLE);

        ArrayList<Pair<String,Integer>> scores = new ArrayList<>();
        scores.add(new Pair<String, Integer>("COMP",comp));
        scores.add(new Pair<String, Integer>("MECH",mech));
        scores.add(new Pair<String, Integer>("IT",it));
        scores.add(new Pair<String, Integer>("ETC",etc));

       Pair<String,Integer> score = getMaxScore(scores);
       scores.remove(score);
       TextView placeTextView = findViewById(R.id.firstPlace);
       TextView scoreTextView = findViewById(R.id.firstScore);
       placeTextView.setText(score.first);
       scoreTextView.setText(score.second+"");

        score = getMaxScore(scores);
        scores.remove(score);
        placeTextView = findViewById(R.id.secondPlace);
        scoreTextView = findViewById(R.id.secondScore);
        placeTextView.setText(score.first);
        scoreTextView.setText(score.second+"");

        score = getMaxScore(scores);
        scores.remove(score);
        placeTextView = findViewById(R.id.thirdPlace);
        scoreTextView = findViewById(R.id.thirdScore);
        placeTextView.setText(score.first);
        scoreTextView.setText(score.second+"");

        score = getMaxScore(scores);
        scores.remove(score);
        placeTextView = findViewById(R.id.forthPlace);
        scoreTextView = findViewById(R.id.forthScore);
        placeTextView.setText(score.first);
        scoreTextView.setText(score.second+"");

    }

    private void handleSameScoreSituation()
    {
        int[] textViewInts = {R.id.firstScore,R.id.secondScore,R.id.thirdScore,R.id.forthScore};
        int[] imageViews = {R.id.firstPositionImageView,R.id.secondPositionImageView,
        R.id.thirdPositionImageView,R.id.lastPositionImageView};
        for (int i = 1; i <4;i++)
        {
            TextView t1 = findViewById(textViewInts[i]);
            TextView t2 = findViewById(textViewInts[i-1]);
            if(t1.getText().equals(t2.getText()))
            {
                ImageView imageView = findViewById(imageViews[i]);
                imageView.setVisibility(View.INVISIBLE);
            }
        }
    }
    private Pair<String, Integer> getMaxScore( ArrayList<Pair<String,Integer>> scores)
    {
        int max = 0;
        for(int i = 0; i < scores.size();i++)
        {
            if(scores.get(i).second > scores.get(max).second)
                max = i;
        }
        return scores.get(max);
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show();
    }
}
