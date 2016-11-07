package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.Context;

import static android.R.attr.category;
import static android.R.attr.checked;
import static android.R.attr.checkedButton;
import static android.R.attr.format;
import static android.R.attr.id;
import static com.example.chase.EnergyTrek.R.id.enterButton;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GoalsActivity extends AppCompatActivity {

    //Added by Andrew
    String categoryStr;
    private static final String LOG_TAG = GoalsActivity.class.getSimpleName();
    private static final String FILE_NAME = "trekoutput.txt";

    // Used to write to the textfile
    public OutputStream output;

    // Used to write to the textfile.

    public BufferedWriter writer;
    private Context context;

    String q1;
    String q2;
    String q3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_today);

        //Button enter = (Button)findViewById(R.id.enterButton);

        //enter.setOnClickListener(enterListener);



    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        EditText label3 = (EditText) findViewById(R.id.property3);

        q1 = label1.getText().toString();
        q2 = label2.getText().toString();
        q3 = label3.getText().toString();

        label1.setText("");
        label2.setText("");
        label3.setText("");


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    label1.setHint("Cups of water per day");
                    label2.setHint("Time between cups (in hours?)");
                    label3.setHint("Time since last cup of water (in hours)");


                    categoryStr = "W";


                    break;
            case R.id.radio_calories:
                if (checked)
                    label1.setHint("Calories consumed per day");
                    label2.setHint("Meals/snacks per day");
                    label3.setHint("Time since last meal (in hours)");

                    categoryStr = "C";


                    break;
            case R.id.radio_sleep:
                if (checked)
                    label1.setHint("Time asleep (in hours)");
                    label2.setHint("Time to be asleep each night");
                    label3.setHint("Time spent in naps (in hours)");

                    categoryStr = "S";


                    break;
        }



    }


   /* public void onClick (View view) {
        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        EditText label3 = (EditText) findViewById(R.id.property3);

        q1 = label1.getText().toString();
        q2 = label2.getText().toString();
        q3 = label3.getText().toString();
    } */

/*
  public OnClickListener enterListener = new OnClickListener()
    {

        @Override
        public void onClick(View view)
        {
            EditText label1 = (EditText) findViewById(R.id.calories);
            EditText label2 = (EditText) findViewById(R.id.time);
            EditText label3 = (EditText) findViewById(R.id.property3);

            q1 = label1.getText().toString();
            q2 = label2.getText().toString();
            q3 = label3.getText().toString();


        }

        public String return1() {
            return q1;
        }
    }; */

   /* public String returnq1(){
        return q1;
    } */

 /*   public String returnValues() {
        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        EditText label3 = (EditText) findViewById(R.id.property3);

        q1 = label1.getText().toString();
        q2 = label2.getText().toString();
        q3 = label3.getText().toString();

        return q1;
    } */

    /** Called when the user clicks the Menu button */
    public void menu(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    /** Called when the user clicks the Enter button */


    public void enter(View view) {

   /*     EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        EditText label3 = (EditText) findViewById(R.id.property3);

        q1 = label1.getText().toString();
        q2 = label2.getText().toString();
        q3 = label3.getText().toString(); */

        //Set the Date
        Date date = Calendar.getInstance().getTime();
        //Set the format
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        //Put it in the string
        String strDate = formatter.format(date);
        //Set the time format
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        //Putting the time in the string
        String strTime = formatTime.format(date);


        //Default value is C because calories is the first screen they see.
        if (categoryStr == null) {
            categoryStr = "C";
        }



        BufferedWriter bufferWriter = null;
        try {
            FileOutputStream fileOutputStream = openFileOutput("enerytrekdata.txt", Context.MODE_APPEND);
            bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            //bufferWriter.write(categoryStr + ";");
            bufferWriter.write(categoryStr + ";" + strDate + ";" + strTime + ";" + q1 + ";" + q2 + ";" + q3);
            bufferWriter.append("\n");

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


}
