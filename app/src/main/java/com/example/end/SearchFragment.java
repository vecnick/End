package com.example.end;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SearchFragment extends Fragment {
    private static final String[] param = {"1", "m", "10", "dn", "dn", "dn","1000"};

    private static final String http = "https://902c5714dd23.ngrok.io";

    private static final int REQUEST_SUCCESS_CODE = 0;
    private static final int REQUEST_ERROR_CODE = 1;
    private View view ;
    private ImageButton button ;
    private ImageButton button2 ;
    private ImageView imageView;
    private TextView textView;
    private Context thisContext;
    private String age;
    private String gender;
    private String INTERESTS;
    private String INTERESTS2;
    private String INTERESTS3;
    private String price;
    private String Link = "https://www.google.ru/";
    private String LinkPhoto = "http://developer.alexanderklimov.ru/android/library/picasso-cat.jpg";
    private boolean first = false,second = true, third = true;
    public void PARAMETR (String age,String gender,String INTERESTS,String INTERESTS2,String INTERESTS3,String price)
    {
        this.age = age;
        this.gender = gender;
        this.INTERESTS = INTERESTS;
        this.INTERESTS2 = INTERESTS2;
        this.INTERESTS3 = INTERESTS3;
        param[1] = gender;
        param[2] = age;
        param[3] = INTERESTS;
        param[4] = INTERESTS2;
        param[5] = INTERESTS3;
        param[6] = price;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,
                container, false);
        button = (ImageButton) view.findViewById(R.id.buttonNext);
        button2 = (ImageButton) view.findViewById(R.id.buttonLink);
        imageView = (ImageView) view.findViewById(R.id.imageViewPresent);
        textView = (TextView) view.findViewById(R.id.textViewDescription);
        thisContext = container.getContext();
       // Present[] presents = new Present[5];
        int link = R.drawable.spotify;
        Present pr = new Present("dada", link,"fdfd");
        button.setOnClickListener(v -> {
            new Thread() {
                @Override
                public void run() {
                    super.run();

                    doRequest(); // вызов метода

                }
            }.start();
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent browserIntent = new
                       Intent(Intent.ACTION_VIEW, Uri.parse(Link));
                startActivity(browserIntent);
                //loadImageFromURL(LinkPhoto);
            }
        });
        return view;
        //return inflater.inflate(R.layout.fragment_search, container, false);
    }
    private Handler mRequestHandler = new Handler(Looper.getMainLooper(), msg -> {
        if (msg.what == REQUEST_SUCCESS_CODE && msg.obj != null) {
            // Вставляю текст
            String[] gift = (String[]) msg.obj;
            Link = gift[2];
            textView.setText(gift[0]);
            LinkPhoto = gift[1];
            loadImageFromURL(LinkPhoto);
        } else {
            textView.setText("Error");
        }
        return true;
    });

    private void loadImageFromURL(String linkPhoto) {
        Picasso.with(thisContext).load(LinkPhoto).into(imageView);
    }

    private void doRequest() {

        String[] gift1 = new String[3];
        String[] gift2 = new String[3];
        String[] gift3 = new String[3];

        Message msg = new Message();

        try {
            int n = 0;

            String send_param = http + "/param?id=" + param[0] + "&gender=" + param[1] + "&age=" + param[2] + "&occupation=" + param[3] + "&sport=" + param[4] + "&pet=" + param[5] + "&price=" + param[6];
            //System.out.println(send_param);

            URL obj = new URL(send_param);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            in.close();


            String get_gift1 = http + "/gifts?id=1&number=1";

            URL obj1 = new URL(get_gift1);
            HttpURLConnection connection1 = (HttpURLConnection) obj1.openConnection();

            connection1.setRequestMethod("GET");

            BufferedReader in1 = new BufferedReader(new InputStreamReader(connection1.getInputStream()));
            String inputLine;

            while ((inputLine = in1.readLine()) != null) {

                //response.append(inputLine);
                gift1[n] = inputLine;

                //System.out.println(n);
                n = n + 1;

            }
            in1.close();
            n = 0;

            String get_gift2 = http + "/gifts?id=1&number=2";

            URL obj2 = new URL(get_gift2);
            HttpURLConnection connection2 = (HttpURLConnection) obj2.openConnection();

            connection2.setRequestMethod("GET");

            BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            String inputLine2;

            while ((inputLine2 = in2.readLine()) != null) {

                gift2[n] = inputLine2;
                //System.out.println(n);
                n = n + 1;

            }
            in2.close();
            n = 0;


            String get_gift3 = http + "/gifts?id=1&number=3";

            URL obj3 = new URL(get_gift3);
            HttpURLConnection connection3 = (HttpURLConnection) obj3.openConnection();

            connection3.setRequestMethod("GET");

            BufferedReader in3 = new BufferedReader(new InputStreamReader(connection3.getInputStream()));
            String inputLine3;

            while ((inputLine3 = in3.readLine()) != null) {

                gift3[n] = inputLine3;
                //System.out.println(n);
                n = n + 1;

            }
            in3.close();
            if (!first&& third) {msg.obj = gift1;second = false;first = true;}
            if (!second && first) {msg.obj = gift2;third = false;second = true;}
            if (!third && second) {msg.obj = gift3;first = false;third = true;}
            //msg.obj = gift2;
            msg.what = REQUEST_SUCCESS_CODE;
        } catch (IOException e) {
            msg.what = REQUEST_ERROR_CODE;
            e.printStackTrace(); // принт ошибки
        }
        mRequestHandler.sendMessage(msg); // посылаем результат
    }

}