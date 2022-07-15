package com.example.apprecycable;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
    private int id;
    private String carrera;
    private String nombre;
    private String img;
    private String matricula;

    public Alumno(String carrera, String nombre, String img, String matricula) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.img = img;
        this.matricula = matricula;
    }

    public Alumno(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrado() {
        return carrera;
    }

    public void setGrado(String grado) {
        this.carrera = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static ArrayList<Alumno> llenarAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String carrera = "Ing. Tec. Información";

        alumnos.add(new Alumno(carrera, "PERAZA SÁINZ ÁNGEL ADRIÁN", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a01").toString(), "2017030274"));
        alumnos.add(new Alumno(carrera, "GÓMEZ CAMARENA JOSÉ RICARDO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a02").toString(), "2017030432"));
        alumnos.add(new Alumno(carrera, "PEÑA SOLÍS DIEGO ARMANDO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a03").toString(), "2018030098"));
        alumnos.add(new Alumno(carrera, "GARCÍA SILVA ADRIÁN", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a04").toString(), "2018030099"));
        alumnos.add(new Alumno(carrera, "GARCÍA RODRÍGUEZ JESÚS EFRAÍN", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a05").toString(), "2018030103"));
        alumnos.add(new Alumno(carrera, "LIZÁRRAGA CAMACHO JESÚS ARMANDO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a06").toString(), "2018030108"));
        alumnos.add(new Alumno(carrera, "GARCÍA GÓMEZ JUAN ANTONIO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a07").toString(), "2018030119"));
        alumnos.add(new Alumno(carrera, "LIZÁRRAGA LUNA JUAN FRANCISCO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a08").toString(), "2018030121"));
        alumnos.add(new Alumno(carrera, "OSUNA HIGUERA ALEJANDRO", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a09").toString(), "2018030133"));
        alumnos.add(new Alumno(carrera, "MARÍN GALINDO KIMBERLY VANESSA", Uri.parse("android.resource://com.example.apprecyclable/drawable/R.drawable.a10").toString(), "2018030155"));

        return alumnos;
    }
}
