package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Avoid adding things in here to improve app speed. Just create methods instead
        //Avoid using this for onClick listener, Just add a view parameter in the method and in the xml file use android:onClick="openActivity3" for an example.
        //See the openActivity3 method below for reference
        /*  button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

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

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}