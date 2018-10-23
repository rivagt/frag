package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import Entidad.Usuario;
import pe.edu.upeu.crud.R;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.PersonasHolder> {
    ArrayList<Usuario> listaUsuario;

    public ListaAdapter (ArrayList<Usuario> listaUsuario){
        this.listaUsuario = listaUsuario;
    }

    @Override
    public PersonasHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_personas, null, false);
        return new PersonasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonasHolder holder, int i) {
        holder.documento.setText(listaUsuario.get(i).getId().toString());
        holder.nombre.setText(listaUsuario.get(i).getNombre());
        holder.apellido.setText(listaUsuario.get(i).getApellido());
        holder.direccion.setText(listaUsuario.get(i).getDireccion());
        holder.telefono.setText(listaUsuario.get(i).getTelefono());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasHolder extends RecyclerView.ViewHolder{
        TextView documento,nombre,apellido,escuela,ciclo,direccion,telefono;

        public PersonasHolder(View itemView) {
            super(itemView);
            documento = (TextView) itemView.findViewById(R.id.textDocumento);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            apellido = (TextView) itemView.findViewById(R.id.textApellido);
            escuela = (TextView) itemView.findViewById(R.id.textEscuela);
            ciclo = (TextView) itemView.findViewById(R.id.textCiclo);
            direccion = (TextView) itemView.findViewById(R.id.textDireccion);
            telefono = (TextView) itemView.findViewById(R.id.textTelefono);
        }
    }
}
