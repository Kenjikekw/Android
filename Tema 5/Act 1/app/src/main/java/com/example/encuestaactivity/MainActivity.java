package com.example.encuestaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox1, checkBox2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinner;
    private Switch aSwitch;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        aSwitch = findViewById(R.id.switch1);
        fab = findViewById(R.id.fab);

        String[] opciones = {"Top", "Jungla", "Medio", "Adc", "Support"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(selectedId);
                    String respuestaSpinner = spinner.getSelectedItem().toString();
                    String respuestaCheckbox = checkBox1.isChecked() ? checkBox1.getText().toString() : checkBox2.getText().toString();
                    String resumen = respuestaCheckbox + "y juego de " + respuestaSpinner ;
                    Snackbar.make(view, resumen, Snackbar.LENGTH_LONG).show();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox2.setChecked(false);
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                }
            }
        });
    }
}