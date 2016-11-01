package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
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


    }

    /** Called when the user clicks the Enter Health Info. button */
    public void enterHealthInfo(View view) {
        Intent healthInfoIntent = new Intent(this, HealthInfoActivity.class);
        startActivity(healthInfoIntent);
    }



}
