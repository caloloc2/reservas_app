package com.nibemi.reservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reservas_Formulario extends AppCompatActivity {

    Datos datos = new Datos();

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
                String nombres_aux = txt_nombres.getText().toString();
                String fecha_aux = txt_fecha.getText().toString();
                String hora_aux = txt_hora.getText().toString();
                String tiempo_aux = txt_tiempo.getText().toString();

                if (datos.Obtener_Seleccion_Juego()==1){
                    datos.Datos_Futbol(nombres_aux, fecha_aux, hora_aux, tiempo_aux);
                    Toast.makeText(getApplicationContext(), "Se ha ingresado los datos correctamente para FUTBOL.", Toast.LENGTH_SHORT).show();
                    Regresar();
                }else if (datos.Obtener_Seleccion_Juego()==2){
                    datos.Datos_Volley(nombres_aux, fecha_aux, hora_aux, tiempo_aux);
                    Toast.makeText(getApplicationContext(), "Se ha ingresado los datos correctamente para VOLLEY.", Toast.LENGTH_SHORT).show();
                    Regresar();
                }
            }
        });

        btn_cancelar = (Button)findViewById(R.id.btn_cancelar);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });
    }

    private void Regresar(){
        Intent Reservas_Actividad = new Intent(getApplicationContext(), Reservas.class);
        startActivity(Reservas_Actividad);
        finish();
    }
}
