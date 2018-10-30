package OpenHelper;

public class Utils {
    public static final String TABLA_USUARIO="personas";
    public static final String CAMPO_ID="_id";
    public static final String CAMPO_NOMBRE="nombres";
    public static final String CAMPO_APELLIDO="apellidos";
    public static final String CAMPO_DIRECCION="direccion";
    public static final String CAMPO_TELEFONO="telefono";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT,"+CAMPO_DIRECCION+" TEXT,"+CAMPO_TELEFONO+" TEXT)";
}
