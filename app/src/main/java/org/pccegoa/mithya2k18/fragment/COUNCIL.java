package org.pccegoa.mithya2k18.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.pccegoa.mithya2k18.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link COUNCIL.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link COUNCIL#newInstance} factory method to
 * create an instance of this fragment.
 */
public class COUNCIL extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public ImageView gsCall;
    public ImageView lrCall;
    public ImageView urCall;
    public ImageView csCall;
    public ImageView ssCall;
    public ImageView msCall;
    private static final String mGsUsername = "omkardhond";
    private static final String mLrUsername = "chota_hooman";
    private static final String mUrUsername = "neeraj_kamat";
    private static final String mCsUsername = "overlord_sayaed";
    private static final String mSsUsername = "pranav_shirodkar";
    private static final String mMsUsername = "stormy_god23";
    private final static Uri mInstagramUri = Uri.parse("http://instagram.com/_u");

    public ImageView lrPic;
    public ImageView csPic;
    public ImageView msPic;
    public COUNCIL() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment COUNCIL.
     */
    // TODO: Rename and change types and number of parameters
    public static COUNCIL newInstance(String param1, String param2) {
        COUNCIL fragment = new COUNCIL();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gsCall = (ImageView) getView().findViewById(R.id.call_gs);
        lrCall = (ImageView) getView().findViewById(R.id.call_lr);
        urCall = (ImageView) getView().findViewById(R.id.call_ur);
        csCall = (ImageView) getView().findViewById(R.id.call_cs);
        ssCall = (ImageView) getView().findViewById(R.id.call_ss);
        msCall = (ImageView) getView().findViewById(R.id.call_ms);

        ImageView instaGs = (ImageView) getView().findViewById(R.id.insta_gs);
        ImageView instaLr = (ImageView) getView().findViewById(R.id.insta_lr);
        ImageView instaUr = (ImageView) getView().findViewById(R.id.insta_ur);
        ImageView instaCs = (ImageView) getView().findViewById(R.id.insta_cs);
        ImageView instaSs = (ImageView) getView().findViewById(R.id.insta_ss);
        ImageView instaMs = (ImageView) getView().findViewById(R.id.insta_ms);

        lrPic=(ImageView)getView().findViewById(R.id.lr_pic);
        csPic=(ImageView)getView().findViewById(R.id.cs_pic);
        msPic=(ImageView)getView().findViewById(R.id.ms_pic);
        ImageView urPic=(ImageView)getView().findViewById(R.id.ur_pic);
        ImageView gsPic=(ImageView)getView().findViewById(R.id.gs_pic);
        ImageView ssPic=(ImageView)getView().findViewById(R.id.ss_pic);

        Bitmap resized=decodeSampledBitmapFromResource(getResources(),R.drawable.rishikesh,90,130);
        msPic.setImageBitmap(resized);

        resized=decodeSampledBitmapFromResource(getResources(),R.drawable.pranav,90,130);
        ssPic.setImageBitmap(resized);

        resized=decodeSampledBitmapFromResource(getResources(),R.drawable.omkar,90,130);
        gsPic.setImageBitmap(resized);


        resized=decodeSampledBitmapFromResource(getResources(),R.drawable.sanaa,90,130);
        lrPic.setImageBitmap(resized);


        resized=decodeSampledBitmapFromResource(getResources(),R.drawable.sayaed,90,130);
        csPic.setImageBitmap(resized);

        resized=decodeSampledBitmapFromResource(getResources(),R.drawable.neeraj,90,130);
        urPic.setImageBitmap(resized);

//        Picasso.get().load(R.drawable.rishi).into(msPic);
//        Picasso.get().load(R.drawable.sanaa).into(lrPic);
//        Picasso.get().load(R.drawable.sayaed).into(csPic);




        gsCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View gsCall) {
                    Intent callGs = new Intent(Intent.ACTION_DIAL);
                    callGs.setData(Uri.parse("tel:+91 9403839012"));
                    startActivity(callGs);
            }
        });

        lrCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View lrCall) {
                Intent callLr = new Intent(Intent.ACTION_DIAL);
                callLr.setData(Uri.parse("tel:+91 7798652211"));
                startActivity(callLr);
            }
        });
        urCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View urCall) {
                Intent callUr = new Intent(Intent.ACTION_DIAL);
                callUr.setData(Uri.parse("tel:+91 9673280364"));
                startActivity(callUr);
            }
        });
        csCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View csCall) {
                Intent callCs = new Intent(Intent.ACTION_DIAL);
                callCs.setData(Uri.parse("tel:+91 9922982340"));
                startActivity(callCs);
            }
        });
        ssCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ssCall) {
                Intent callSs = new Intent(Intent.ACTION_DIAL);
                callSs.setData(Uri.parse("tel:+91 8806723902"));
                startActivity(callSs);
            }
        });
        msCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View msCall) {
                Intent callMs = new Intent(Intent.ACTION_DIAL);
                callMs.setData(Uri.parse("tel:+91 7767832562"));
                startActivity(callMs);
            }
        });

        instaGs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mGsUsername).build());
            }
        });
        instaLr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mLrUsername).build());
            }
        });
        instaUr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mUrUsername).build());
            }
        });
        instaCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mCsUsername).build());
            }
        });
        instaSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mSsUsername).build());
            }
        });
        instaMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mMsUsername).build());
            }
        });
    }

    private int calculateInSampleSize(BitmapFactory.Options options,int rWidth, int rHeight)
    {
        final int height = options.outHeight;
        final int  width = options.outWidth;
        int inSampleSize = 1;
        if(height > rHeight || width > rWidth)
        {
            int hH = height / 8;
            int hW = height / 8;
            while((hH / inSampleSize)>=rHeight && (hW /inSampleSize)>=rWidth)
                inSampleSize *= 2;
        }
        return inSampleSize;
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                  int rW, int rH)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,rW,rH);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    private void openInstagram(Uri uri) {
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    uri));
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_council, container, false);

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
