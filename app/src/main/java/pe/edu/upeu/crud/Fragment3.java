package pe.edu.upeu.crud;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import Entidad.Usuario;
import OpenHelper.DataBase;
import adapter.ListaAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerViewUsuarios;
    private Cursor c;
    DataBase conn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment3,container, false);
        listaUsuario = new ArrayList<>();

        recyclerViewUsuarios=(RecyclerView)view.findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        consultarLista();
        ListaAdapter adap = new ListaAdapter(listaUsuario);
        recyclerViewUsuarios.setAdapter(adap);
        return view;

    }
    public void consultarLista() {
        Toast.makeText(getContext(), "sadas", Toast.LENGTH_SHORT).show();
        ArrayList<String> lista = new ArrayList<String>();
        Usuario usuario = null;
        conn = new DataBase(getContext());
        c = conn.cursor();
        while (c.moveToNext()) {
            usuario = new Usuario();
            usuario.setId(c.getInt(0));
            usuario.setNombre(c.getString(1));
            usuario.setApellido(c.getString(2));
            usuario.setDireccion(c.getString(3));
            usuario.setTelefono(c.getString(4));
            listaUsuario.add(usuario);

        }
        Toast.makeText(getContext(),listaUsuario.get(0).getNombre(),Toast.LENGTH_SHORT).show();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
