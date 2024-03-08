package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class QuenMK extends AppCompatActivity {

    Button btnguimk,btnql;
    EditText edtmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mk);
        btnguimk = findViewById(R.id.btnguiotp);
        edtmail = findViewById(R.id.txtmaillay);
        btnql = findViewById(R.id.btnql3);
        mAuth = FirebaseAuth.getInstance();

        btnql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMK.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnguimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = edtmail.getText().toString();
                mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(QuenMK.this, "vui lòng kiểm tra hộp thư", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(QuenMK.this, "Gửi thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}