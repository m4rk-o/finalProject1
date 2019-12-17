package com.example.finalproject1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.finalproject1.ActivityComunication;
import com.example.finalproject1.R;

public class PrincipalActivity extends AppCompatActivity implements ActivityComunication {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void onListItemSelected(int position) {
        Intent intent = new Intent(this, SecondaryActivity.class);

        intent.putExtra("BOTONPULSADO", position);
        startActivity(intent);
    }
}
