package com.example.activityadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Producto {
    String nombre;
    String descripcion;
    int imagenResourceId; // Referencia a un recurso de imagen en res/drawable

    public Producto(String nombre, String descripcion, int imagenResourceId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResourceId = imagenResourceId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenResourceId(int imagenResourceId) {
        this.imagenResourceId = imagenResourceId;
    }
}