package org.pccegoa.mithya2k18;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.pccegoa.mithya2k18.fragment.EventFragment;

public class EventsActivity extends AppCompatActivity {

    private ViewPager viewPager = null;
    private TabLayout tabLayout = null;
    private EventPageAdapter pageAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_events);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        pageAdapter = new EventPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    public class EventPageAdapter extends FragmentPagerAdapter {
        public EventPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            EventFragment eventFragment = new EventFragment();
            if(position == 0)
                eventFragment.setmEventType(EventFragment.ACE_EVENT);
            else if(position == 1)
                eventFragment.setmEventType(EventFragment.KING_EVENT);
            else if(position == 2)
                eventFragment.setmEventType(EventFragment.QUEEN_EVENT);
            else if (position == 3)
                eventFragment.setmEventType(EventFragment.JACK_EVENT);
            return eventFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0)
                return "Ace";
            else if(position == 1)
                return "King";
            else if(position == 2)
                return "Queen";
            else
                return "Jack";
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
