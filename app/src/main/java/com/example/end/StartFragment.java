package com.example.end;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Objects;

public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start,
                container, false);
        ImageButton Imagebutton = (ImageButton) view.findViewById(R.id.imageButton);
        View listView = Objects.requireNonNull(getActivity()).findViewById(R.id.fr_main);
        Imagebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new SettingsFragment();
               // activity.getSupportFragmentManager().beginTransaction().remove();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fr_main, myFragment).addToBackStack(null).commit();
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_start, container, false);
    }
}