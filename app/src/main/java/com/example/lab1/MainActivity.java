package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btnLoginEmail,btnLoginSdt;
    TextView txtdk,txtqmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLoginEmail = findViewById(R.id.loginemail);
        btnLoginSdt = findViewById(R.id.loginsdt);
        txtdk = findViewById(R.id.txtdk);
        txtqmk = findViewById(R.id.txtqmk);

        txtqmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuenMK.class);
                startActivity(intent);
            }
        });

        btnLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginEmail.class);
                startActivity(intent);

            }
        });

        btnLoginSdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, LoginSdt.class);
                startActivity(intent2);

            }
        });

        txtdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, DangKy.class);
                startActivity(intent3);
            }
        });

    }
}