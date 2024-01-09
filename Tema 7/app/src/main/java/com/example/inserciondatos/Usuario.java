package com.example.inserciondatos;

import java.sql.Date;

public class Usuario {
    private int codigo;
    private String nombre;

    private Date fecha;

    public Usuario(int codigo, String nombre, Date fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha(){return fecha;}

    public void setFecha(Date fecha){this.fecha = fecha;}

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                "fecha=" + fecha +
                '}';
    }
}
