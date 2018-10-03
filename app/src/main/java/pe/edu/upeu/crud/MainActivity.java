    package pe.edu.upeu.crud;

    import android.net.Uri;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

        public class MainActivity extends AppCompatActivity implements  Fragment1.OnFragmentInteractionListener , Fragment2.OnFragmentInteractionListener, Fragment3.OnFragmentInteractionListener, View.OnClickListener {
        private TextView uno,dos,tres,cuatro,cinco;
        private String nombres, apellidos, direccion, telefono, _id;
        Button b1, b2, b3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Fragment1 f1 = new Fragment1();
            getSupportFragmentManager().beginTransaction().add(R.id.container, f1).commit();


            b1 = (Button) findViewById(R.id.btf1);
            b2 = (Button) findViewById(R.id.btf2);
            b3 = (Button) findViewById(R.id.btf3);

            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);
           /* uno=(TextView)findViewById(R.id._id);
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
            cinco.setText("telefono"+telefono);*/

        }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btf1:
                    Fragment1 f1 = new Fragment1();
                    FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                    trans.replace(R.id.container, f1);
                    trans.commit();
                    break;

                case R.id.btf2:
                    Fragment2 f2 = new Fragment2();
                    FragmentTransaction trans2 = getSupportFragmentManager().beginTransaction();
                    trans2.replace(R.id.container, f2);
                    trans2.commit();
                    break;
                case R.id.btf3:
                    Fragment3 fr3 = new Fragment3();
                    FragmentTransaction trans3 = getSupportFragmentManager().beginTransaction();
                    trans3.replace(R.id.container, fr3);
                    trans3.commit();
                    break;
            }
        }
    }
