package com.example.end;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class SearchFragment extends Fragment {
    Button myButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search,
                container, false);
        Button button = (Button) view.findViewById(R.id.buttonNext);
        Button button2 = (Button) view.findViewById(R.id.buttonLink);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewPresent);
        TextView textView = (TextView) view.findViewById(R.id.textViewDescription);
        User[] users = new User[5];
        Present[] presents = new Present[5];
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                imageView.setBackgroundResource(R.drawable.spotify);
                String i = "Подписка на музыку spotify";
                textView.setText(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spotify.com/ru-ru/premium/"));
                startActivity(browserIntent);
            }
        });
        return view;
        //return inflater.inflate(R.layout.fragment_search, container, false);
    }


}