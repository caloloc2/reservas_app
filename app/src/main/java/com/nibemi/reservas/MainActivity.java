package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_reservas, btn_matriculas, btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_reservas = (Button)findViewById(R.id.btn_reservas);

        btn_reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Reservas_Actividad = new Intent(getApplicationContext(), Reservas.class);
                startActivity(Reservas_Actividad);
                finish();
            }
        });

        btn_matriculas = (Button)findViewById(R.id.btn_matriculas);

        btn_matriculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Matriculas_Actividad = new Intent(getApplicationContext(), Matriculas.class);
                startActivity(Matriculas_Actividad);
                finish();
            }
        });

        btn_salir = (Button)findViewById(R.id.btn_salir);

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
