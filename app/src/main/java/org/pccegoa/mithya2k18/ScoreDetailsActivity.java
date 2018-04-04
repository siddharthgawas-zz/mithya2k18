package org.pccegoa.mithya2k18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pccegoa.mithya2k18.adapter.DetailedScoreAdapter;
import org.pccegoa.mithya2k18.fragment.ScoreKeyFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScoreDetailsActivity extends AppCompatActivity  implements ValueEventListener{
    public static final String DEPARTMENT_ARG = "dept_arg";
    private Toolbar mToolbar = null;
    private RecyclerView mRecyclerView = null;
    private DetailedScoreAdapter mAdapter = null;
    private DatabaseReference reference = null;
    private String mDepartment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_details);

        reference = FirebaseDatabase.getInstance().getReference("scores");
        reference.addValueEventListener(this);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mDepartment = getIntent().getStringExtra(DEPARTMENT_ARG);

        if(mDepartment.equals(DetailedScoreAdapter.ME_SCORE))
            mToolbar.setTitle("Mechanical Score List");
        if(mDepartment.equals(DetailedScoreAdapter.CE_SCORE))
            mToolbar.setTitle("Computer Score List");
        if(mDepartment.equals(DetailedScoreAdapter.ETC_SCORE))
            mToolbar.setTitle("ETC Score List");
        if(mDepartment.equals(DetailedScoreAdapter.IT_SCORE))
            mToolbar.setTitle("IT Score List");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.score_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.scoreKeyMenu)
        {
            ScoreKeyFragment fragment = new ScoreKeyFragment();
            fragment.show(getSupportFragmentManager(),"Fragment");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
        List<Map<String,Object>> events = new ArrayList<>();
        for (DataSnapshot snapshot:iterable)
        {
            String key = snapshot.getKey();
            Map<String,Object> map = (Map<String, Object>) snapshot.getValue();
            events.add(map);
        }
        DetailedScoreAdapter adapter = new DetailedScoreAdapter(this,events,
                DetailedScoreAdapter.CE_SCORE);
        adapter.sortBasedOnCategories();
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
