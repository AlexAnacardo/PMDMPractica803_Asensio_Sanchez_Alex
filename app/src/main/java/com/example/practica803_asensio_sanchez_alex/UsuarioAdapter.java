package com.example.practica803_asensio_sanchez_alex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import androidx.recyclerview.widget.RecyclerView;

import com.example.practica803_asensio_sanchez_alex.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuarios;

    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvDatos;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvDatos = itemView.findViewById(R.id.tvDatosUsuario);
        }
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        View inflate = from.inflate(R.layout.layout_usuario, parent, false);
        return new UsuarioViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.tvDatos.setText(usuario.toString());
        holder.imgFoto.setImageResource(usuario.getFotoResId());

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.usuarioPar));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.usuarioImpar));
        }
    }


    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }


}
