package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;

public class HealthInfoActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_health_info);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.calories);
        EditText label2 = (EditText) findViewById(R.id.time);


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    label1.setHint("How much water did you drink");
                    label2.setHint("At what time?");
                    break;
            case R.id.radio_calories:
                if (checked)
                    label1.setHint("How many calories did you consume?");
                    label2.setHint("At what time?");
                    break;
            case R.id.radio_sleep:
                if (checked)
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
    

}
