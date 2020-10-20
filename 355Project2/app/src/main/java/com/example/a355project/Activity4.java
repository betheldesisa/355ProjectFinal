package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent intent = getIntent();
        String Style = intent.getStringExtra(Activity2.STYLE_TEXT);
        String Price = intent.getStringExtra(Activity2.PRICE_TEXT);
        String Group = intent.getStringExtra(Activity2.GROUP_TEXT);

        TextView priceTextView = (TextView) findViewById(R.id.priceSelection);
        TextView styleTextView = (TextView) findViewById(R.id.styleSelection);
        TextView groupTextView = (TextView) findViewById(R.id.GroupSelection);

        priceTextView.setText(Price);
        styleTextView.setText(Style);
        groupTextView.setText(Group);
    }
}