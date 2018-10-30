package pe.edu.upeu.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.DataBase;
import OpenHelper.Utils;

public class Operaciones extends AppCompatActivity {
    private EditText id, idnomb, idnom, idape, iddir, idtel;
    DataBase conn;
    DataBase a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        id=(EditText) findViewById(R.id._id);
        idnomb=(EditText) findViewById(R.id.idnomb);
        idnom=(EditText) findViewById(R.id.idnom);
        idape=(EditText) findViewById(R.id.idape);
        iddir=(EditText) findViewById(R.id.iddir);
        idtel=(EditText) findViewById(R.id.idtel);
    }
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.Buscar:
                consultarSql();
                break;
            case R.id.actualizar: actualizarUsuario();
                break;
            case R.id.eliminar: eliminarUsuario();
                break;
        }

    }
    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={id.getText().toString()};

        db.delete(Utils.TABLA_USUARIO,Utils.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario", Toast.LENGTH_LONG).show();
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={id.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utils.CAMPO_NOMBRE,idnom.getText().toString());
        values.put(Utils.CAMPO_APELLIDO,idape.getText().toString());
        values.put(Utils.CAMPO_DIRECCION,iddir.getText().toString());
        values.put(Utils.CAMPO_TELEFONO,idtel.getText().toString());

        db.update(Utils.TABLA_USUARIO,values,Utils.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario", Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultarSql() {
        Toast.makeText(getApplicationContext(), "zxc", Toast.LENGTH_SHORT).show();
     /*   SQLiteDatabase db = a.getReadableDatabase();
        String[] parametros = {idnomb.getText().toString()};*/
        SQLiteDatabase x=a.getReadableDatabase();
        String[] parametros = {idnomb.getText().toString()};
        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor s=x.rawQuery("SELECT "+ Utils.CAMPO_NOMBRE+","+Utils.CAMPO_APELLIDO+","+Utils.CAMPO_ID+","+Utils.CAMPO_DIRECCION+","+Utils.CAMPO_TELEFONO+
                    " FROM "+Utils.TABLA_USUARIO+" WHERE "+Utils.CAMPO_ID+"=? ",parametros);

            s.moveToFirst();
            idnom.setText(s.getString(0));
            idape.setText(s.getString(1));
            id.setText(s.getString(2));
            iddir.setText(s.getString(3));
            idtel.setText(s.getString(4));


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }
   private void limpiar() {
        idnom.setText("");
        idape.setText("");
        iddir.setText("");
        idtel.setText("");
        idnomb.setText("");
       id.setText("");
    }
}
