package org.pccegoa.mithya2k18.fragment;

/**
 * Created by Siddharth on 4/4/2018.
 */
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.pccegoa.mithya2k18.R;



/**
 * Created by Siddharth on 3/31/2018.
 */

public class ScoreKeyFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View rootView = inflater.inflate(R.layout.score_key_fragment_layout,null);
        builder.setView(rootView);
        return builder.create();
    }
}