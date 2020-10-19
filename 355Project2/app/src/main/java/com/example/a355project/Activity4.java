package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent intent = getIntent();
        String Style = intent.getStringExtra(Activity2.STYLE_TEXT);

        TextView styleTextView = (TextView) findViewById(R.id.styleSelection);

        styleTextView.setText(Style);
    }
}