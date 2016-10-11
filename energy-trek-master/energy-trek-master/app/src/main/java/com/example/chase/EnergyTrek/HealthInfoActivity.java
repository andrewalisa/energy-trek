package com.example.chase.EnergyTrek;

import android.content.Intent;
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


        int cat1, cat2, cat3, cat4, activeBoxes;
        int entry1 = 0, entry2 = 0, entry3 = 0, entry4 = 0, category = 0;
        int Data[] = new int[12];

        //String preEntry1, preEntry2, preEntry3, preEntry4;
        String check1 = "", check2 = "", check3 = "", check4 = "";
        Integer sLength, bValue = 0;
        String chkPhrase1, chkPhrase2;

        //Check first box
        sLength = preEntry1.length();
        for(int x = 0; x < sLength; x++){

            chkPhrase1 = preEntry1.substring(x, x+1);
            switch(chkPhrase1){
                case "0":
                    check1 = check1 + "0";
                    break;
                case "1":
                    check1 = check1 + "1";
                    break;
                case "2":
                    check1 = check1 + "2";
                    break;
                case "3":
                    check1 = check1 + "3";
                    break;
                case "4":
                    check1 = check1 + "4";
                    break;
                case "5":
                    check1 = check1 + "5";
                    break;
                case "6":
                    check1 = check1 + "6";
                    break;
                case "7":
                    check1 = check1 + "7";
                    break;
                case "8":
                    check1 = check1 + "8";
                    break;
                case "9":
                    check1 = check1 + "9";
                    break;
                default:
                    check1 = "";
                    bValue = 1;
                    label1.setText(preEntry1);
                    break;
            }
            label1.setText(check1);
        }

        //Check second box
        sLength = preEntry2.length();
        for(int x = 0; x < sLength; x++){

            chkPhrase2 = preEntry2.substring(x, x+1);
            switch(chkPhrase2){
                case "0":
                    check2 = check2 + "0";
                    break;
                case "1":
                    check2 = check2 + "1";
                    break;
                case "2":
                    check2 = check2 + "2";
                    break;
                case "3":
                    check2 = check2 + "3";
                    break;
                case "4":
                    check2 = check2 + "4";
                    break;
                case "5":
                    check2 = check2 + "5";
                    break;
                case "6":
                    check2 = check2 + "6";
                    break;
                case "7":
                    check2 = check2 + "7";
                    break;
                case "8":
                    check2 = check2 + "8";
                    break;
                case "9":
                    check2 = check2 + "9";
                    break;
                default:
                    check2 = "";
                    bValue = 1;
                    label2.setText(preEntry2);
                    break;
            }
            label2.setText(check2);
        }



        if(category == 1) {
            Data[0] = entry1;
            Data[1] = entry2;
            Data[2] = entry3;
            Data[3] = entry4;
        }
        else if(category == 2) {
            Data[4] = entry1;
            Data[5] = entry2;
            Data[6] = entry3;
            Data[7] = entry4;
        }
        else if(category == 3){
            Data[8] = entry1;
            Data[9] = entry2;
            Data[10] = entry3;
            Data[11] = entry4;
        }
    }
}
