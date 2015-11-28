package cuigrupo8.duelodeleyendasapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio-Pc on 22/11/2015.
 */
public class Datos {

    private static final Datos instance = new Datos();
    private List<PersonajeAndroid> personajes = new ArrayList<>();
    private int id = 0;

    public Datos() {
       // this.agregarPersonaje(new PersonajeAndroid("Amumu","PoderHablidad","PoderDeAtaque","Jungle"));
        //this.agregarPersonaje(new PersonajeAndroid("Rengar","PoderAtaque","PoderDefensa","Mid"));
    }

    public static Datos getInstance() {
        return instance;
    }

    public PersonajeAndroid agregarPersonaje(PersonajeAndroid p) {
        PersonajeAndroid personaje = p;
        this.personajes.add(personaje);
        return personaje;
    }

    public List<PersonajeAndroid> buscarPorNombre(String nombre) {
        List<PersonajeAndroid> seleccionDePersonajes = new ArrayList<PersonajeAndroid>();
        for (PersonajeAndroid personaje : this.personajes) {
            if (contiene(personaje.getNombre(), nombre)) {
                seleccionDePersonajes.add(personaje);
            }
        }
        return seleccionDePersonajes;
    }

    public static boolean contiene(String uno, String otro) {
        return uno.toLowerCase().contains(otro.toLowerCase());
    }

    public List<PersonajeAndroid> todasLasInstancias() {
        return this.personajes;
    }
}

