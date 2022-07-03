package com.example.apprecycable;

import java.util.ArrayList;

public class Alumno {
    private int id;
    private String carrera;
    private String nombre;
    private int img;
    private String matricula;

    public Alumno(int id, String carrera, String nombre, int img, String matricula) {
        this.id = id;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
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

        alumnos.add(new Alumno(1, carrera, "PERAZA SÁINZ ÁNGEL ADRIÁN", R.drawable.a01, "2017030274"));
        alumnos.add(new Alumno(2, carrera, "GÓMEZ CAMARENA JOSÉ RICARDO", R.drawable.a02, "2017030432"));
        alumnos.add(new Alumno(3, carrera, "PEÑA SOLÍS DIEGO ARMANDO", R.drawable.a03, "2018030098"));
        alumnos.add(new Alumno(4, carrera, "GARCÍA SILVA ADRIÁN", R.drawable.a04, "2018030099"));
        alumnos.add(new Alumno(5, carrera, "GARCÍA RODRÍGUEZ JESÚS EFRAÍN", R.drawable.a05, "2018030103"));
        alumnos.add(new Alumno(6, carrera, "LIZÁRRAGA CAMACHO JESÚS ARMANDO", R.drawable.a06, "2018030108"));
        alumnos.add(new Alumno(7, carrera, "GARCÍA GÓMEZ JUAN ANTONIO", R.drawable.a07, "2018030119"));
        alumnos.add(new Alumno(8, carrera, "LIZÁRRAGA LUNA JUAN FRANCISCO", R.drawable.a08, "2018030121"));
        alumnos.add(new Alumno(9, carrera, "OSUNA HIGUERA ALEJANDRO", R.drawable.a09, "2018030133"));
        alumnos.add(new Alumno(10, carrera, "MARÍN GALINDO KIMBERLY VANESSA", R.drawable.a10, "2018030155"));

        return alumnos;
    }
}
