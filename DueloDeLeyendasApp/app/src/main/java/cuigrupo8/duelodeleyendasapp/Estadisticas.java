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

        TextView tv1 = (TextView) findViewById(R.id.jugados);
        tv1.setText(estadisticas.get(0));

        TextView tv2 = (TextView) findViewById(R.id.ganados);
        tv2.setText(estadisticas.get(1));

        TextView tv3 = (TextView) findViewById(R.id.kills);
        tv3.setText(estadisticas.get(2));

        TextView tv4 = (TextView) findViewById(R.id.deads);
        tv4.setText(estadisticas.get(3));

        TextView tv5 = (TextView) findViewById(R.id.assists);
        tv5.setText(estadisticas.get(4));

        TextView tv6 = (TextView) findViewById(R.id.mejorPosicion2);
        tv6.setText(estadisticas.get(5));

        TextView tv7 = (TextView) findViewById(R.id.puntaje);
        tv7.setText(estadisticas.get(6));
    }
}
