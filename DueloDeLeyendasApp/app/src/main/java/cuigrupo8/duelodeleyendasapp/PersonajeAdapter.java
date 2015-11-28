package cuigrupo8.duelodeleyendasapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cuigrupo8.duelodeleyendasapp.model.PersonajeAndroid;

/**
 * Created by Lucio-Pc on 25/11/2015.
 */
public class PersonajeAdapter extends AbstractListAdapter<PersonajeAndroid> {

    public PersonajeAdapter(Context context, List<PersonajeAndroid> personajesAndroid) {
        super(context, personajesAndroid);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonajeAndroid personajeAndroid = (PersonajeAndroid) getItem(position);
        View row = generateRow(R.layout.activity_personaje_android_row, parent);
        setColumnTextView(row, R.id.txtNombrePersonaje, personajeAndroid.getNombre());
        return row;
    }
}
