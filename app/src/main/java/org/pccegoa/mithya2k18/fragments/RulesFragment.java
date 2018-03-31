package org.pccegoa.mithya2k18.fragments;

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

public class RulesFragment extends DialogFragment {
    public static final String EVENT_NAME_ARG = "event_name";
    public static final String EVENT_RULES_ARG = "event_rules";
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View rootView = inflater.inflate(R.layout.rules_dialog_layout,null);
        TextView nameTextView = rootView.findViewById(R.id.eventName);
        TextView rulesTextView = rootView.findViewById(R.id.rulesTextView);
        Bundle bundle = getArguments();
        nameTextView.setText(bundle.getString(EVENT_NAME_ARG));
        rulesTextView.setText(bundle.getString(EVENT_RULES_ARG));
        builder.setView(rootView);
        return builder.create();
    }
}
