package com.example.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombreEditText = findViewById(R.id.editTextText); // Asegúrate de asignar el ID correcto
        Button saludoButton = findViewById(R.id.button); // Asegúrate de asignar el ID correcto

        saludoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString();
                String saludo = "¡Hola, " + nombre + "!";
                Toast.makeText(MainActivity.this, saludo, Toast.LENGTH_SHORT).show();
            }
        });

        String nombre = nombreEditText.getText().toString();
        String saludo = "¡Hola, " + nombre + "!";

        Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
        intent.putExtra("SALUDO", saludo);
        startActivity(intent);
    }


}