package com.example.chase.EnergyTrek;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PreviousTreksActivity extends AppCompatActivity {

    String removeLinetxt;

    //Added by Andrew

    String[] cActivity;
    String[] sActivity;
    String[] wActivity;

    String[] cActivityFullStr;
    String[] sActivityFullStr;
    String[] wActivityFullStr;

    int numofArr;


    String tempStr;

    String fullTempStr;




    int i;


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

        cActivityFullStr = new String[15];
        wActivityFullStr = new String[15];
        sActivityFullStr = new String[15];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previoustreks);

        TextView labelA = (TextView) findViewById(R.id.DataA);
        TextView labelA1 = (TextView) findViewById(R.id.txtDataA1);
        TextView labelA2 = (TextView) findViewById(R.id.txtDataA2);
        TextView labelA3 = (TextView) findViewById(R.id.txtDataA3);
        TextView labelA4 = (TextView) findViewById(R.id.txtDataA4);
        TextView labelA5 = (TextView) findViewById(R.id.txtDataA5);

        TextView delBtn1 = (TextView) findViewById(R.id.dltButton1);
        TextView delBtn2 = (TextView) findViewById(R.id.dltButton2);
        TextView delBtn3 = (TextView) findViewById(R.id.dltButton3);
        TextView delBtn4 = (TextView) findViewById(R.id.dltButton4);
        TextView delBtn5 = (TextView) findViewById(R.id.dltButton5);


  /*      TextView labelB = (TextView) findViewById(R.id.txtDataB);
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

        //labelA.setText("Please choose an option \nabove to see previous activity.");

        labelA1.setVisibility(View.INVISIBLE);
        labelA2.setVisibility(View.INVISIBLE);
        labelA3.setVisibility(View.INVISIBLE);
        labelA4.setVisibility(View.INVISIBLE);
        labelA5.setVisibility(View.INVISIBLE);

        delBtn1.setVisibility(View.INVISIBLE);
        delBtn2.setVisibility(View.INVISIBLE);
        delBtn3.setVisibility(View.INVISIBLE);
        delBtn4.setVisibility(View.INVISIBLE);
        delBtn5.setVisibility(View.INVISIBLE);

/*
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
        labelC5.setVisibility(View.INVISIBLE); */



        BufferedReader bufferReader = null;

        try {
            // Opens the asset file.
            FileInputStream fileInputStream = openFileInput("energytrekdata.txt");
            // Prepares the reader object.
            bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

            line = bufferReader.readLine();

            while (line != null ) {

                fullTempStr = line.toString();

                trekArray = line.split(";");

                tempStr = null;


                //If the category is Calories it will run this.
                if (trekArray[0].equals("C")) {
                    if (cActivity[0] == null) {
                        tempStr = trekArray[4];
                        cActivity[0] = tempStr;
                        cActivityFullStr[0] = fullTempStr;

                    } else if (cActivity[1] == null) {
                        tempStr = trekArray[4];
                        cActivity[1] = tempStr;
                        cActivityFullStr[1] = fullTempStr;

                    } else if (cActivity[2] == null) {
                        tempStr = trekArray[4];
                        cActivity[2] = tempStr;
                        cActivityFullStr[2] = fullTempStr;

                    } else if (cActivity[3] == null) {
                        tempStr = trekArray[4];
                        cActivity[3] = tempStr;
                        cActivityFullStr[3] = fullTempStr;

                    } else if (cActivity[4] == null) {
                        tempStr = trekArray[4];
                        cActivity[4] = tempStr;
                        cActivityFullStr[4] = fullTempStr;
                    }




                }

                //If the category is sleep it will run this.
                if (trekArray[0].equals("S")) {
                    if (sActivity[0] == null) {
                        tempStr = trekArray[4];
                        sActivity[0] = tempStr;
                        sActivityFullStr[0] = fullTempStr;

                    } else if (sActivity[1] == null) {
                        tempStr = trekArray[4];
                        sActivity[1] = tempStr;
                        sActivityFullStr[1] = fullTempStr;

                    } else if (sActivity[2] == null) {
                        tempStr = trekArray[4];
                        sActivity[2] = tempStr;
                        sActivityFullStr[2] = fullTempStr;

                    } else if (sActivity[3] == null) {
                        tempStr = trekArray[4];
                        sActivity[3] = tempStr;
                        sActivityFullStr[3] = fullTempStr;

                    } else if (sActivity[4] == null) {
                        tempStr = trekArray[4];
                        sActivity[4] = tempStr;
                        sActivityFullStr[4] = fullTempStr;
                    }


                }

                //If the category is water it will run this.
                if (trekArray[0].equals("W")) {

                    if (wActivity[0] == null) {
                        tempStr = trekArray[4];
                        wActivity[0] = tempStr;
                        wActivityFullStr[0] = fullTempStr;

                    } else if (wActivity[1] == null) {
                        tempStr = trekArray[4];
                        wActivity[1] = tempStr;
                        wActivityFullStr[1] = fullTempStr;

                    } else if (wActivity[2] == null) {
                        tempStr = trekArray[4];
                        wActivity[2] = tempStr;
                        wActivityFullStr[2] = fullTempStr;

                    } else if (wActivity[3] == null) {
                        tempStr = trekArray[4];
                        wActivity[3] = tempStr;
                        wActivityFullStr[3] = fullTempStr;
                    } else if (wActivity[4] == null) {
                        tempStr = trekArray[4];
                        wActivity[4] = tempStr;
                        wActivityFullStr[4] = fullTempStr;
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
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            try {
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
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

        TextView delBtn1 = (TextView) findViewById(R.id.dltButton1);
        TextView delBtn2 = (TextView) findViewById(R.id.dltButton2);
        TextView delBtn3 = (TextView) findViewById(R.id.dltButton3);
        TextView delBtn4 = (TextView) findViewById(R.id.dltButton4);
        TextView delBtn5 = (TextView) findViewById(R.id.dltButton5);
/*
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

        labelA1.setVisibility(View.VISIBLE);
        labelA2.setVisibility(View.VISIBLE);
        labelA3.setVisibility(View.VISIBLE);
        labelA4.setVisibility(View.VISIBLE);
        labelA5.setVisibility(View.VISIBLE);



 /*       labelB.setVisibility(View.VISIBLE);
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
        labelC5.setVisibility(View.VISIBLE); */

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    labelA.setText("Cups of water per day:");

                labelA1.setText(wActivity[0]);
                labelA2.setText(wActivity[1]);
                labelA3.setText(wActivity[2]);
                labelA4.setText(wActivity[3]);
                labelA5.setText(wActivity[4]);

                if (labelA1.getText() == "") {
                    delBtn1.setVisibility(View.INVISIBLE);
                } else {
                    delBtn1.setVisibility(View.VISIBLE);
                }

                if (labelA2.getText() == "") {
                    delBtn2.setVisibility(View.INVISIBLE);
                } else {
                    delBtn2.setVisibility(View.VISIBLE);
                }

                if (labelA3.getText() == "") {
                    delBtn3.setVisibility(View.INVISIBLE);
                } else {
                    delBtn3.setVisibility(View.VISIBLE);
                }

                if (labelA4.getText() == "") {
                    delBtn4.setVisibility(View.INVISIBLE);
                } else {
                    delBtn4.setVisibility(View.VISIBLE);
                }

                if (labelA5.getText() == "") {
                    delBtn5.setVisibility(View.INVISIBLE);
                } else {
                    delBtn5.setVisibility(View.VISIBLE);
                }



                break;
            case R.id.radio_calories:
                if (checked)
                    labelA.setText("Calories consumed per day:");

                labelA1.setText(cActivity[0]);
                labelA2.setText(cActivity[1]);
                labelA3.setText(cActivity[2]);
                labelA4.setText(cActivity[3]);
                labelA5.setText(cActivity[4]);

                if (labelA1.getText() == "") {
                    delBtn1.setVisibility(View.INVISIBLE);
                } else {
                    delBtn1.setVisibility(View.VISIBLE);
                }

                if (labelA2.getText() == "") {
                    delBtn2.setVisibility(View.INVISIBLE);
                } else {
                    delBtn2.setVisibility(View.VISIBLE);
                }

                if (labelA3.getText() == "") {
                    delBtn3.setVisibility(View.INVISIBLE);
                } else {
                    delBtn3.setVisibility(View.VISIBLE);
                }

                if (labelA4.getText() == "") {
                    delBtn4.setVisibility(View.INVISIBLE);
                } else {
                    delBtn4.setVisibility(View.VISIBLE);
                }

                if (labelA5.getText() == "") {
                    delBtn5.setVisibility(View.INVISIBLE);
                } else {
                    delBtn5.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.radio_sleep:
                if (checked)
                    labelA.setText("Time asleep (in hours):");

                labelA1.setText(sActivity[0]);
                labelA2.setText(sActivity[1]);
                labelA3.setText(sActivity[2]);
                labelA4.setText(sActivity[3]);
                labelA5.setText(sActivity[4]);

                if (labelA1.getText() == "") {
                    delBtn1.setVisibility(View.INVISIBLE);
                } else {
                    delBtn1.setVisibility(View.VISIBLE);
                }

                if (labelA2.getText() == "") {
                    delBtn2.setVisibility(View.INVISIBLE);
                } else {
                    delBtn2.setVisibility(View.VISIBLE);
                }

                if (labelA3.getText() == "") {
                    delBtn3.setVisibility(View.INVISIBLE);
                } else {
                    delBtn3.setVisibility(View.VISIBLE);
                }

                if (labelA4.getText() == "") {
                    delBtn4.setVisibility(View.INVISIBLE);
                } else {
                    delBtn4.setVisibility(View.VISIBLE);
                }

                if (labelA5.getText() == "") {
                    delBtn5.setVisibility(View.INVISIBLE);
                } else {
                    delBtn5.setVisibility(View.VISIBLE);
                }



                break;
        }



    }

    /*public void delete(View view) {
        //Intent progressIntent = new Intent(this, PreviousTreksActivity.class);
        //startActivity(progressIntent);
        //Let the user know it's been stored and reset the entry box
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Data stored!");
        dlgAlert.setTitle("Success!");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    } */

    /** Called when the user clicks the Menu button */
    public void menu(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    /** Called when the user clicks the Delete button */
    public void delete(View view) {
        removeLinetxt = null;

        TextView delBtn1 = (TextView) findViewById(R.id.dltButton1);
        TextView delBtn2 = (TextView) findViewById(R.id.dltButton2);
        TextView delBtn3 = (TextView) findViewById(R.id.dltButton3);
        TextView delBtn4 = (TextView) findViewById(R.id.dltButton4);
        TextView delBtn5 = (TextView) findViewById(R.id.dltButton5);
        RadioButton waterBtn = (RadioButton) findViewById(R.id.radio_water);
        RadioButton calBtn = (RadioButton) findViewById(R.id.radio_calories);
        RadioButton sleepBtn = (RadioButton) findViewById(R.id.radio_sleep);

        //Intent progressIntent = new Intent(this, PreviousTreksActivity.class);
        //startActivity(progressIntent);

        if (delBtn1.isPressed()) {
            if (waterBtn.isChecked()) {
                removeLinetxt = wActivityFullStr[0];
            }else if (calBtn.isChecked()) {
                removeLinetxt = cActivityFullStr[0];
            }else if (sleepBtn.isChecked()) {
                removeLinetxt = sActivityFullStr[0];
            }
            numofArr = 0;


        }

        if (delBtn2.isPressed()) {
            if (waterBtn.isChecked()) {
                removeLinetxt = wActivityFullStr[1];
            }else if (calBtn.isChecked()) {
                removeLinetxt = cActivityFullStr[1];
            }else if (sleepBtn.isChecked()) {
                removeLinetxt = sActivityFullStr[1];
            }

            numofArr = 1;

        }

        if (delBtn3.isPressed()) {
            if (waterBtn.isChecked()) {
                removeLinetxt = wActivityFullStr[2];
            }else if (calBtn.isChecked()) {
                removeLinetxt = cActivityFullStr[2];
            }else if (sleepBtn.isChecked()) {
                removeLinetxt = sActivityFullStr[2];
            }
            numofArr = 2;
        }

        if (delBtn4.isPressed()) {
            if (waterBtn.isChecked()) {
                removeLinetxt = wActivityFullStr[3];
            }else if (calBtn.isChecked()) {
                removeLinetxt = cActivityFullStr[3];
            }else if (sleepBtn.isChecked()) {
                removeLinetxt = sActivityFullStr[3];
            }
            numofArr = 3;
        }

        if (delBtn5.isPressed()) {
            if (waterBtn.isChecked()) {
                removeLinetxt = wActivityFullStr[4];
            }else if (calBtn.isChecked()) {
                removeLinetxt = cActivityFullStr[4];
            }else if (sleepBtn.isChecked()) {
                removeLinetxt = sActivityFullStr[4];
            }
            numofArr = 4;
        }


        AlertDialog diaBox = AskOption();
        diaBox.show();



    }






//Confirms with the user "Do you want to delete this entry?"
    private AlertDialog AskOption() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Do you want to delete this entry?")

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code

                        removeLineFromFile(removeLinetxt);



                        //dialog.dismiss();
                    }

                })



                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return alertDialog;

    }

    public void removeLineFromFile(String lineToRemove) {

        TextView labelA1 = (TextView) findViewById(R.id.txtDataA1);
        TextView labelA2 = (TextView) findViewById(R.id.txtDataA2);
        TextView labelA3 = (TextView) findViewById(R.id.txtDataA3);
        TextView labelA4 = (TextView) findViewById(R.id.txtDataA4);
        TextView labelA5 = (TextView) findViewById(R.id.txtDataA5);

        TextView delBtn1 = (TextView) findViewById(R.id.dltButton1);
        TextView delBtn2 = (TextView) findViewById(R.id.dltButton2);
        TextView delBtn3 = (TextView) findViewById(R.id.dltButton3);
        TextView delBtn4 = (TextView) findViewById(R.id.dltButton4);
        TextView delBtn5 = (TextView) findViewById(R.id.dltButton5);


        //String file = "energytrekdata.txt";
        File f = new File("/data/data/com.example.chase.firstexample/files/energytrekdata.txt");

        try {

            //File inFile = new File(file);
            FileInputStream fileInputStream1 = openFileInput("energytrekdata.txt");

            if (!f.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("/data/data/com.example.chase.firstexample/files/energytrekdata.txt" + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!f.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(f)) {
                System.out.println("Could not rename file");
            }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        if (numofArr == 0) {
            labelA1.setVisibility(View.INVISIBLE);
            delBtn1.setVisibility(View.INVISIBLE);
        }
        if (numofArr == 1) {
            labelA2.setVisibility(View.INVISIBLE);
            delBtn2.setVisibility(View.INVISIBLE);
        }
        if (numofArr == 2) {
            labelA3.setVisibility(View.INVISIBLE);
            delBtn3.setVisibility(View.INVISIBLE);
        }
        if (numofArr == 3) {
            labelA4.setVisibility(View.INVISIBLE);
            delBtn4.setVisibility(View.INVISIBLE);
        }
        if (numofArr == 4) {
            labelA5.setVisibility(View.INVISIBLE);
            delBtn5.setVisibility(View.INVISIBLE);
        }


    }

 }