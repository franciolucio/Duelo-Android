package cuigrupo8.duelodeleyendasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.JugadorAndroid;
import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;
import cuigrupo8.duelodeleyendasapp.service.DueloService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class logueo extends AppCompatActivity {

    String usuario;
    String s = "Emiliano";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
    }

    public void ingresar(View view) {
        Intent siguiente = new Intent(this, SeleccionarPersonaje.class);
        startActivity(siguiente);
    }
}
