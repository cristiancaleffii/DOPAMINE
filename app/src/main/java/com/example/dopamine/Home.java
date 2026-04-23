package com.example.dopamine;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.card.MaterialCardView;

public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 1. Colleghi le view
        MaterialCardView cardNovita = view.findViewById(R.id.cardNovita);
        MaterialCardView cardTopValutazioni = view.findViewById(R.id.cardTopValutazioni);
        MaterialCardView cardRandom = view.findViewById(R.id.cardRandom);

        // 2. Colleghi i click
        cardNovita.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NovitaActivity.class);
            startActivity(intent);
        });

        cardTopValutazioni.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TopValutazioniActivity.class);
            startActivity(intent);
        });

        cardRandom.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RandomActivity.class);
            startActivity(intent);
        });

        return view;
    }
}