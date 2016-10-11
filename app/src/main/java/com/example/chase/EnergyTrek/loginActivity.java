package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }

    public void authenticateLogin(View view) {
       // if (username.getText().toString().equals("admin")
               // && password.getText().toString().equals("admin")) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        //} else {
            //Put a popup message box if the username and password are wrong
        //}


    }

    //private void setupVariables() {
        //username = (EditText) findViewById(R.id.textUsername);
        //password = (EditText) findViewById(R.id.textPassword);
    //}

}
