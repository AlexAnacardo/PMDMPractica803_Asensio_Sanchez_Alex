package com.example.practica803_asensio_sanchez_alex;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private String telefono;
    private String provincia;
    private int fotoResId;

    public Usuario(String nombre, String apellidos, int edad, String dni, String telefono, String provincia, int fotoResId) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
        this.provincia = provincia;
        this.fotoResId = fotoResId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getFotoResId() {
        return fotoResId;
    }

    public void setFotoResId(int fotoResId) {
        this.fotoResId = fotoResId;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" Apellidos: "+apellidos+"\nEdad: "+edad+" DNI: "+dni+"\nTelefono: "+telefono+"Provincia: "+provincia;
    }
}
