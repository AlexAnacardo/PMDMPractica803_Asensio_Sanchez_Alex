package com.example.practica803_asensio_sanchez_alex;

import java.util.ArrayList;
import java.util.List;

public class ListadoUsuarios {

    public static List<Usuario> listadoUsuarios = new ArrayList<>();

    public static void añadirUsuario(Usuario usuario){
        listadoUsuarios.add(usuario);
    }

    public static List<Usuario> recogerUsuarios(){
        return listadoUsuarios;
    }
}
