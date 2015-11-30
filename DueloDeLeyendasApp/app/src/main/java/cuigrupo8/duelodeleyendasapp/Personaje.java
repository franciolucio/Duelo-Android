package cuigrupo8.duelodeleyendasapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;

public class Personaje extends AppCompatActivity {

    public String especialidades;
    public String debilidades;
    public String mejorPosicion;
    public ArrayList<String> estadisticas;
    private String nombreDePersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);
        Intent intent = getIntent();
        this.nombreDePersonaje = intent.getStringExtra("nombreDePersonaje");
        this.especialidades = intent.getStringExtra("especialidades");
        this.debilidades = intent.getStringExtra("debilidades");
        this.mejorPosicion = intent.getStringExtra("mejorPosicion");
        this.estadisticas = intent.getStringArrayListExtra("estadisticas");
        setTitle(nombreDePersonaje);
        cambiarInformacionTextView(especialidades, R.id.especialidades);
        cambiarInformacionTextView(debilidades, R.id.debilidades);
        cambiarInformacionTextView(mejorPosicion, R.id.mejorPosicion);
        cambiarInformacionImageView(nombreDePersonaje, R.id.imagen);
    }


    private void cambiarInformacionTextView(String s, int x) {
        TextView tv = (TextView) findViewById(x);
        tv.setText(s);
    }

    private void cambiarInformacionImageView(String s, int x) {
        int idDeImagen = getResources().getIdentifier((s).toLowerCase(), "drawable", this.getPackageName());
        ImageView iv= (ImageView) findViewById(x);
        iv.setImageResource(idDeImagen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                pasarAEstadisticas();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void pasarAEstadisticas() {
        Intent siguiente = new Intent(this,Estadisticas.class);
        siguiente.putStringArrayListExtra("estadisticas", estadisticas);
        siguiente.putExtra("nombreDePersonaje", nombreDePersonaje);
        startActivity(siguiente);
    }
}
