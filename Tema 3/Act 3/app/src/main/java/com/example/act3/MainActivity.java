package com.example.act3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView sampleTextView = findViewById(R.id.sampleTextView);
        Button styleOneBtn = findViewById(R.id.styleOneBtn);
        Button styleTwoBtn = findViewById(R.id.styleTwoBtn);

        styleOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleTextView.setTextAppearance(MainActivity.this, R.style.TextStyleOne);
            }
        });

        styleTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleTextView.setTextAppearance(MainActivity.this, R.style.TextStyleTwo);
            }
        });
    }
}