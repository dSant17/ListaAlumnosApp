package com.example.apprecycable;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

import modelo.AlumnoDbHelper;
import modelo.AlumnosDb;

public class Aplicacion extends Application {
    public static ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;
    private AlumnosDb alumnosDb;

    public static ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }

    public MiAdaptador getAdaptador(){
        return adaptador;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        alumnosDb = new AlumnosDb(getApplicationContext());
        alumnos = alumnosDb.allAlumnos();
        // alumnos = Alumno.llenarAlumnos();
        adaptador = new MiAdaptador(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());
    }
}
