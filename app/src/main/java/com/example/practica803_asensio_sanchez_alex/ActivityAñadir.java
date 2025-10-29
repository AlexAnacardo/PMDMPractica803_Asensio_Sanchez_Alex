package com.example.practica803_asensio_sanchez_alex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAñadir extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_usuario);

        EditText nombre = findViewById(R.id.etNombre);
        EditText apellidos = findViewById(R.id.etApellidos);
        EditText edad = findViewById(R.id.etEdad);
        EditText dni = findViewById(R.id.etDni);
        EditText telefono = findViewById(R.id.etTelefono);
        Spinner spinnerProvincia = findViewById(R.id.spinnerProvincia);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_provincias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerProvincia.setAdapter(adapter);


        Button botonAceptar = findViewById(R.id.botonAceptar);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(telefono.length()!=9){
                    Toast.makeText(ActivityAñadir.this, "Telefono no valido", Toast.LENGTH_LONG).show();
                }
                else if(dni.length()!=9){
                    Toast.makeText(ActivityAñadir.this, "El DNI no tiene una longitud valida", Toast.LENGTH_LONG).show();
                }
                else if(validarDni(dni.getText().toString())){

                    String provinciaSeleccionada = spinnerProvincia.getSelectedItem().toString();

                    Usuario usuario = new Usuario(nombre.getText().toString(), apellidos.getText().toString(), Integer.parseInt(edad.getText().toString()), dni.getText().toString(), telefono.getText().toString(), provinciaSeleccionada, R.drawable.ic_usuario_default);

                    ListadoUsuarios.añadirUsuario(usuario);

                    Toast.makeText(ActivityAñadir.this, "Usuario añadido", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(ActivityAñadir.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ActivityAñadir.this, "La letra del DNI es incorrecta", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private boolean validarDni(String dni){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (!dni.matches("\\d{8}[A-Za-z]")) return false;

        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = Character.toUpperCase(dni.charAt(8));
        char letraCorrecta = letras.charAt(numero % 23);

        return letra == letraCorrecta;
    }
}
