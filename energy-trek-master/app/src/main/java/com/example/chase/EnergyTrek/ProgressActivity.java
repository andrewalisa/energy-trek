package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_progress);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        EditText label1 = (EditText) findViewById(R.id.olderField1);
        EditText label2 = (EditText) findViewById(R.id.olderField2);
        EditText label3 = (EditText) findViewById(R.id.olderField3);
        EditText label4 = (EditText) findViewById(R.id.olderField4);
        EditText label5 = (EditText) findViewById(R.id.currentField1);
        EditText label6 = (EditText) findViewById(R.id.currentField2);
        EditText label7 = (EditText) findViewById(R.id.currentField3);
        EditText label8 = (EditText) findViewById(R.id.currentField4);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    label1.setHint("Cups of water per day");
                    label2.setHint("Time between cups (in hours?)");
                    label3.setHint("Amount of caffeine had");
                    label5.setHint("Cups of water per day");
                    label6.setHint("Time between cups (in hours?)");
                    label7.setHint("Amount of caffeine had");
                label4.setHint("");
                label8.setHint("");
                break;
            case R.id.radio_calories:
                if (checked)
                    label1.setHint("Amount of calories per day");
                    label2.setHint("Meals per day");
                    label3.setHint("Time between meals");
                    label5.setHint("Amount of calories per day");
                    label6.setHint("Meals per day");
                    label7.setHint("Time between meals");
                label4.setHint("");
                label8.setHint("");
                break;
            case R.id.radio_sleep:
                if (checked)
                    label1.setHint("Amount of time asleep");
                    label2.setHint("Time to bed");
                    label3.setHint("Naps per day");
                    label5.setHint("Amount of calories per day");
                    label6.setHint("Meals per day");
                    label7.setHint("Time between meals");
                label4.setHint("");
                label8.setHint("");
                break;
        }
    }

    /** Called when the user clicks the Menu button */
    public void menu(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
