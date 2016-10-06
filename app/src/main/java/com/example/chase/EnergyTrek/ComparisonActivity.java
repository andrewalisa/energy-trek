package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ComparisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);
    }

    /** Called when the user clicks the Enter Health Info. button */
    public void enterHealthInfo(View view) {
        Intent healthInfoIntent = new Intent(this, HealthInfoActivity.class);
        startActivity(healthInfoIntent);
    }

    /** Called when the user clicks the Goals button */
    public void goals(View view) {
        Intent goalsIntent = new Intent(this, GoalsActivity.class);
        startActivity(goalsIntent);
    }

    /** Called when the user clicks the Progress button */
    public void progress(View view) {
        Intent progressIntent = new Intent(this, ProgressActivity.class);
        startActivity(progressIntent);
    }
}
