package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnDN, btnDK;
    TextView tvQuenPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnDN = findViewById(R.id.btnDangNhap);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDN = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentDN);
            }
        });
        btnDK = findViewById(R.id.btnDangKi);
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDK = new Intent(LoginActivity.this, DangKiActivity2.class);
                startActivity(intentDK);
            }
        });
        tvQuenPass = findViewById(R.id.textViewQuenPass);

    }

    public void quenPass(View view) {
        Intent intentQP = new Intent(LoginActivity.this, QuenPassActivity2.class);
        startActivity(intentQP);
    }
}