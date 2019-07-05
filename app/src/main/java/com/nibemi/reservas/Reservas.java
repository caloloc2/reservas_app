package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservas extends AppCompatActivity {

    Datos datos = new Datos();
    Button btn_futbol, btn_volley, btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        btn_futbol = (Button)findViewById(R.id.btn_futbol);
        btn_futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.Seleccion_Juego(1);
                Formulario();
            }
        });

        btn_volley = (Button)findViewById(R.id.btn_volley);
        btn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.Seleccion_Juego(2);
                Formulario();
            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.Seleccion_Juego(0);
                Intent Principal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Principal);
                finish();
            }
        });
    }

    private void Formulario(){
        Intent Formulario_Reservas = new Intent(getApplicationContext(), Reservas_Formulario.class);
        startActivity(Formulario_Reservas);
        finish();
    }
}
