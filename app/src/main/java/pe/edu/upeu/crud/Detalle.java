package pe.edu.upeu.crud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    private TextView uno,dos,tres,cuatro,cinco;
    private String nombres, apellidos, direccion, telefono, _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);
        uno=(TextView)findViewById(R.id._id);
        dos=(TextView)findViewById(R.id.nombres);
        tres=(TextView)findViewById(R.id.apellidos);
        cuatro=(TextView)findViewById(R.id.direccion);
        cinco=(TextView)findViewById(R.id.telefono);

        _id=getIntent().getStringExtra("_id");
        nombres=getIntent().getStringExtra("nombres");
        apellidos=getIntent().getStringExtra("apellidos");
        direccion=getIntent().getStringExtra("direccion");
        telefono=getIntent().getStringExtra("telefono");

        uno.setText("_id"+_id);
        dos.setText("nombres"+nombres);
        tres.setText("apellidos"+apellidos);
        cuatro.setText("direccion"+direccion);
        cinco.setText("telefono"+telefono);

    }
}
