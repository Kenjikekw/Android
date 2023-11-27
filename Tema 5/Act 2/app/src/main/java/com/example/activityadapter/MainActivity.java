package com.example.activityadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar productos...
        productos = new ArrayList<>();
        productos.add(new Producto("Producto 1", "Descripción 1", R.drawable.imagen1));
        productos.add(new Producto("Producto 2", "Descripción 2", R.drawable.imagen2));
        // ...

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar y configurar adaptador
        adapter = new ProductoAdapter(productos);
        recyclerView.setAdapter(adapter);
    }
}