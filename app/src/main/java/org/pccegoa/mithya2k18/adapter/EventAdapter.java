package org.pccegoa.mithya2k18.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.pccegoa.mithya2k18.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Siddharth on 3/30/2018.
 */

public class EventAdapter extends BaseAdapter {
    private Context mContext;
    private List<Map<String,Object>> events = null;
    public EventAdapter(Context context,List<Map<String,Object>> events) {
        mContext = context;
        this.events = events;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.event_list_item,null);

        final ImageView imageView = view.findViewById(R.id.eventImage);
        TextView eventNameTextView = view.findViewById(R.id.eventName);
        eventNameTextView.setText((String)events.get(position).get("event_name"));
        String fileId = ((String) events.get(position).get("image"));
        Resources resources=mContext.getResources();
        final int resourceId =resources.getIdentifier("event"+fileId, "drawable",mContext.getPackageName());
        Picasso.get().load(resourceId).into(imageView);
        return view;
    }

    private class ImageTransformation implements Transformation {

        private ImageView imageView = null;
        public ImageTransformation(ImageView imageView)
        {
            this.imageView = imageView;
        }
        @Override
        public Bitmap transform(Bitmap source) {

            Palette.from(source).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    imageView.setBackgroundColor(palette.getVibrantColor(mContext.
                            getResources().getColor(R.color.secondaryTextColor)));
                }
            });
            return source;
        }

        @Override
        public String key() {
            return "square()";
        }
    }

}
