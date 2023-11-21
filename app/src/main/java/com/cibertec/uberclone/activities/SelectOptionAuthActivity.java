package com.cibertec.uberclone.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cibertec.uberclone.R;
import com.cibertec.uberclone.activities.client.RegisterActivity;
import com.cibertec.uberclone.activities.diver.RegisterDriverActivity;
import com.cibertec.uberclone.includes.MyToolbar;

public class SelectOptionAuthActivity extends AppCompatActivity {

    SharedPreferences mPref;
    Toolbar mToolbar ;
    Button mButtonGoToLogin;
    Button mButtonGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);
        MyToolbar.show(this,"Seleccionar opcion", true);

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);

        mButtonGoToLogin = findViewById(R.id.btnGotoLogin);
        mButtonGoToRegister = findViewById(R.id.btnGotoRegister);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });
    }

    public void goToLogin(){
        Intent intent = new Intent(SelectOptionAuthActivity.this , LoginActivity.class);
        startActivity(intent);
    }
    public void goToRegister(){
        String typeUser = mPref.getString("user", "");
        if (typeUser.equals("client")) {
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterDriverActivity.class);
            startActivity(intent);
        }

    }
}