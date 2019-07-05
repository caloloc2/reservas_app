package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reservas_Formulario extends AppCompatActivity {

    TextView txt_nombres, txt_fecha, txt_hora, txt_tiempo;
    Button btn_guardar, btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas__formulario);

        txt_nombres = (TextView)findViewById(R.id.txt_nombres);
        txt_fecha = (TextView)findViewById(R.id.txt_fecha);
        txt_hora = (TextView)findViewById(R.id.txt_hora);
        txt_tiempo = (TextView)findViewById(R.id.txt_tiempo);

        btn_guardar = (Button)findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("nombres", txt_nombres.getText().toString());
                Log.d("fecha", txt_fecha.getText().toString());
                Log.d("hora", txt_hora.getText().toString());
                Log.d("tiempo", txt_tiempo.getText().toString());
            }
        });

        btn_cancelar = (Button)findViewById(R.id.btn_cancelar);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Reservas_Actividad = new Intent(getApplicationContext(), Reservas.class);
                startActivity(Reservas_Actividad);
                finish();
            }
        });
    }
}
