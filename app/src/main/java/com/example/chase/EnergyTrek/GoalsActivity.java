package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_goals);
    }

    /** Called when the user clicks the Enter Health Info. button */
    public void enterHealthInfo(View view) {
        Intent healthInfoIntent = new Intent(this, HealthInfoActivity.class);
        startActivity(healthInfoIntent);
    }

    /** Called when the user clicks the Progress button */
    public void progress(View view) {
        Intent progressIntent = new Intent(this, ProgressActivity.class);
        startActivity(progressIntent);
    }

    /** Called when the user clicks the Comparison button */
    public void comparison(View view) {
        Intent comparisonIntent = new Intent(this, ComparisonActivity.class);
        startActivity(comparisonIntent);
    }
}
