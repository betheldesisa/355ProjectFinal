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

    }

    //Tip button method
    public void openActivity3(View view) {
        Intent tipsIntent = new Intent(MainActivity.this, Activity3.class);
        startActivity(tipsIntent);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity2(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}