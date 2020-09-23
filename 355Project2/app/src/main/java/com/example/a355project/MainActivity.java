package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Avoid adding things in here to improve app speed. Just create methods instead
        //Avoid using this for onClick listener, Just add a view parameter in the method and in the xml file use android:onClick="openActivity3" for an example.
        //See the openActivity3 method below for reference

        //UPDATE 9/22: Cannot fix the button in way specified above, error=makes the app exit.
        //Now the button does not work at all..... Dont know hwo to fix as it is the same as before it was commented out

        buttonAct2 = (Button) findViewById(R.id.button2);
        buttonAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openActivity2();
            }
        });

        /*
        //Initialize Tips Button
        Button tipsBtn = (Button) findViewById(R.id.button);
        tipsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });*/
    }

    //Tip button method
    public void openActivity3(View view) {
        Intent tipsIntent = new Intent(MainActivity.this, Activity3.class);
        startActivity(tipsIntent);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}