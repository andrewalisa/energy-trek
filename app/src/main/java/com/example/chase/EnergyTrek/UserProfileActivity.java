package com.example.chase.EnergyTrek;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;
import static android.R.attr.category;
/**
 * Created by Caleb on 11/8/16.
 */

public class UserProfileActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.chase.EnergyTrek.R.layout.activity_userprofile);


        Button menu = (Button) findViewById(R.id.btnMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(UserProfileActivity.this, MainActivity.class);
                startActivity(profileIntent);
            }
        });
    }

}
