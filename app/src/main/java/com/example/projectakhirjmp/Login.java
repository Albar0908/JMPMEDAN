package com.example.projectakhirjmp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.net.ipsec.ike.ChildSaProposal;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnregister,btnlogin;
    EditText txtUsernamelg, txtPasswordlg;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_login));


        txtUsernamelg = (EditText) findViewById(R.id. editTextUsername);
        txtPasswordlg = (EditText) findViewById(R. id. editTextPassword);
        btnregister = (Button) findViewById(R.id.buttonRegister);
        btnlogin = (Button) findViewById(R.id.buttonLogin);
        dblogin = new DatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamelg = txtUsernamelg.getText().toString();
                String passwordlg = txtPasswordlg.getText().toString();
                Boolean checkUserPassword = dblogin.checkUserPassword(usernamelg, passwordlg);
                if (checkUserPassword) {
                    Toast.makeText(getApplicationContext(), "Login Sucsessfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Login.this, Register.class);
                startActivity(intent);
            }
        });

    }
}