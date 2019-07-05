package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Matriculas extends AppCompatActivity {

    Button btn_futbol, btn_volley, btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculas);

        btn_futbol = (Button)findViewById(R.id.btn_futbol2);
        btn_futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Formulario();
            }
        });

        btn_volley = (Button)findViewById(R.id.btn_volley2);
        btn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Formulario();
            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar2);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Principal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Principal);
                finish();
            }
        });
    }

    private void Formulario(){
        Intent Formulario_Matriculas = new Intent(getApplicationContext(), Matriculas_Formulario.class);
        startActivity(Formulario_Matriculas);
        finish();
    }
}
