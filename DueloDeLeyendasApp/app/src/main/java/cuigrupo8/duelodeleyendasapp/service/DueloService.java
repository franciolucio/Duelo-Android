package cuigrupo8.duelodeleyendasapp.service;

import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.JugadorAndroid;
import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;
import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by Lucio-Pc on 25/11/2015.
 */
public interface DueloService {
    @GET("/jugadoresAndroid")
    void getJugadoresAndroid(Callback<List<JugadorAndroid>> callback);

    @GET("/personajesAndroid")
    void getPersonajesAndroid(Callback<List<PersonajeAndroid>> callback);
}