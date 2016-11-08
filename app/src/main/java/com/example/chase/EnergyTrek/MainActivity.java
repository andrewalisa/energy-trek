package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    //Added by Andrew

     // Used to read from the file.

    public InputStream input;

     // Used to get the individual lines from the asset file.

    public BufferedReader reader;

     //The String where the parsed lines are stored.

    public String line;

     // The arrayList where the tasks are stored.
    public static ArrayList<String> trekinfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_mainconstraint);



        Button today = (Button) findViewById(R.id.btnToday);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalsIntent = new Intent(MainActivity.this, GoalsActivity.class);
                startActivity(goalsIntent);
            }
        });

        Button previousTreks = (Button) findViewById(R.id.btnPT);
        previousTreks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent progressIntent = new Intent(MainActivity.this, PreviousTreksActivity.class);
                startActivity(progressIntent);
            }
        });

        Button profile = (Button) findViewById(R.id.btnProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(MainActivity.this, UserProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        try {
            // Opens the asset file.
            input = this.getAssets().open("trekinfo.txt");
             // Prepares the reader object.
            reader = new BufferedReader(new InputStreamReader(input));

             // This string stores the read line. Will be used in the following while loop in the same manner.
             // Used here to assign it to a value other than null, so that the while loop can run.

            line = reader.readLine();

             // Adds the first read line to the trekinfo  arrayList, which is then added with the arrayList adapter to the listView.

            //trekinfo.add(line);

            String[] trekinfo = line.split(";");

            reader.close();

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
}

    /** Called when the user clicks the Enter Health Info. button */
    public void enterHealthInfo(View view) {
        Intent healthInfoIntent = new Intent(this, HealthInfoActivity.class);
        startActivity(healthInfoIntent);
    }



}
