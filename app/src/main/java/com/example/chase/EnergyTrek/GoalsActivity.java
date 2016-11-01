package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class GoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_today);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);
        EditText label3 = (EditText) findViewById(R.id.property3);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    label1.setHint("Cups of water per day");
                    label2.setHint("Time between cups (in hours?)");
                    break;
            case R.id.radio_calories:
                if (checked)
                    label1.setHint("Calories consumed per day");
                    label2.setHint("Meals/snacks per day");
                    label3.setHint("Time since last meal (in hours)");
                    break;
            case R.id.radio_sleep:
                if (checked)
                    label1.setHint("Amount of time asleep (in hours)");
                    label2.setHint("Time to be asleep each night?");
                    label3.setHint("Time spent in naps");

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
