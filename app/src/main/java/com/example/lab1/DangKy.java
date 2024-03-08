package com.example.lab1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangKy extends AppCompatActivity {

    Button quaylai2, dangky2;
    private FirebaseAuth mAuth;
    EditText edttk, edtmk;

    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        mAuth = FirebaseAuth.getInstance();

        quaylai2 = findViewById(R.id.quaylai2);
        dangky2 = findViewById(R.id.dangky2);

        edttk = findViewById(R.id.edttkdk);
        edtmk = findViewById(R.id.edtmkdk);

        quaylai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, MainActivity.class);
                startActivity(intent);
            }
        });

        dangky2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tk = edttk.getText().toString();
                String mk = edtmk.getText().toString();

                if (TextUtils.isEmpty(tk) || TextUtils.isEmpty(mk)) {
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(mk.length()<6){
                        Toast.makeText(getApplicationContext(), "Mật khẩu phải từ 6 kí tự trở lên", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        createUser(tk,mk);
                    }

                }
            }
        });

    }

    private void createUser(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(DangKy.this, "tao tk ok", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangKy.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DangKy.this, "tao tk fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}