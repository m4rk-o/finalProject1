package com.example.finalproject1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.finalproject1.ActivityComunication;
import com.example.finalproject1.Fragments.Fixtures;
import com.example.finalproject1.Fragments.Teams;
import com.example.finalproject1.R;

public class SecondaryActivity extends AppCompatActivity implements ActivityComunication {

    Fragment[] Fmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Fmanager = new Fragment[2];
        Fmanager[0] = new Teams();
        Fmanager[1] = new Fixtures();

        Bundle extras = getIntent().getExtras();
        onListItemSelected(extras.getInt("BOTONPULSADO"));
    }

    @Override
    public void onListItemSelected(int position) {
        FragmentManager manager = getFragmentManager();

        FragmentTransaction myTransaction = manager.beginTransaction();

        myTransaction.replace(R.id.fragment_manager, Fmanager[position]);
        myTransaction.commit();
    }
}
