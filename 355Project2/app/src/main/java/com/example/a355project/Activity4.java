package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
    }

    //opens the mainActivity when the button is clicked
    public void openActivityMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}