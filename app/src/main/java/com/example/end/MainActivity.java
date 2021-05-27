package com.example.end;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button1;
    Button button2;

    private ArrayList<Present>Presents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }

        public void onSettings(MenuItem item)
        {

            Fragment fragment;
            fragment = new SettingsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fr_main, fragment);
            ft.commit();
            Toast.makeText(this,"Выберите интересующие вас критерии подарка",Toast.LENGTH_SHORT).show();
        }
    public void onSearch(MenuItem item)
    {
        Fragment fragment;
        fragment = new SearchFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_main, fragment);
        ft.commit();
        Toast.makeText(this,"Удачного поиска",Toast.LENGTH_SHORT).show();
    }
    public void onBasket(MenuItem item)
    {
        finish();
    }

}