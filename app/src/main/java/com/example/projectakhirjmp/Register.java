package com.example.projectakhirjmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button btnregister;
    EditText eduser,edpass;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister = findViewById(R.id.buttonReg);
        eduser = findViewById(R.id.editTextUsername);
        edpass = findViewById(R.id.editTextPassword);
        dblogin = new DatabaseHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eduser.getText().toString();
                String password = edpass.getText().toString();
                boolean checkUser = dblogin.checkUser(user);
                if ( checkUser == false ){
                    boolean insert = dblogin.insertUser(user, password);
                    if (insert == true ){
                        Toast.makeText(getApplicationContext(), "Register Sucsessfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_SHORT).show();
                    }

                }else {
                        Toast.makeText(getApplicationContext(), "User Already Exist",Toast.LENGTH_SHORT).show();
                    }

                }
        });
    }
}