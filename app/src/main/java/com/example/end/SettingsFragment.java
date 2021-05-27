package com.example.end;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SettingsFragment extends Fragment{
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,
                container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.buttonSearch);
        EditText editText = (EditText) view.findViewById(R.id.editTextAge);
        EditText editText2 = (EditText) view.findViewById(R.id.editTextAge2);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        //String text = spinner.getSelectedItem().toString();
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        //String text2 = spinner2.getSelectedItem().toString();
        Spinner spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        //String text3 = spinner3.getSelectedItem().toString();
        RadioButton radioButton1 = (RadioButton) view.findViewById(R.id.radioButtonFemale);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.radioButtonMale);
       /* JSONObject mySettings = new JSONObject();
        try {
            mySettings.put("Interests",text);
            mySettings.put("VidDeyatelnosti",text2);
            mySettings.put("Pitomci",text3);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String age = editText.getText().toString();
                String price ="0";
                price = editText2.getText().toString();
                String text = spinner.getSelectedItem().toString();
                String text2 = spinner2.getSelectedItem().toString();
                String text3 = spinner3.getSelectedItem().toString();
                String gender = "";
                if (radioButton1.isChecked()) gender = "w";
                if (radioButton2.isChecked()) gender = "m";
                if (text.equals("школьник")) text = "school";
                if (text.equals("студент")) text = "student";
                if (text.equals("работающий")) text = "work";
                if (text.equals("не знаю")) text = "dn";
                if (text2.equals("да")) text2 = "yes";
                if (text2.equals("нет")) text2 = "no";
                if (text2.equals("не знаю")) text2 = "dn";
                if (text3.equals("кошка")) text3 = "cat";
                if (text3.equals("собака")) text3 = "dog";
                if (text3.equals("рыбки")) text3 = "fish";
                if (text3.equals("не знаю")) text3 = "dn";
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                SearchFragment myFragment = new SearchFragment();
                myFragment.PARAMETR(age,gender,text,text2,text3,price);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fr_main, myFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }
}