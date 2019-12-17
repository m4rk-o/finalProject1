package com.example.finalproject1.Fragments;


import android.app.Activity;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.finalproject1.ActivityComunication;
import com.example.finalproject1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    private final int[] BOTONESMENU={R.id.btn_teams, R.id.btn_fixture};

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        LinearLayout botonMenu;

        for (int i = 0;i < BOTONESMENU.length; i++){
            botonMenu = (LinearLayout) miMenu.findViewById(BOTONESMENU[i]);

            final int queBoton = i;
            botonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Activity thisActivity = getActivity();
                    ((ActivityComunication)thisActivity).onListItemSelected(queBoton);
                }
            });
        }

        return miMenu;
    }

}
