package com.androidwithshiv.crudyalgomas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;

import com.androidwithshiv.crudoperation.R;

public class SplashActivity extends AppCompatActivity {

    // Duración de la pantalla de carga en milisegundos
    private static final int SPLASH_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Usar un controlador para esperar el tiempo especificado y luego abrir la actividad principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para abrir la actividad principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Cerrar la actividad de la pantalla de carga para evitar que el usuario la vea nuevamente al retroceder
                finish();
            }
        }, SPLASH_DURATION);
    }
}