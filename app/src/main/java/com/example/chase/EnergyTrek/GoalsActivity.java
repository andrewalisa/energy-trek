package com.example.chase.EnergyTrek;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
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

    //Category String to determine what category the item is
    String categoryStr = "C";

    // Used to write to the textfile.

    public BufferedWriter writer;
    private Context context;

    String q1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_today);
    }

    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.calories);

        label1.setText("");

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    label1.setHint("Cups of water per day");
                categoryStr = "W";
                break;
            case R.id.radio_calories:
                if (checked)
                    label1.setHint("Calories consumed per day");
                categoryStr = "C";
                break;
            case R.id.radio_sleep:
                if (checked)
                    label1.setHint("Time asleep (in hours)");
                categoryStr = "S";
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
        //Declaring f as file
        File f = null;
        boolean chkExist = false;

        EditText label1 = (EditText) findViewById(R.id.calories);
        DatePicker DatePicker1 = (DatePicker) findViewById(R.id.datePicker2);

        Integer date, month, year;
        Boolean Taken = false, notFuture = true;
        String testDates[] = new String[125];

        //If statement to check if energytrekdata.txt exists. If it exists then it will run code that will confirm the data is good.
        //If the data is FALSE then it will run the else statement, which is to write/output energytrek.txt

        try {

            //Putting "energytrekdata.txt" into variable
            f = new File("energytrekdata.txt");

            //Checking if "energytrekdata.txt" exists, if it does exist, it chkExist will be true, otherwise it will be false
            chkExist = f.exists();

        } catch (Exception e){
            e.printStackTrace();
        }

        if (chkExist == true) {
            for (int Y = 0; Y < 125; Y++)
                testDates[Y] = "";

            //Here begins the program begins for real
            q1 = label1.getText().toString();   //Check to see if the EditText is blank
            if (q1.compareTo("") == 0) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Invalid entry.");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else { //If it's not...

                date = DatePicker1.getDayOfMonth();
                month = DatePicker1.getMonth();
                year = DatePicker1.getYear();

                //Set the Date
                Date dateToday = Calendar.getInstance().getTime();
                //Set the format
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                //Put it in the string
                String strDate = formatter.format(dateToday);

                Integer checkLength, datatype = 0, dayToday, monthToday, yearToday;
                String segCheck, today[] = new String[3];
                today[0] = "";
                today[1] = "";
                today[2] = "";

                checkLength = strDate.length();

                //*****************************************************************************
                //  This for loop below is used repeatedly throughout the program to take a big string
                //with multiple parts to it and break it down into an array in which each entry is one
                //of those parts. It uses the same variables more or less.
                //*****************************************************************************

                //Use this for loop to get today's date
                for (int counter = 0; counter < checkLength; counter++) {
                    segCheck = strDate.substring(counter, counter + 1);
                    if (segCheck.compareTo("-") == 0) {
                        datatype = datatype + 1;
                    } else {
                        today[datatype] = today[datatype] + segCheck;
                    }
                }

                dayToday = Integer.parseInt(today[1]);
                monthToday = Integer.parseInt(today[0]);
                yearToday = Integer.parseInt(today[2]);

                //Now compare today's date to the date the user entered
                if (year > yearToday)
                    notFuture = false;
                else if (month > monthToday)
                    notFuture = false;
                else if (date > dayToday)
                    notFuture = false;

                //If it's in the future, that's not possible
                if (!notFuture) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Date cannot be beyond today.");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                } else { //If it's in the present/recent past...

                    BufferedReader bufferReader = null;
                    BufferedWriter bufferWriter = null;

                    String line;

                    String[] trekArray;

                    //We need to make sure there is no entry already for the valid date the user entered
                    try {
                        Integer counter = 0;
                        // Opens the asset file.
                        FileInputStream fileInputStream = openFileInput("energytrekdata.txt");
                        // Prepares the reader object.
                        bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

                        line = bufferReader.readLine();

                        //Take at least 120 entries (guarentees a month) and put them in an array
                        while (line != null && counter < 125) {
                            testDates[counter] = line;
                            counter++;
                            line = bufferReader.readLine();
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    //Take each entry in the array and break it down into it's individual pieces.
                    //This will make it easier to check the user data against previous entries, like trimming off the fat
                    for (int X = 0; X < 125; X++) {
                        String temp;
                        Integer inputLength;
                        String hold[] = new String[6];
                        for (int Y = 0; Y < 6; Y++)
                            hold[Y] = "";
                        datatype = 0;

                        temp = testDates[X];
                        inputLength = temp.length();

                        for (int counter = 0; counter < inputLength; counter++) {
                            segCheck = temp.substring(counter, counter + 1);
                            if (segCheck.compareTo(";") == 0) {
                                datatype = datatype + 1;
                            } else {
                                hold[datatype] = hold[datatype] + segCheck;
                            }
                        }

                        //Then keep the date and category related pieces
                        testDates[X] = hold[0] + ";" + hold[1] + ";" + hold[2] + ";" + hold[3];

                    }

                    //Now that we have a mini date/category specified array, let's check it against the user's entry
                    for (int X = 0; X < 125; X++) {
                        Integer dateC, monthC, yearC;

                        String temp;
                        Integer inputLength;
                        String held[] = new String[4];
                        for (int Y = 0; Y < 4; Y++)
                            held[Y] = "";
                        datatype = 0;

                        temp = testDates[X];
                        inputLength = temp.length();

                        //Further seperate each entry into a checkable piece
                        for (int counter = 0; counter < inputLength; counter++) {
                            segCheck = temp.substring(counter, counter + 1);
                            if (segCheck.compareTo(";") == 0) {
                                datatype = datatype + 1;
                            } else {
                                held[datatype] = held[datatype] + segCheck;
                            }

                        }

                        //Exclude all empty sets within the 120 entry array. This further trims the fat
                        if (held[2].compareTo("") != 0) {
                            dateC = Integer.parseInt(held[1]);
                            monthC = Integer.parseInt(held[2]);
                            yearC = Integer.parseInt(held[3]);

                            //If the category and the date matches exactly, then the entry is taken
                            //Can still have different categories on the same day
                            if (held[0].compareTo(categoryStr) == 0 && yearC.equals(year) && monthC.equals(month) && dateC.equals(date))
                                Taken = true;
                        }
                    }

                    //This begins the actual storage of data
                    if (Taken) { //If the date has a previous entry of that type...
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Date already has entry");
                        dlgAlert.setTitle("Error");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    } else { //Otherwise...
                        try {
                            //Store that sucker
                            FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
                            bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                            bufferWriter.write(categoryStr + ";" + date + ";" + month + ";" + year + ";" + q1);
                            bufferWriter.append("\n");

                            //Let the user know it's been stored and reset the entry box
                            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                            dlgAlert.setMessage("Data stored!");
                            dlgAlert.setTitle("Success!");
                            dlgAlert.setPositiveButton("OK", null);
                            dlgAlert.setCancelable(true);
                            dlgAlert.create().show();

                            label1.setText("");

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
            }
        }
        //If the File does not exist, it then creates the file. Without this code, there would be an error.
        else {

            q1 = label1.getText().toString();   //Check to see if the EditText is blank
            if (q1.compareTo("") == 0) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Invalid entry.");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }else
                try {
                    //Store that sucker
                    BufferedReader bufferReader1 = null;
                    BufferedWriter bufferWriter1 = null;
                    date = DatePicker1.getDayOfMonth();
                    month = DatePicker1.getMonth();
                    year = DatePicker1.getYear();

                    FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
                    bufferWriter1 = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    bufferWriter1.write(categoryStr + ";" + date + ";" + month + ";" + year + ";" + q1);
                    bufferWriter1.append("\n");

                    //Let the user know it's been stored and reset the entry box
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Data stored!");
                    dlgAlert.setTitle("Success!");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    label1.setText("");

                    bufferWriter1.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }





/************************************************************************************************
 try {
 // Opens the asset file.
 FileInputStream fileInputStream = openFileInput("energytrekdata.txt");
 // Prepares the reader object.
 bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

 line = bufferReader.readLine();
 q1 = label1.getText().toString();

 while (line != null ) {
 trekArray = line.split(";");

 if (trekArray[3].equals(year)) {
 if (trekArray[2].equals(month)) {
 if (trekArray[1].equals(date)) {
 AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
 dlgAlert.setMessage("Date already has entry");
 dlgAlert.setTitle("Error");
 dlgAlert.setPositiveButton("OK", null);
 dlgAlert.setCancelable(true);
 dlgAlert.create().show();
 } else {
 try {
 FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
 bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
 bufferWriter.write(categoryStr + ";" + date + ";" + month + ";" + year + ";" + q1);
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

 //Read the next line
 line = bufferReader.readLine();
 }

 }
 }
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

 //Set the Date
 Date dateToday = Calendar.getInstance().getTime();
 //Set the format
 SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
 //Put it in the string
 String strDate = formatter.format(dateToday);
 //Set the time format
 SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
 //Putting the time in the string
 String strTime = formatTime.format(dateToday);


 //Default value is C because calories is the first screen they see.
 if (categoryStr == null) {
 categoryStr = "C";
 }

 //Putting the text from the labels into the string
 q1 = label1.getText().toString();



 BufferedWriter bufferWriter = null;
 try {
 FileOutputStream fileOutputStream = openFileOutput("energytrekdata.txt", Context.MODE_APPEND);
 bufferWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
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

 */
    }
}
