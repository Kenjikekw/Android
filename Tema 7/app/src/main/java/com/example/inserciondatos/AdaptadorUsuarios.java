package com.example.inserciondatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.HolderUsuario> {

    public static class HolderUsuario extends RecyclerView.ViewHolder
    {
        TextView lCodigo, lNombre, lFecha;
        HolderUsuario(View itemView)
        {
            super(itemView);
            lCodigo = itemView.findViewById(R.id.lCodigo);
            lNombre = itemView.findViewById(R.id.lNombre);
            lFecha = itemView.findViewById(R.id.lFecha);

        }
    };

    private ArrayList<Usuario> usuarios;
    private Context contexto;

    public AdaptadorUsuarios(Context contexto, ArrayList<Usuario> usuarios)
    {
        this.contexto = contexto;
        this.usuarios = usuarios;
    }

    public void add(ArrayList<Usuario> datos)
    {
        usuarios.clear();
        usuarios.addAll(datos);
    }

    public void refrescar()
    {
        notifyDataSetChanged();
    }

    @Override
    public HolderUsuario onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        HolderUsuario pvh = new HolderUsuario(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(HolderUsuario usuarioactual, int position)
    {
        usuarioactual.lCodigo.setText(String.valueOf(usuarios.get(position).getCodigo()));
        usuarioactual.lNombre.setText(usuarios.get(position).getNombre());
        usuarioactual.lFecha.setText((CharSequence) usuarios.get(position).getFecha());
    }

    @Override
    public int getItemCount()
    {
        return usuarios.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
