package com.example.chase.EnergyTrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PreviousTreksActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previoustreks);
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
        TextView labelC5 = (TextView) findViewById(R.id.txtDataC5);

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
