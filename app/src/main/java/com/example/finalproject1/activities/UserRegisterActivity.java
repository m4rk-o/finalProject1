package com.example.finalproject1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject1.R;
import com.example.finalproject1.models.User;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText editUserRegister, editPassRegister, editPassConf;
    private CardView btnLogin;

    private void instantiateUI(){
        editUserRegister = (EditText) findViewById(R.id.edit_UserName_register);
        editPassRegister = (EditText) findViewById(R.id.edit_UserPass_register);
        editPassConf = (EditText) findViewById(R.id.edit_UserPassConfirm);
        btnLogin = (CardView) findViewById(R.id.btn_login_register);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        instantiateUI();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
    }

    private void saveUser(){
        try {
            String a = editPassRegister.getText().toString().trim();
            String b = editPassConf.getText().toString().trim();
            String c = editUserRegister.getText().toString().trim();
            if (c.equals("") || a.equals("")){
                Toast.makeText(getApplicationContext(), getString(R.string.string_empty), Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                if (a.compareToIgnoreCase(b) != 0){
                    Toast.makeText(getApplicationContext(), getString(R.string.string_error_confPass), Toast.LENGTH_SHORT).show();

                    return;
                }
                else{
                    User user = new User(c, a);
                    user.save();
                    Toast.makeText(this, getString(R.string.string_success_registeer), Toast.LENGTH_SHORT).show();

                }
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(), getString(R.string.string_exception), Toast.LENGTH_SHORT).show();
        }
    }
}
