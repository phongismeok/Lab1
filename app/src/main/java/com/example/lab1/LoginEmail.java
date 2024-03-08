package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginEmail extends AppCompatActivity {

    Button btnlogin1,btnquaylai1,btndx;
    EditText edttk,edtmk;
    private FirebaseAuth mAuth;
    TextView txtht;

    @Override
    public void onStart() {
        super.onStart();

        mAuth = FirebaseAuth.getInstance();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            txtht.setText(String.valueOf(currentUser.getEmail()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);
        btnlogin1 = findViewById(R.id.login1);
        btnquaylai1 = findViewById(R.id.quaylai1);
        edttk = findViewById(R.id.edttkdn);
        edtmk = findViewById(R.id.edtmkdn);
        txtht = findViewById(R.id.txthttk);
        btndx = findViewById(R.id.btndx);
        mAuth = FirebaseAuth.getInstance();

        btnquaylai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginEmail.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edttk.getText().toString();
                String mk = edtmk.getText().toString();

                Log.d("aaaaa", "onClick: " +tk);

                mAuth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("aaaaa", "onClick: ok" +tk);
                            Toast.makeText(LoginEmail.this, "login ok", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            txtht.setText(user.getEmail());
                        } else {
                            Log.d("aaaaa", "onClick: fail" +tk);
                            Toast.makeText(LoginEmail.this, "login fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        btndx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                txtht.setText("");
            }
        });

    }
}