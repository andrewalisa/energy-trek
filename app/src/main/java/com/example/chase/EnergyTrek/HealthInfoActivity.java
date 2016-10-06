package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.RadioButton;

public class HealthInfoActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_health_info);

         Spinner infoType2_spinner = (Spinner) findViewById(com.example.chase.EnergyTrek.R.id.infoType_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
         ArrayAdapter<CharSequence> infoType2_adapter = ArrayAdapter.createFromResource(this,
                 com.example.chase.EnergyTrek.R.array.infoType_spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
         infoType2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
         infoType2_spinner.setAdapter(infoType2_adapter);

         Spinner howMuchInfo2_spinner = (Spinner) findViewById(com.example.chase.EnergyTrek.R.id.howMuchInfo_spinner);
         ArrayAdapter<CharSequence> howMuchInfo2_adapter = ArrayAdapter.createFromResource(this,
                 com.example.chase.EnergyTrek.R.array.infoType_spinner_array, android.R.layout.simple_spinner_item);
         howMuchInfo2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         howMuchInfo2_spinner.setAdapter(howMuchInfo2_adapter);

         Spinner secondaryInfo2_spinner = (Spinner) findViewById(com.example.chase.EnergyTrek.R.id.secondaryInfo_spinner);
         ArrayAdapter<CharSequence> secondaryInfo2_adapter = ArrayAdapter.createFromResource(this,
                 com.example.chase.EnergyTrek.R.array.infoType_spinner_array, android.R.layout.simple_spinner_item);
         secondaryInfo2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         secondaryInfo2_spinner.setAdapter(secondaryInfo2_adapter);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_water:
                if (checked)
                    break;
            case R.id.radio_calories:
                if (checked)
                    break;
            case R.id.radio_sleep:
                if (checked)
                    break;
        }
    }

    /** Called when the user clicks the Goals button */
    public void main(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    /** Called when the user clicks the Progress button */
    public void enter(View view) {
        Intent progressIntent = new Intent(this, ProgressActivity.class);
        startActivity(progressIntent);
    }
}
