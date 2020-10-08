package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//Jusitn Commit 4
public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //intialized buttons
    private Button button3;

    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        //navigate button and openMaps intent to open Map utility and go to chosen place
        button3 = (Button) findViewById(R.id.button12);
        Uri address = Uri.parse("geo:0,0 ?q=Canes+VCU"); //canes on campus for testing functionality
        final Intent openMaps = new Intent(Intent.ACTION_VIEW, address);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(openMaps.resolveActivity(getPackageManager()) != null) { //checks if there is an app installed that can handle gps
                    startActivity(openMaps); //opens openMaps Intent which calls google maps or other mapp utility to open

                }
            }

        });
    /*
    Spinner object creates the dropdown button for "Type of Food"
    */
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TypeOfFood, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    /*
    Making the delivery button stay dark when selected and return to default when unselected
     */

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            int select = 1;
            @Override
            public void onClick(View v) {
                if(select == 1){
                    button6.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    select = 0;
                }
                else if(select == 0){
                    button6.getBackground().clearColorFilter();
                    select = 1;
                }
            }
        });

    }

    //opens the mainActivity when the button is clicked
    public void openActivityMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /*** MADE BY JESUS ON 10/06/2020 ********************************************/
    /**** NEED TO FIX THIS BUTTON; DOES NOT CALL ACT3, GOES BACK TO MAIN ACT ****/
    //opens tips menu from Activity2 (TIPS MENU = ACTIVITY3
    public void openActivity3(View view) {
        Intent tipsIntent = new Intent(this, Activity3.class);
        startActivity(tipsIntent);
    }
    /*** IF DELETED, NEED TO DELETE TIPS BUTTON ON ACT2.XML; ALL THE WAY AT THE BOTTOM *****/
}