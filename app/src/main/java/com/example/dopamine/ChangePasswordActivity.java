package com.example.dopamine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ChangePasswordActivity extends AppCompatActivity {

    // MOCK password attuale dal database
    private static final String PASSWORD_DAL_DB = "Password1!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputEditText inputPasswordAttuale = findViewById(R.id.password1);
        TextInputEditText inputNuovaPassword   = findViewById(R.id.newPassword);
        TextInputEditText inputConferma        = findViewById(R.id.confermaPassword);

        Button btnIndietro = findViewById(R.id.indietroButton);
        Button btnConferma = findViewById(R.id.confermaChanges);

        btnIndietro.setOnClickListener(v -> {
           finish();
        });

        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwordAttuale = inputPasswordAttuale.getText().toString();
                String nuovaPassword   = inputNuovaPassword.getText().toString();
                String conferma        = inputConferma.getText().toString();

                // 1. Verifica password attuale (mock DB)
                if (!passwordAttuale.equals(PASSWORD_DAL_DB)) {
                    Toast.makeText(ChangePasswordActivity.this,
                            "❌ Password attuale errata", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 2. Verifica requisiti nuova password
                if (!isPasswordValida(nuovaPassword)) {
                    Toast.makeText(ChangePasswordActivity.this,
                            "❌ La password deve avere almeno 8 caratteri, una maiuscola, un numero e un carattere speciale",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // 3. Verifica che le due nuove password coincidano
                if (!nuovaPassword.equals(conferma)) {
                    Toast.makeText(ChangePasswordActivity.this,
                            "❌ Le password non coincidono", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tutto ok
                Toast.makeText(ChangePasswordActivity.this,
                        "✅ Password cambiata con successo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean isPasswordValida(String password) {
        if (password.length() < 8) return false;

        boolean haMaiuscola         = false;
        boolean haNumero            = false;
        boolean haCarattereSpeciale = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) haMaiuscola = true;
            if (Character.isDigit(c))     haNumero = true;
            if ("!@#$%^&*()_+-=[]{}|;':,./<>?".indexOf(c) >= 0) haCarattereSpeciale = true;
        }

        return haMaiuscola && haNumero && haCarattereSpeciale;
    }
}



//CHANGE PASSWORD