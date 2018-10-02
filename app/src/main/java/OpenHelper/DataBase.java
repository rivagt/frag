package OpenHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
    private static final String DB_NAME = "dbfragment";
    private static final String tabla1 = "personas";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase datos;

    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table personas(_id integer primary key autoincrement, nombres text, apellidos text, direccion text, telefono text)");
        db.execSQL("insert into personas(nombres,apellidos,direccion,telefono) values('Adiel','Preciado','Ñaña','987654321')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
  /*  public static class Personas{
        public static final String TABLE = "personas";
        public static final String _ID = "_id";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String DIRECCION = "direccion";
        public static final String TELEFONO = "telefono";
        public static final String[] COLUMNAS = new String[] {_ID, NOMBRES, APELLIDOS, DIRECCION, TELEFONO};
    }*/
  public Cursor cursor(){
      String[] columnas={"_id","nombres","apellidos","direccion","telefono"};

      Cursor c=this.getReadableDatabase().query(tabla1, columnas, null, null, null, null, null);
      return c;
  }
  public Cursor buscardatos(int id){
      Cursor fila = datos.rawQuery("Select _id, nombres, apellidos, direccion, telefono from personas", null);
      return fila;
  }
}
