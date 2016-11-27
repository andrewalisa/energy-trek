package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PreviousTreksActivity extends AppCompatActivity {
/*
    TextView labelA = (TextView) findViewById(R.id.DataA);
    TextView labelA1 = (TextView) findViewById(R.id.txtDataA1);
    TextView labelA2 = (TextView) findViewById(R.id.txtDataA2);
    TextView labelA3 = (TextView) findViewById(R.id.txtDataA3);
    TextView labelA4 = (TextView) findViewById(R.id.txtDataA4);
    TextView labelA5 = (TextView) findViewById(R.id.txtDataA5);

    TextView labelB = (TextView) findViewById(R.id.txtDataB);
    TextView labelB1 = (TextView) findViewById(R.id.txtDataB1);
    TextView labelB2 = (TextView) findViewById(R.id.txtDataB2);
    TextView labelB3 = (TextView) findViewById(R.id.txtDataB3);
    TextView labelB4 = (TextView) findViewById(R.id.txtDataB4);
    TextView labelB5 = (TextView) findViewById(R.id.txtDataB5);

    TextView labelC = (TextView) findViewById(R.id.txtDataC);
    TextView labelC1 = (TextView) findViewById(R.id.txtDataC1);
    TextView labelC2 = (TextView) findViewById(R.id.txtDataC2);
    TextView labelC3 = (TextView) findViewById(R.id.txtDataC3);
    TextView labelC4 = (TextView) findViewById(R.id.txtDataC4);
    TextView labelC5 = (TextView) findViewById(R.id.txtDataC5); */

    //Added by Andrew

    String[] cActivity;
    String[] sActivity;
    String[] wActivity;

    String tempStr;


    // Used to read from the file.

    public InputStream input;

    // Used to get the individual lines from the asset file.

    public BufferedReader reader;

    //The String where the parsed lines are stored.

    public String line;

    String[] trekArray;


    // The arrayList where the tasks are stored.
    //public static ArrayList<String> trekInfo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        trekArray = new String[11];
        cActivity = new String[15];
        sActivity = new String[15];
        wActivity = new String[15];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previoustreks);

        TextView labelA = (TextView) findViewById(R.id.DataA);
        TextView labelA1 = (TextView) findViewById(R.id.txtDataA1);
        TextView labelA2 = (TextView) findViewById(R.id.txtDataA2);
        TextView labelA3 = (TextView) findViewById(R.id.txtDataA3);
        TextView labelA4 = (TextView) findViewById(R.id.txtDataA4);
        TextView labelA5 = (TextView) findViewById(R.id.txtDataA5);

        TextView labelB = (TextView) findViewById(R.id.txtDataB);
        TextView labelB1 = (TextView) findViewById(R.id.txtDataB1);
        TextView labelB2 = (TextView) findViewById(R.id.txtDataB2);
        TextView labelB3 = (TextView) findViewById(R.id.txtDataB3);
        TextView labelB4 = (TextView) findViewById(R.id.txtDataB4);
        TextView labelB5 = (TextView) findViewById(R.id.txtDataB5);

        TextView labelC = (TextView) findViewById(R.id.txtDataC);
        TextView labelC1 = (TextView) findViewById(R.id.txtDataC1);
        TextView labelC2 = (TextView) findViewById(R.id.txtDataC2);
        TextView labelC3 = (TextView) findViewById(R.id.txtDataC3);
        TextView labelC4 = (TextView) findViewById(R.id.txtDataC4);
        TextView labelC5 = (TextView) findViewById(R.id.txtDataC5);

        //labelA.setText("Please choose an option \nabove to see previous activity.");

        labelA1.setVisibility(View.INVISIBLE);
        labelA2.setVisibility(View.INVISIBLE);
        labelA3.setVisibility(View.INVISIBLE);
        labelA4.setVisibility(View.INVISIBLE);
        labelA5.setVisibility(View.INVISIBLE);

        labelB.setVisibility(View.INVISIBLE);
        labelB1.setVisibility(View.INVISIBLE);
        labelB2.setVisibility(View.INVISIBLE);
        labelB3.setVisibility(View.INVISIBLE);
        labelB4.setVisibility(View.INVISIBLE);
        labelB5.setVisibility(View.INVISIBLE);

        labelC.setVisibility(View.INVISIBLE);
        labelC1.setVisibility(View.INVISIBLE);
        labelC2.setVisibility(View.INVISIBLE);
        labelC3.setVisibility(View.INVISIBLE);
        labelC4.setVisibility(View.INVISIBLE);
        labelC5.setVisibility(View.INVISIBLE);



        BufferedReader bufferReader = null;

        try {
            // Opens the asset file.
            FileInputStream fileInputStream = openFileInput("energytrekdata.txt");
            // Prepares the reader object.
            bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

            line = bufferReader.readLine();

            while (line != null ) {

                trekArray = line.split(";");


                tempStr = null;

                //If the category is Calories it will run this.
                if (trekArray[0].equals("C")) {
                    if (cActivity[0] == null) {
                        tempStr = trekArray[4];
                        cActivity[0] = tempStr;
                    } else if (cActivity[1] == null) {
                        tempStr = trekArray[4];
                        cActivity[1] = tempStr;
                    } else if (cActivity[2] == null) {
                        tempStr = trekArray[4];
                        cActivity[2] = tempStr;
                    } else if (cActivity[3] == null) {
                        tempStr = trekArray[4];
                        cActivity[3] = tempStr;
                    } else if (cActivity[4] == null) {
                        tempStr = trekArray[4];
                        cActivity[4] = tempStr;
                    }

                }

                //If the category is sleep it will run this.
                if (trekArray[0].equals("S")) {
                    if (sActivity[0] == null) {
                        tempStr = trekArray[4];
                        sActivity[0] = tempStr;
                    } else if (sActivity[1] == null) {
                        tempStr = trekArray[4];
                        sActivity[1] = tempStr;
                    } else if (sActivity[2] == null) {
                        tempStr = trekArray[4];
                        sActivity[2] = tempStr;
                    } else if (sActivity[3] == null) {
                        tempStr = trekArray[4];
                        sActivity[3] = tempStr;
                    } else if (sActivity[4] == null) {
                        tempStr = trekArray[4];
                        sActivity[4] = tempStr;
                    }

                }

                //If the category is water it will run this.
                if (trekArray[0].equals("W")) {
                    if (wActivity[0] == null) {
                        tempStr = trekArray[4];
                        wActivity[0] = tempStr;
                    } else if (wActivity[1] == null) {
                        tempStr = trekArray[4];
                        wActivity[1] = tempStr;
                    } else if (wActivity[2] == null) {
                        tempStr = trekArray[4];
                        wActivity[2] = tempStr;
                    } else if (wActivity[3] == null) {
                        tempStr = trekArray[4];
                        wActivity[3] = tempStr;
                    } else if (wActivity[4] == null) {
                        tempStr = trekArray[4];
                        wActivity[4] = tempStr;
                    }

                }

                //Read the next line
                line = bufferReader.readLine();
            }



            //while (line != null) {
            //trekInfo.add(line);
            //String[] trekInfo = line.split(";");
            // }

            //if (trekArray[0].equals("C")) {
            //   cArray.add(trekArray[5]);
            //    System.out.println(cArray);
            // } else if (trekArray[0].toString() == "S") {
            //    sArray.add(trekArray[5]);
            // } else if (trekArray[0].toString() == "W") {
            //     wArray.add(trekArray[5]);
            // }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        TextView labelA = (TextView) findViewById(R.id.DataA);
        TextView labelA1 = (TextView) findViewById(R.id.txtDataA1);
        TextView labelA2 = (TextView) findViewById(R.id.txtDataA2);
        TextView labelA3 = (TextView) findViewById(R.id.txtDataA3);
        TextView labelA4 = (TextView) findViewById(R.id.txtDataA4);
        TextView labelA5 = (TextView) findViewById(R.id.txtDataA5);

        TextView labelB = (TextView) findViewById(R.id.txtDataB);
        TextView labelB1 = (TextView) findViewById(R.id.txtDataB1);
        TextView labelB2 = (TextView) findViewById(R.id.txtDataB2);
        TextView labelB3 = (TextView) findViewById(R.id.txtDataB3);
        TextView labelB4 = (TextView) findViewById(R.id.txtDataB4);
        TextView labelB5 = (TextView) findViewById(R.id.txtDataB5);

        TextView labelC = (TextView) findViewById(R.id.txtDataC);
        TextView labelC1 = (TextView) findViewById(R.id.txtDataC1);
        TextView labelC2 = (TextView) findViewById(R.id.txtDataC2);
        TextView labelC3 = (TextView) findViewById(R.id.txtDataC3);
        TextView labelC4 = (TextView) findViewById(R.id.txtDataC4);
        TextView labelC5 = (TextView) findViewById(R.id.txtDataC5);

        labelA1.setVisibility(View.VISIBLE);
        labelA2.setVisibility(View.VISIBLE);
        labelA3.setVisibility(View.VISIBLE);
        labelA4.setVisibility(View.VISIBLE);
        labelA5.setVisibility(View.VISIBLE);

        labelB.setVisibility(View.VISIBLE);
        labelB1.setVisibility(View.VISIBLE);
        labelB2.setVisibility(View.VISIBLE);
        labelB3.setVisibility(View.VISIBLE);
        labelB4.setVisibility(View.VISIBLE);
        labelB5.setVisibility(View.VISIBLE);

        labelC.setVisibility(View.VISIBLE);
        labelC1.setVisibility(View.VISIBLE);
        labelC2.setVisibility(View.VISIBLE);
        labelC3.setVisibility(View.VISIBLE);
        labelC4.setVisibility(View.VISIBLE);
        labelC5.setVisibility(View.VISIBLE);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    labelA1.setText(wActivity[0]);
                labelA2.setText(wActivity[1]);
                labelA3.setText(wActivity[2]);
                labelA4.setText(wActivity[3]);
                labelA5.setText(wActivity[4]);

                break;
            case R.id.radio_calories:
                if (checked)
                    labelA.setText("Calories Consumed Per Day");

                labelA1.setText(cActivity[0]);
                labelA2.setText(cActivity[1]);
                labelA3.setText(cActivity[2]);
                labelA4.setText(cActivity[3]);
                labelA5.setText(cActivity[4]);

                break;
            case R.id.radio_sleep:
                if (checked)
                    labelA1.setText(sActivity[0]);
                labelA2.setText(sActivity[1]);
                labelA3.setText(sActivity[2]);
                labelA4.setText(sActivity[3]);
                labelA5.setText(sActivity[4]);
                break;
        }
    }

    /** Called when the user clicks the Menu button */
    public void menu(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    /** Called when the user clicks the Enter button */
    public void enter(View view) {
        Intent progressIntent = new Intent(this, PreviousTreksActivity.class);
        startActivity(progressIntent);
    }
}