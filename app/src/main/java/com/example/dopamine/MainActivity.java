package com.example.dopamine;

import android.os.Bundle;
import android.view.MenuItem; // AGGIUNTO

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// AGGIUNTO per la navigazione
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- CODICE PER IL NOME DINAMICO ---

        // 1. Trova la barra di navigazione
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);

        // 2. Stringa del nome (che prenderai dal Login)
        String nomeUtenteLoggato = "NomeDinamico";

        // 3. Cambia il titolo dell'elemento con id "nav_profile"
        if (bottomNav != null) {
            MenuItem profileItem = bottomNav.getMenu().findItem(R.id.nav_profile);
            if (profileItem != null) {
                profileItem.setTitle(nomeUtenteLoggato);
            }
        }
    }
}