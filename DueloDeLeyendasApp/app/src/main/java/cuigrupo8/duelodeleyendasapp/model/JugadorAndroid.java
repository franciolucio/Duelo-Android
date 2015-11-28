package cuigrupo8.duelodeleyendasapp.model;

/**
 * Created by Lucio-Pc on 25/11/2015.
 */
public class JugadorAndroid {

    public String nombre;
    public String password;

    public JugadorAndroid  (String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public JugadorAndroid() {
    }

    public String getNombre() {
        return nombre;
    }
}
