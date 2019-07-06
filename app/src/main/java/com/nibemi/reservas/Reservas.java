package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservas extends AppCompatActivity {

    // llama a la clase Datos
    Datos datos = new Datos();
    // se crea los objetos para los botones
    Button btn_futbol, btn_volley, btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        btn_futbol = (Button)findViewById(R.id.btn_futbol);
        // creamos el evento click para el boton futbol
        btn_futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // guardamos la seleccion del tipo de juego
                datos.Seleccion_Juego(1);
                // Llamamos a la funcion Formulario que abre una nueva actividad
                Formulario();
            }
        });

        btn_volley = (Button)findViewById(R.id.btn_volley);
        // creamos el evento click para el boton volley
        btn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // guardamos la seleccion del tipo de juego
                datos.Seleccion_Juego(2);
                // Llamamos a la funcion Formulario que abre una nueva actividad
                Formulario();
            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar);
        // creamos el evento click para el boton regresar
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setea en cero la seleccion del juego
                datos.Seleccion_Juego(0);
                // crea la instancia para la actividad MainActivity
                Intent Principal = new Intent(getApplicationContext(), MainActivity.class);
                // llama a la actividad MainActivity
                startActivity(Principal);
                // Cierra la actividad actual
                finish();
            }
        });
    }

    private void Formulario(){
        // crea la instancia para la actividad Formulario_Reservas
        Intent Formulario_Reservas = new Intent(getApplicationContext(), Reservas_Formulario.class);
        // llama a la actividad Formulario_Reservas
        startActivity(Formulario_Reservas);
        // Cierra la actividad actual
        finish();
    }
}
