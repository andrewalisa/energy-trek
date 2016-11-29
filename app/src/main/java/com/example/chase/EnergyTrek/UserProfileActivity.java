package com.example.chase.EnergyTrek;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.category;
/**
 * Created by Caleb on 11/8/16.
 */

public class UserProfileActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_userprofile);


        Button menu = (Button) findViewById(R.id.btnMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(UserProfileActivity.this, MainActivity.class);
                startActivity(profileIntent);
            }
        });

    }

    boolean male = true;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.male:
                if (checked)
                    male = true;
                break;
            case R.id.female:
                if (checked)
                    male = false;
                break;
        }
    }

    public void enter(View view) {
        EditText txtAge = (EditText) findViewById(R.id.age);
        EditText txtHeight = (EditText) findViewById(R.id.height);
        EditText txtWeight = (EditText) findViewById(R.id.weight);

        String ageTemp, heightTemp, weightTemp;
        Integer age, height, weight;
        boolean verify = false, check = false;

        ageTemp = txtAge.getText().toString();
        heightTemp = txtHeight.getText().toString();
        weightTemp = txtWeight.getText().toString();

        verify = verifyInputs(ageTemp, heightTemp, weightTemp);

        if(verify) {
            age = Integer.parseInt(ageTemp);
            height = Integer.parseInt(heightTemp);
            weight = Integer.parseInt(weightTemp);

            check = checkInputs(age, height, weight);

            if(check){
                File f = null;
                boolean chkExist = false;
                try {

                    //Putting "energytrekdata.txt" into variable
                    f = new File("energytrekdata.txt");

                    //Checking if "energytrekdata.txt" exists, if it does exist, it chkExist will be true, otherwise it will be false
                    chkExist = f.exists();

                } catch (Exception e){
                    e.printStackTrace();
                }

                if (chkExist == true) {

                    BufferedReader bufferReader = null;
                    BufferedWriter bufferWriter = null;

                    String line;
                    try {
                        //Store that sucker
                        FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
                        bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        bufferWriter.write("U;" + male + ";" + age + ";" + height + ";" + weight);
                        bufferWriter.append("\n");

                        //Let the user know it's been stored and reset the entry box
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Data stored!");
                        dlgAlert.setTitle("Success!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

                //If the File does not exist, it then creates the file. Without this code, there would be an error.
                else {

                    try {
                        //Store that sucker
                        BufferedReader bufferReader1 = null;
                        BufferedWriter bufferWriter1 = null;

                        FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
                        bufferWriter1 = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        bufferWriter1.write("U;" + male + ";" + age + ";" + height + ";" + weight);
                        bufferWriter1.append("\n");

                        //Let the user know it's been stored and reset the entry box
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Data stored!");
                        dlgAlert.setTitle("Success!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();

                        bufferWriter1.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }else{
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Data is impossible");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        } else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Data is invalid");
            dlgAlert.setTitle("Error");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }

    public boolean verifyInputs(String age, String height, String weight){
        Integer checkLength;
        String segCheck;
        Boolean invalidPoint = false;

        checkLength = age.length();

        for (int counter = 0; counter < checkLength; counter++) {
            segCheck = age.substring(counter, counter + 1);
            if (segCheck.compareTo("/") == 0 || segCheck.compareTo(".") == 0 || segCheck.compareTo(",") == 0 || segCheck.compareTo(" ") == 0) {
                invalidPoint = true;
            }
        }
        if(age.compareTo("") == 0 || height.compareTo("") == 0 || weight.compareTo("") == 0)
            invalidPoint = true;

        if(!invalidPoint)
            return true;
        else
            return false;

    }

    public boolean checkInputs(Integer age, Integer height, Integer weight){
        boolean invalidPoint = false;

        if(age > 120 || age < 8)
            invalidPoint = true;
        if(height < 24 || height > 92)
            invalidPoint = true;
        if(weight < 50 || weight > 600)
            invalidPoint = true;
        if(!invalidPoint)
            return true;
        else
            return false;
    }
}
