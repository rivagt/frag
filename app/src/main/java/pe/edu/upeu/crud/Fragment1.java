package pe.edu.upeu.crud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import OpenHelper.DataBase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    private ListView lv;
    private ArrayList<Integer> codigos;
    private Cursor c;
    DataBase db = new DataBase(getContext());
    private ArrayList<String> total=new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment1() {
        // Required empty public constructor
    }
    @Override    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment1,container, false);

        lv=(ListView)view.findViewById(R.id.lv1);


        mostrarlista();



        return view;
    }
    public boolean mostrarlista(){
        ArrayList<String> lista = new ArrayList<String>();
        codigos=new ArrayList<>();
        db = new DataBase(getContext());
        c=db.cursor();
        if (c.moveToFirst()){
            do{
                lista.add("ID: "+c.getString(0)+ " Nombres: " + c.getString(1) +" Apellidos: "+c.getString(2)+ " Direccion: " + c.getString(3)+" Telefono: "+ c.getString(4));
                codigos.add(c.getInt(0));
            }while (c.moveToNext());

        }
        ArrayAdapter<String> adap = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                int cod = codigos.get(posicion);
                SQLiteDatabase bd = db.getReadableDatabase();
                c = bd.rawQuery("Select _id,nombres,apellidos,direccion,telefono from personas", null);
                if (c.moveToFirst()){
                    String _id = String.valueOf(c.getInt(0));
                    String nombres = c.getString(1);
                    String apellidos = c.getString(2);
                    String direccion = c.getString(3);
                    String telefono = c.getString(4);

                    Intent obj = new Intent(getContext(), MainActivity.class);

                    obj.putExtra("nombres",nombres);
                    obj.putExtra("apellidos", apellidos);
                    obj.putExtra("direccion", direccion);
                    obj.putExtra("telefono", telefono);
                    obj.putExtra("_id", _id);

                    startActivity(obj);
                }
                else{
                    Toast.makeText(getContext(), "NO EXISTE", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return true;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
