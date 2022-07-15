package com.example.apprecycable;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import modelo.AlumnosDb;

public class AlumnoAlta extends AppCompatActivity {
    private Button btnGuardar, btnRegresar, btnImagen, btnBorrar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private TextView lblImagen, txtId;
    private String carrera = "Ing. Tec. Información";
    private int posicion;
    private AlumnosDb alumnosDb;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_alta);
        alumnosDb = new AlumnosDb(getApplicationContext());

        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnImagen = (Button) findViewById(R.id.btnImagen);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtGrado = (EditText) findViewById(R.id.txtGrado);
        imgAlumno = (ImageView) findViewById(R.id.imgAlumno);
        lblImagen = (TextView) findViewById(R.id.lblFoto);

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if (posicion >= 0) {
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getGrado());
            imgAlumno.setImageURI(Uri.parse(alumno.getImg()));
            lblImagen.setText(alumno.getImg());
        }

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subirImagen();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alumno == null || posicion == -1) {
                    alumno = new Alumno();
                    alumno.setGrado(txtGrado.getText().toString());
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImg(lblImagen.getText().toString());

                    if (validar()){
                        alumnosDb.insertAlumno(alumno);
                        Aplicacion.alumnos.add(alumno);
                        setResult(Activity.RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Faltó capturar datos.", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();
                    }
                }

                if (posicion >= 0){
                    if(validar()){
                        alumno.setMatricula(txtMatricula.getText().toString());
                        alumno.setNombre(txtNombre.getText().toString());
                        alumno.setGrado(txtGrado.getText().toString());
                        alumno.setImg(lblImagen.getText().toString());
                        alumnosDb.updateAlumno(alumno);

                        Aplicacion.alumnos.get(posicion).setMatricula(alumno.getMatricula());
                        Aplicacion.alumnos.get(posicion).setNombre(alumno.getNombre());
                        Aplicacion.alumnos.get(posicion).setGrado(alumno.getGrado());
                        Aplicacion.alumnos.get(posicion).setImg(alumno.getImg());

                        Toast.makeText(getApplicationContext(), "Se modificó con éxito.", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Faltó capturar datos.", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();
                    }
                }

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(AlumnoAlta.this);
                confirmar.setTitle("Borrar");
                confirmar.setMessage("¿Seguro que quiere borrar este registro?");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (posicion >= 0) {
                            Aplicacion.alumnos.remove(posicion);
                            alumnosDb.deleteAlumno(alumno.getId());
                            finish();
                        }
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                if (posicion >= 0 ){
                    confirmar.show();
                } else {
                    Toast.makeText(AlumnoAlta.this, "Aún no se añade ningún elemento.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validar(){
        boolean exito = true;
        Log.d("nombre", "validar: " + txtNombre.getText());
        if (txtNombre.getText().toString().equals("")) exito = false;
        if (txtMatricula.getText().toString().equals("")) exito = false;
        if (txtGrado.getText().toString().equals("")) exito = false;
        if (lblImagen.getText().toString().equals("URL foto")) exito = false;

        return exito;
    }

    private void subirImagen(){
        Intent intento = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intento.setType("image/");
        startActivityForResult(intento.createChooser(intento, "Seleccionar imagen"), 200);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 200) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    imgAlumno.setImageURI(selectedImageUri);
                    lblImagen.setText(selectedImageUri.toString());
                }
            }
        }
    }
}
