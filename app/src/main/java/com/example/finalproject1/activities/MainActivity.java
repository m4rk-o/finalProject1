package com.example.finalproject1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.example.finalproject1.R;
import com.example.finalproject1.models.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editUsername, editPass;
    private CardView btnLogin;
    private TextView tvRegister;
    private Animation animRotate;
    private ImageView image_logo;

    private void instantiateUI(){
        editUsername = (EditText) findViewById(R.id.edit_UserName);
        editPass = (EditText) findViewById(R.id.edit_UserPass);

        btnLogin = (CardView) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        tvRegister = (TextView) findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(this);

        image_logo = (ImageView) findViewById(R.id.imageLogo);
    }

    private void LoadAnimations(){
        animRotate = AnimationUtils.loadAnimation(this,R.anim.rotate_left);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateUI();
        LoadAnimations();
        animRotate.setDuration(8000);
        image_logo.startAnimation(animRotate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                    loginApplication();
                break;
            case R.id.tv_register:
                Intent intent = new Intent(this, UserRegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void loginApplication(){
        try {
            String a = editUsername.getText().toString().trim();
            String b = editPass.getText().toString().trim();
            boolean log = new Select().from(User.class).where("name = ?", a).where("pass = ?", b).exists();
            if (log == true){
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), getString(R.string.string_error_login), Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(), getString(R.string.string_exception), Toast.LENGTH_SHORT).show();
        }
    }

}
