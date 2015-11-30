package cuigrupo8.duelodeleyendasapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio-Pc on 22/11/2015.
 */
public class PersonajeAndroid {

    public String nombre;
    public String especialidades;
    public String debilidades;
    public String mejorPosicion;
    public List<String> estadisticas;

    public PersonajeAndroid(String nombre, String especialidades, String debilidades, String mejorPosicion, List<String> estadisticas) {
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.debilidades = debilidades;
        this.mejorPosicion = mejorPosicion;
        this.estadisticas = estadisticas;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getEspecialidades() {
        return this.especialidades;
    }
    public String getDebilidades() {
        return this.debilidades;
    }
    public String getMejorPosicion() {
        return this.mejorPosicion;
    }

    public ArrayList<String> getEstadisticas() {
        ArrayList<String> e = new ArrayList<String>();
        e.addAll(this.estadisticas);
        return e;
    }
}