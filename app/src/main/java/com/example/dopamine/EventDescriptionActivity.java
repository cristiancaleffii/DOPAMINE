package com.example.dopamine;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EventDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_description);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton buttonFavorite = findViewById(R.id.buttonFavorite2);
        final boolean[] isFavorite = {false};

        buttonFavorite.setOnClickListener(v -> {
           isFavorite[0] = !isFavorite[0];

           if (isFavorite[0]) {
               buttonFavorite.setImageResource(R.drawable.filled_heart);

           } else {
               buttonFavorite.setImageResource(R.drawable.empty_heart);
           }
        });

        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
           finish();
        });
    }
}