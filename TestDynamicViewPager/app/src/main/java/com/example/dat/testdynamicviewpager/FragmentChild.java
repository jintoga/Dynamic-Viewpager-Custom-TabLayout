package com.example.dat.testdynamicviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DAT on 9/1/2015.
 */
public class FragmentChild extends Fragment {
    String childname;
    TextView textViewChildName;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        Bundle bundle = getArguments();
        childname = bundle.getString("data");
        getIDs(view);
        setEvents();
        return view;
    }

    private void getIDs(View view) {
        textViewChildName = (TextView) view.findViewById(R.id.textViewChild);
        textViewChildName.setText(childname);
        editText = (EditText) view.findViewById(R.id.editText);
        editText.setText("");
    }

    private void setEvents() {

    }
}
