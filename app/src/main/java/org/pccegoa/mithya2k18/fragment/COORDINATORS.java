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
 * {@link COORDINATORS.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link COORDINATORS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class COORDINATORS extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageView comp1Call;
    public ImageView comp2Call;
    public ImageView etc1Call;
    public ImageView etc2Call;
    public ImageView it1Call;
    public ImageView it2Call;
    public ImageView mech1Call;
    public ImageView mech2Call;
    private static final String mcomp1Username = "glen_dsouza_";
    private static final String mcomp2Username = "ethan_nakamura1211";
    private static final String metc1Username = "_alexander_roy_";
    private static final String metc2Username = "divya2396";
    private static final String mit1Username = "snivio";
    private static final String mit2Username = "_bt_7";
    private static final String mmech1Username = "saurabhparrikar";
    private static final String mmech2Username = "dikshay_16";
    private final static Uri mInstagramUri = Uri.parse("http://instagram.com/_u");
    private OnFragmentInteractionListener mListener;

    public ImageView it2Pic;
    public ImageView it1Pic;
    public ImageView etc1Pic;
    public COORDINATORS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment COORDINATORS.
     */
    // TODO: Rename and change types and number of parameters
    public static COORDINATORS newInstance(String param1, String param2) {
        COORDINATORS fragment = new COORDINATORS();
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

        comp1Call = (ImageView) getView().findViewById(R.id.call_comp1);
        comp2Call = (ImageView) getView().findViewById(R.id.call_comp2);
        etc1Call = (ImageView) getView().findViewById(R.id.call_etc1);
        etc2Call = (ImageView) getView().findViewById(R.id.call_etc2);
        it1Call = (ImageView) getView().findViewById(R.id.call_it1);
        it2Call = (ImageView) getView().findViewById(R.id.call_it2);
        mech1Call = (ImageView) getView().findViewById(R.id.call_mech1);
        mech2Call = (ImageView) getView().findViewById(R.id.call_mech2);

        ImageView instaComp1 = (ImageView) getView().findViewById(R.id.insta_comp1);
        ImageView instaComp2 = (ImageView) getView().findViewById(R.id.insta_comp2);
        ImageView instaEtc1 = (ImageView) getView().findViewById(R.id.insta_etc1);
        ImageView instaEtc2 = (ImageView) getView().findViewById(R.id.insta_etc2);
        ImageView instaIt1 = (ImageView) getView().findViewById(R.id.insta_it1);
        ImageView instaIt2 = (ImageView) getView().findViewById(R.id.insta_it2);
        ImageView instaMech1 = (ImageView) getView().findViewById(R.id.insta_mech1);
        ImageView instaMech2 = (ImageView) getView().findViewById(R.id.insta_mech2);

        it1Pic=(ImageView) getView().findViewById(R.id.it1_pic);
        it2Pic=(ImageView) getView().findViewById(R.id.it2_pic);
        etc1Pic=(ImageView) getView().findViewById(R.id.etc1_pic);
        ImageView comp2Pic=(ImageView) getView().findViewById(R.id.comp2_pic);
        ImageView comp1Pic=(ImageView) getView().findViewById(R.id.comp1_pic);
        ImageView etc2Pic=(ImageView) getView().findViewById(R.id.etc2_pic);
        ImageView mech2Pic=(ImageView) getView().findViewById(R.id.mech2_pic);
        ImageView mech1Pic=(ImageView) getView().findViewById(R.id.mech1_pic);


        Bitmap resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.snivio,90,130);
        it1Pic.setImageBitmap(resized);


        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.biswas,90,130);
        it2Pic.setImageBitmap(resized);

        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.royston,90,130);
        etc1Pic.setImageBitmap(resized);

       resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.divya,90,130);
       etc2Pic.setImageBitmap(resized);


        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.ethan,90,130);
        comp2Pic.setImageBitmap(resized);

        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.glen,90,130);
        comp1Pic.setImageBitmap(resized);

        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.saurabh,90,130);
        mech1Pic.setImageBitmap(resized);

        resized=
                decodeSampledBitmapFromResource(getResources(),R.drawable.dikshay,90,130);
        mech2Pic.setImageBitmap(resized);


//          Picasso.get().load(R.drawable.divya2).into(etc2Pic);
//        Picasso.get().load(R.drawable.snivio).into(it1Pic);
//        Picasso.get().load(R.drawable.royston).into(etc1Pic);
//        Picasso.get().load(R.drawable.ethan).into(comp2Pic);
        //Picasso.get().load(R.drawable.royston).into(etc1Pic);



        comp1Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View compCall) {
                Intent callComp1 = new Intent(Intent.ACTION_DIAL);
                callComp1.setData(Uri.parse("tel:+91 8554063436"));
                startActivity(callComp1);
            }
        });

        comp2Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View copmCall) {
                Intent callComp2 = new Intent(Intent.ACTION_DIAL);
                callComp2.setData(Uri.parse("tel:+91 9011383857"));
                startActivity(callComp2);
            }
        });
        etc1Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View etcCall) {
                Intent callEtc1 = new Intent(Intent.ACTION_DIAL);
                callEtc1.setData(Uri.parse("tel:+91 8806805372"));
                startActivity(callEtc1);
            }
        });
        etc2Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View etcCall) {
                Intent callEtc2 = new Intent(Intent.ACTION_DIAL);
                callEtc2.setData(Uri.parse("tel:+91 8888623717"));
                startActivity(callEtc2);
            }
        });
        it1Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itCall) {
                Intent callIt1 = new Intent(Intent.ACTION_DIAL);
                callIt1.setData(Uri.parse("tel:+91 7720865311"));
                startActivity(callIt1);
            }
        });
        it2Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itCall) {
                Intent callIt2 = new Intent(Intent.ACTION_DIAL);
                callIt2.setData(Uri.parse("tel:+91 8554958547"));
                startActivity(callIt2);
            }
        });
        mech1Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mechCall) {
                Intent callMech1 = new Intent(Intent.ACTION_DIAL);
                callMech1.setData(Uri.parse("tel:+91 7350970607"));
                startActivity(callMech1);
            }
        });
        mech2Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mechCall) {
                Intent callMech2 = new Intent(Intent.ACTION_DIAL);
                callMech2.setData(Uri.parse("tel:+91 9130812507"));
                startActivity(callMech2);
            }
        });


        instaComp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mcomp1Username).build());
            }
        });
        instaComp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mcomp2Username).build());
            }
        });
        instaEtc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(metc1Username).build());
            }
        });
        instaEtc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(metc2Username).build());
            }
        });
        instaIt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mit1Username).build());
            }
        });
        instaIt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mit2Username).build());
            }
        });
        instaMech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mmech1Username).build());
            }
        });
        instaMech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram(mInstagramUri.buildUpon().appendPath(mmech2Username).build());
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

        return inflater.inflate(R.layout.fragment_coordinator, container, false);
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
