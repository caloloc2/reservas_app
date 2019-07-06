package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // se crea los objetos para los botones
    Button btn_reservas, btn_matriculas, btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_reservas = (Button)findViewById(R.id.btn_reservas);
        // creamos el evento click para el boton de reservas
        btn_reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos la instancia para llamar a la actividad Reservas
                Intent Reservas_Actividad = new Intent(getApplicationContext(), Reservas.class);
                // Iniciamos la actividad Reservas
                startActivity(Reservas_Actividad);
                // Cerramos la actividad actual
                finish();
            }
        });

        btn_matriculas = (Button)findViewById(R.id.btn_matriculas);
        // creamos el evento click para el boton de matriculas
        btn_matriculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos la instancia para llamar a la actividad Matriculas
                Intent Matriculas_Actividad = new Intent(getApplicationContext(), Matriculas.class);
                // Iniciamos la actividad Matriculas
                startActivity(Matriculas_Actividad);
                // Cerramos la actividad actual
                finish();
            }
        });

        btn_salir = (Button)findViewById(R.id.btn_salir);
        // creamos el evento click para el boton de salida
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerramos la actividad actual, por ende la aplicacion completa
                finish();
            }
        });
    }
}
