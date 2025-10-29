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

    private final Context context;
    private final List<Usuario> listaUsuarios;

    public UsuarioAdapter(Context context, List<Usuario> listaUsuarios) {
        this.context = context;
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.layout_usuario, parent, false);
        return new UsuarioViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.tvDatos.setText(usuario.toString());
        holder.imgFoto.setImageResource(usuario.getFotoResId());

        // Alternar colores usando colores definidos en colors.xml
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.usuarioPar));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.usuarioImpar));
        }
    }


    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvDatos;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvDatos = itemView.findViewById(R.id.tvDatosUsuario);
        }
    }
}
