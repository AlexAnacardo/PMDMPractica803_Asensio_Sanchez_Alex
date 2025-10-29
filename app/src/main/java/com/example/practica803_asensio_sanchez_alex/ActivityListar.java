package com.example.practica803_asensio_sanchez_alex;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityListar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listar_usuarios);

        RecyclerView recyclerUsuarios = findViewById(R.id.recyclerUsuarios);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);

        recyclerUsuarios.setAdapter(adapter);
    }
}
