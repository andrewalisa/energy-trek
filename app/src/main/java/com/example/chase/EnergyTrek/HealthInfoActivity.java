package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;

import static android.R.attr.category;

public class HealthInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_health_info);
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        int Category = 0;
        //1 is water, 2 is calories, 3 is sleep
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_water:
                if (checked)
                    Category = 1;
                label1.setHint("How much water did you drink");
                label2.setHint("At what time?");
                break;
            case R.id.radio_calories:
                if (checked)
                    Category = 2;
                label1.setHint("How many calories did you consume?");
                label2.setHint("At what time?");
                break;
            case R.id.radio_sleep:
                if (checked)
                    Category = 3;
                label1.setHint("How long did you sleep?");
                label2.setHint("At what time?");
                break;
        }

    }

    /** Called when the user clicks the Menu button */
    public void menu(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    /** Called when the user clicks the Enter button*/
    public void enter(View view) {
        Integer Category = 1;

        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        String preEntry1 = label1.getText().toString();
        String preEntry2 = label2.getText().toString();

        if(preEntry1.compareTo("") != 0 && preEntry2.compareTo("") != 0){
            //main code goes here
        }else{
            if(preEntry1.compareTo("") != 0 && preEntry2.compareTo("") == 0) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Second data point invalid");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }else if(preEntry1.compareTo("") == 0 && preEntry2.compareTo("") != 0) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("First data point invalid");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }else{
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Both data point invalid");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        }
    }
}
