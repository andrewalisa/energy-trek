package com.example.chase.EnergyTrek;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    String usernameEntered = "";
    String passwordEntered = "";
    String sendoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }

    public void authenticateLogin(View view) {
        String usernameEntered = "";
        String passwordEntered = "";

        //EditText label1 = (EditText) findViewById(R.id.txtUsername);
        //EditText label2 = (EditText) findViewById(R.id.txtPassword);

        sendoff = getLoginInfo();
        checkUserLogin(sendoff);

        /*if (username.getText().toString().equals("admin")
               && password.getText().toString().equals("admin")) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        //} else {
            //Put a popup message box if the username and password are wrong
        //}

        }*/
    }

    public String getLoginInfo(){
        EditText label1 = (EditText) findViewById(R.id.txtUsername);
        EditText label2 = (EditText) findViewById(R.id.txtPassword);

        Username username = new Username();
        usernameEntered = label1.getText().toString();
        passwordEntered = label2.getText().toString();
        String sendoff = "";

        sendoff = usernameEntered + "%$" + passwordEntered;
        username.setName(sendoff);

        return sendoff;
    }

    public void checkUserLogin(String checkName){

        Username username = new Username();
        DatabaseHandler check = new DatabaseHandler(this);
        String loginName2 = "";

        boolean correctInfo = false;
        Integer x = 0;
        String loginName = "admin%$admin";
        //loginName = username.getName();
        //check.getUsername(checkName);
        loginName2 = username.getName();
        //while(x != 0){
        //check.getUsername(loginName);
        //checkName = username.getName();
        if(checkName.compareTo(loginName) == 0) {
            correctInfo = true;
            //      break;
            //   }
        }

        if(correctInfo){
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }else{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Invalid login username/password");
            dlgAlert.setTitle("Error");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }

    }


}
