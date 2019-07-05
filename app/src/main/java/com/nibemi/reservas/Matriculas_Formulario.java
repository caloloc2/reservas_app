package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Matriculas_Formulario extends AppCompatActivity {

    Button btn_regresar, btn_agregarme;
    CheckBox ch_equipo1, ch_equipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculas__formulario);

        ch_equipo1 = (CheckBox)findViewById(R.id.ch_equipo1);
        ch_equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_equipo1.isChecked()){
                    ch_equipo2.setChecked(false);
                }else{
                    ch_equipo2.setChecked(true);
                }
            }
        });

        ch_equipo2 = (CheckBox)findViewById(R.id.ch_equipo2);
        ch_equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_equipo2.isChecked()){
                    ch_equipo1.setChecked(false);
                }else{
                    ch_equipo1.setChecked(true);
                }
            }
        });

        btn_agregarme = (Button)findViewById(R.id.btn_agregarme);
        btn_agregarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar3);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Matriculas_Actividad = new Intent(getApplicationContext(), Matriculas.class);
                startActivity(Matriculas_Actividad);
                finish();
            }
        });
    }
}
