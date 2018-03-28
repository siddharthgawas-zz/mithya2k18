package org.pccegoa.mithya2k18;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private final static Uri mInstagramUri = Uri.parse("http://instagram.com/_u/mithya2k17");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        ImageButton instagramButton = findViewById(R.id.instagramButton);
        instagramButton.setOnClickListener(this);
    }

    private void openInstagram()
    {
        Intent likeIng = new Intent(Intent.ACTION_VIEW, mInstagramUri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    mInstagramUri));
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.instagramButton:
                openInstagram();
                break;
            default: break;
        }
    }
}
