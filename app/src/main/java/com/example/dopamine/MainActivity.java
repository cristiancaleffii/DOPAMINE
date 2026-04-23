package com.example.dopamine;

import android.os.Bundle;
import android.view.MenuItem; // AGGIUNTO

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

// AGGIUNTO per la navigazione
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Adapter
        viewPager.setAdapter(new TabPagerAdapter(this));
        viewPager.setUserInputEnabled(false);

        final String[] tabTitles = {"Home", "Ricerca", "Preferiti", "Gioco", "Profilo"};
        int[] tabIcons = {R.drawable.ic_home, R.drawable.ic_search, R.drawable.ic_star, R.drawable.ic_game, R.drawable.ic_profile};

        // Connect tabs with ViewPager 2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setText(tabTitles[position]);
                    tab.setIcon(tabIcons[position]);
                }).attach();

        // --- CODICE PER IL NOME DINAMICO ---

        // 1. Trova la barra di navigazione

        // 2. Stringa del nome (che prenderai dal Login)
        /*String nomeUtenteLoggato = "NomeDinamico";

        // 3. Cambia il titolo dell'elemento con id "nav_profile"
        if (tabLayout != null) {
            MenuItem profileItem = tabLayout.getMenu().findItem(R.id.nav_profile);
            if (profileItem != null) {
                profileItem.setTitle(nomeUtenteLoggato);
            }
        }*/
    }
}