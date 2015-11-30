package cuigrupo8.duelodeleyendasapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Estadisticas extends AppCompatActivity {

    public ArrayList<String> estadisticas;
    public String nombreDePersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        Intent intent = getIntent();
        this.estadisticas = intent.getStringArrayListExtra("estadisticas");
        this.nombreDePersonaje = intent.getStringExtra("nombreDePersonaje");
        setTitle(nombreDePersonaje);
        cambiarInformacionTextView(estadisticas.get(0), R.id.jugados);
        cambiarInformacionTextView(estadisticas.get(1),R.id.ganados);
        cambiarInformacionTextView(estadisticas.get(2),R.id.kills);
        cambiarInformacionTextView(estadisticas.get(3),R.id.deads);
        cambiarInformacionTextView(estadisticas.get(4),R.id.assists);
        cambiarInformacionTextView(estadisticas.get(5),R.id.mejorPosicion2);
        cambiarInformacionTextView(estadisticas.get(6),R.id.puntaje);
    }

    private void cambiarInformacionTextView(String s, int x) {
        TextView tv = (TextView) findViewById(x);
        tv.setText(s);
    }
}
