package cuigrupo8.duelodeleyendasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.JugadorAndroid;
import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;
import cuigrupo8.duelodeleyendasapp.service.DueloService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class logueo extends AppCompatActivity {

    List<JugadorAndroid> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
    }

    public void ingresar(final View view){
        DueloService dueloService = createDueloService();
        dueloService.getJugadoresAndroid(new Callback<List<JugadorAndroid>>() {
            @Override
            public void success(List<JugadorAndroid> jugadoresAndroid, Response response) {
                String username = ((EditText) findViewById(R.id.usuario)).getText().toString();
                verificarSiEstaEnElSistema(view,jugadoresAndroid, username);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void verificarSiEstaEnElSistema(View view,List<JugadorAndroid> jugadoresAndroid, String username) {
        for (JugadorAndroid j : jugadoresAndroid) {
            //if (j.getNombre() == username) {
               pasar(view);
            //}
        }
    }

    private DueloService createDueloService() {
        //String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.1.100";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://" + SERVER_IP_GENY + ":8000";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        DueloService dueloService = restAdapter.create(DueloService.class);
        return dueloService;
    }

    private void pasar(View view) {
        Intent siguiente = new Intent(this, SeleccionarPersonaje.class);
        startActivity(siguiente);
    }
}
