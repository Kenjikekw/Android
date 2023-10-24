package com.example.act1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        adapter.addFragment(new TextFragment(), "Texto");
        adapter.addFragment(new ImageFragment(), "Imagen");
        adapter.addFragment(new FormFragment(), "Formulario");

        viewPager.setAdapter(adapter);
    }
}