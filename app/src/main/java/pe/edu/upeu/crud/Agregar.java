package pe.edu.upeu.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.DataBase;
import OpenHelper.Utils;

public class Agregar extends AppCompatActivity {
private EditText nom, ape, dir, tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        nom=(EditText) findViewById(R.id.inom);
        ape=(EditText) findViewById(R.id.iape);
        dir=(EditText) findViewById(R.id.idir);
        tel=(EditText) findViewById(R.id.itel);
    }
    public void onClick(View view) {
        registrar();
        //registrarUsuariosSql();
    }
    private void registrar() {
        DataBase conn=new DataBase(this);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utils.CAMPO_NOMBRE,nom.getText().toString());
        values.put(Utils.CAMPO_APELLIDO,ape.getText().toString());
        values.put(Utils.CAMPO_DIRECCION,dir.getText().toString());
        values.put(Utils.CAMPO_TELEFONO,tel.getText().toString());

        Long idResultante=db.insert(Utils.TABLA_USUARIO,Utils.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
