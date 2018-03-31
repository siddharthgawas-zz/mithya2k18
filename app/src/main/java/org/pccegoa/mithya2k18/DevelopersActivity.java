package org.pccegoa.mithya2k18;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DevelopersActivity extends AppCompatActivity {

    private static final String mSidUsername = "siddharth.gawas";
    private static final String mEthanUsername = "ethan_nakamura1211";
    private static final String mRishiUsername = "stormy_god23";
    private final static Uri mInstagramUri = Uri.parse("http://instagram.com/_u");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitleTextColor(getResources().getColor(R.color.secondaryTextColor));
        toolbar.setTitle("Developer's Page");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewEthan = findViewById(R.id.textView5);
        TextView textViewRishi = findViewById(R.id.textView6);
        TextView textViewSid = findViewById(R.id.textView7);
        textViewEthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mEthanUsername).build());
            }
        });

        textViewRishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mRishiUsername).build());
            }
        });

        textViewSid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mSidUsername).build());
            }
        });

    }

    private void openInstagram(Uri uri)
    {
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    uri));
        }
    }

}
