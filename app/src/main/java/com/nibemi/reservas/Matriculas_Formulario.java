package com.nibemi.reservas;

import android.content.Intent;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class Matriculas_Formulario extends AppCompatActivity {

    Datos datos = new Datos();
    Button btn_regresar, btn_agregarme;
    CheckBox ch_equipo1, ch_equipo2;
    TextView tipo_juego, nombre_juego, fecha_juego, hora_juego, tiempo_juego, txt_nombres_matricula;
    ListView listado_equipo1, listado_equipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculas__formulario);

        txt_nombres_matricula = (TextView)findViewById(R.id.txt_nombres_matricula);

        listado_equipo1 = (ListView)findViewById(R.id.listado_equipo1);
        listado_equipo2 = (ListView)findViewById(R.id.listado_equipo2);

        Llenar_Listado();

        tipo_juego = (TextView)findViewById(R.id.tipo_juego);
        nombre_juego = (TextView)findViewById(R.id.nombre_juego);
        fecha_juego = (TextView)findViewById(R.id.fecha_juego);
        hora_juego = (TextView)findViewById(R.id.hora_juego);
        tiempo_juego = (TextView)findViewById(R.id.tiempo_juego);

        if (datos.Obtener_Seleccion_Juego()==1){
            String[] futbol = datos.Datos_Futbol();
            tipo_juego.setText("FUTBOL");
            nombre_juego.setText(futbol[0]);
            fecha_juego.setText(futbol[1]);
            hora_juego.setText(futbol[2]);
            tiempo_juego.setText(futbol[3]);
        }else if(datos.Obtener_Seleccion_Juego()==2){
            String[] volley = datos.Datos_Volley();
            tipo_juego.setText("VOLLEY");
            nombre_juego.setText(volley[0]);
            fecha_juego.setText(volley[1]);
            hora_juego.setText(volley[2]);
            tiempo_juego.setText(volley[3]);
        }else{
            Toast.makeText(getApplicationContext(), "No se ha definido información para el juego.", Toast.LENGTH_SHORT).show();
            Regresar();
        }

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
                int equipo = 0;
                if (ch_equipo1.isChecked()){
                    equipo = 1;
                }else if(ch_equipo2.isChecked()){
                    equipo = 2;
                }
                String nombres = txt_nombres_matricula.getText().toString();
                datos.Matricularme(equipo, datos.Obtener_Seleccion_Juego(), nombres);
                txt_nombres_matricula.setText("");
                Toast.makeText(getApplicationContext(), "Jugador agregado.", Toast.LENGTH_SHORT).show();
                Llenar_Listado();
            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar3);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });
    }

    private void Regresar(){
        Intent Matriculas_Actividad = new Intent(getApplicationContext(), Matriculas.class);
        startActivity(Matriculas_Actividad);
        finish();
    }

    private void Llenar_Listado(){
        int total = datos.Numero_Jugadores(datos.Obtener_Seleccion_Juego(), 1);
        String[] equipo1 = new String[10];
        int pos = 0;

        for (int i=0; i<=total; i++){
            try{
                equipo1[pos] = datos.Listado(datos.Obtener_Seleccion_Juego(), 1, i);
                pos+=1;
            }catch(Exception e){
                Log.d("NOMBRE JUGADOR", "NINGUNO");
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, equipo1);
        listado_equipo1.setAdapter(adapter);



        int total2 = datos.Numero_Jugadores(datos.Obtener_Seleccion_Juego(), 2);
        String[] equipo2 = new String[10];
        int pos2 = 0;

        for (int i=0; i<=total2; i++){
            try{
                equipo2[pos2] = datos.Listado(datos.Obtener_Seleccion_Juego(), 2, i);
                pos2+=1;
            }catch(Exception e){
                Log.d("NOMBRE JUGADOR", "NINGUNO");
            }
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, equipo2);
        listado_equipo2.setAdapter(adapter2);
    }
}
