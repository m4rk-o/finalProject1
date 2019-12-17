package com.example.finalproject1.Fragments;


import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.finalproject1.R;
import com.example.finalproject1.models.Table;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fixtures extends Fragment {


    public Fixtures() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myfixture = inflater.inflate(R.layout.fragment_fixtures, container, false);

        Table tabla = new Table(getActivity(), (TableLayout) myfixture.findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_tabla);
        for(int i = 0; i < 8; i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(Integer.toString(i));
            elementos.add("[" + i + ", 0]");
            elementos.add("[" + i + ", 1]");
            elementos.add("[" + i + ", 2]");
            elementos.add("[" + i + ", 3]");
            elementos.add("[" + i + ", 4]");
            elementos.add("[" + i + ", 5]");
            elementos.add("[" + i + ", 6]");
            elementos.add("[" + i + ", 7]");
            elementos.add("[" + i + ", 8]");
            tabla.agregarFilaTabla(elementos);
        }

        return myfixture;
    }

}
