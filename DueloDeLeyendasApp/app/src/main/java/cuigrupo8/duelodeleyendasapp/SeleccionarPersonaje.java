package cuigrupo8.duelodeleyendasapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;
import cuigrupo8.duelodeleyendasapp.service.DueloService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SeleccionarPersonaje extends AppCompatActivity {

    public List<PersonajeAndroid> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_personaje);
        obtenerPersonajesAndroid();
    }

    private void obtenerPersonajesAndroid() {
        DueloService dueloService = createDueloService();
        dueloService.getPersonajesAndroid(new Callback<List<PersonajeAndroid>>() {
            @Override
            public void success(List<PersonajeAndroid> personajesAndroid, Response response) {
                personajes = personajesAndroid;
                agregarPersonajeAndroid(personajesAndroid);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void agregarPersonajeAndroid(List<PersonajeAndroid> personajeAndroid) {
        ListView lw = ((ListView) findViewById(R.id.listaDePersonajes));
        lw.setAdapter(new PersonajeAdapter(this, personajeAndroid));
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                informacionPersonaje(arg1, personajes.get(position));
            }
        });
    }

    //Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();

    private void informacionPersonaje(View view,PersonajeAndroid personajeAndroid) {
        Intent siguiente = new Intent(this,Personaje.class);
        siguiente.putExtra("especialidades", personajeAndroid.getEspecialidades());
        siguiente.putExtra("debilidades", personajeAndroid.getDebilidades());
        siguiente.putExtra("mejorPosicion", personajeAndroid.getMejorPosicion());
        siguiente.putExtra("nombreDePersonaje", personajeAndroid.getNombre());
        siguiente.putStringArrayListExtra("estadisticas", personajeAndroid.getEstadisticas());
        startActivity(siguiente);
    }
    private DueloService createDueloService() {
        //String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.1.7";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://"+ SERVER_IP_GENY +":8000";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        DueloService dueloService = restAdapter.create(DueloService.class);
        return dueloService;
    }
}