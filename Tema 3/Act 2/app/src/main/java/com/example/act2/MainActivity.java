package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image1);

        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.image2);

        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setImageResource(R.drawable.image3);

        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setImageResource(R.drawable.image4);

        ImageView imageView5 = findViewById(R.id.imageView5);
        imageView5.setImageResource(R.drawable.image5);
    }
}