
package com.androidwithshiv.crudyalgomas;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import android.widget.ImageView;
import android.content.Intent;  // Importación necesaria
import android.net.Uri;  // Importación necesaria

import com.androidwithshiv.crudoperation.R;


public class SecondActivity extends AppCompatActivity {

    private int numeroAdivinado;
    private EditText numeroEditText;
    private Button adivinarButton;
    private TextView resultTextView;

    private ImageView felicitacionesImageView; // Declarar la ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        numeroAdivinado = generarNumeroAleatorio();

        numeroEditText = findViewById(R.id.numeroEditText);
        adivinarButton = findViewById(R.id.adivinarButton);
        resultTextView = findViewById(R.id.resultTextView);

        adivinarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén la suposición del usuario
                String suposicionStr = numeroEditText.getText().toString();

                if (!suposicionStr.isEmpty()) {
                    int suposicion = Integer.parseInt(suposicionStr);

                    // Compara la suposición con el número adivinado
                    if (suposicion == numeroAdivinado) {
                        resultTextView.setText("¡Correcto! Has adivinado el número.");
                        ImageView felicitacionesImageView = findViewById(R.id.felicitacionesImageView);
                        felicitacionesImageView.setVisibility(View.VISIBLE);
                    } else if (suposicion < numeroAdivinado) {
                        resultTextView.setText("Intenta con un número más grande.");
                    } else {
                        resultTextView.setText("Intenta con un número más pequeño.");
                    }
                }
            }
        });

        // Configurar el botón Virginio Gómez
        Button virginioGomezButton = findViewById(R.id.virginioGomezButton);

        virginioGomezButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define la URL que deseas abrir
                String url = "https://www.virginiogomez.cl";

                // Crea un Intent para abrir el navegador web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Inicia el navegador web
                startActivity(intent);
            }
        });

        Button googleMapsButton = findViewById(R.id.googleMapsButton);

        googleMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define la dirección que deseas mostrar en Google Maps
                String direccion = "Virginio Gómez, Chillán";

                // Reemplaza los espacios en blanco con signos de adición (+) para formatear la URL correctamente
                direccion = direccion.replace(" ", "+");

                // Crea una URL para abrir Google Maps con la dirección especificada
                String url = "https://www.google.com/maps/search/" + direccion;

                // Crea un Intent para abrir Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Inicia Google Maps
                startActivity(intent);
            }
        });


    }

    private int generarNumeroAleatorio() {
        // Genera un número aleatorio entre 1 y 100
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
