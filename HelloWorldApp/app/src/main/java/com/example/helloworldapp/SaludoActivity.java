package com.example.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        String saludo = getIntent().getStringExtra("SALUDO");
        TextView saludoTextView = findViewById(R.id.textView2); // Asegúrate de asignar el ID correcto
        saludoTextView.setText(saludo);
    }
}