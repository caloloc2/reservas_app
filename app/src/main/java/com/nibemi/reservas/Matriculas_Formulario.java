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

import java.util.ArrayList;
import java.util.List;

public class Matriculas_Formulario extends AppCompatActivity {

    // llamamos a la clase Datos
    Datos datos = new Datos();
    // se crea los objetos para los botones
    Button btn_regresar, btn_agregarme;
    // se crea los objetos para los checkbox
    CheckBox ch_equipo1, ch_equipo2;
    // se crea los objetos para los textview
    TextView tipo_juego, nombre_juego, fecha_juego, hora_juego, tiempo_juego, txt_nombres_matricula;
    // se crea los objetos para los ListView
    ListView listado_equipo1, listado_equipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculas__formulario);

        txt_nombres_matricula = (TextView)findViewById(R.id.txt_nombres_matricula);

        listado_equipo1 = (ListView)findViewById(R.id.listado_equipo1);
        listado_equipo2 = (ListView)findViewById(R.id.listado_equipo2);

        // Llamamos a la funcion Llenar_Listado que muestra los jugadores de cada equipo
        Llenar_Listado();

        tipo_juego = (TextView)findViewById(R.id.tipo_juego);
        nombre_juego = (TextView)findViewById(R.id.nombre_juego);
        fecha_juego = (TextView)findViewById(R.id.fecha_juego);
        hora_juego = (TextView)findViewById(R.id.hora_juego);
        tiempo_juego = (TextView)findViewById(R.id.tiempo_juego);

        if (datos.Obtener_Seleccion_Juego()==1){
            // si se selecciono FUTBOL

            // obtiene la informacion de FUTBOl
            String[] futbol = datos.Datos_Futbol();
            // muestra la informacion obtenida en los campos de texto
            tipo_juego.setText("FUTBOL");
            nombre_juego.setText(futbol[0]);
            fecha_juego.setText(futbol[1]);
            hora_juego.setText(futbol[2]);
            tiempo_juego.setText(futbol[3]);
        }else if(datos.Obtener_Seleccion_Juego()==2){
            // si se selecciono VOLLEY

            // obtiene la informacion de VOLLEY
            String[] volley = datos.Datos_Volley();
            // muestra la informacion obtenida en los campos de texto
            tipo_juego.setText("VOLLEY");
            nombre_juego.setText(volley[0]);
            fecha_juego.setText(volley[1]);
            hora_juego.setText(volley[2]);
            tiempo_juego.setText(volley[3]);
        }else{
            // EN CASO DE Q NO SE TENGA EL TIPO DE JUEGO
            Toast.makeText(getApplicationContext(), "No se ha definido información para el juego.", Toast.LENGTH_SHORT).show();
            Regresar();
        }

        ch_equipo1 = (CheckBox)findViewById(R.id.ch_equipo1);
        // creamos el evento para click del ch_equipo1
        ch_equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_equipo1.isChecked()){ // si esta activado
                    ch_equipo2.setChecked(false); // desactiva el otro ch_equipo2
                }else{ // si esta desactivado
                    ch_equipo2.setChecked(true); // activa el otro ch_equipo2
                }
            }
        });

        ch_equipo2 = (CheckBox)findViewById(R.id.ch_equipo2);
        // creamos el evento para click del ch_equipo2
        ch_equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_equipo2.isChecked()){// si esta activado
                    ch_equipo1.setChecked(false);// desactiva el otro ch_equipo1
                }else{// si esta desactivado
                    ch_equipo1.setChecked(true);// activa el otro ch_equipo1
                }
            }
        });

        btn_agregarme = (Button)findViewById(R.id.btn_agregarme);
        // creamos el eveneto click para el boton agregarme
        btn_agregarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int equipo = 0;
                if (ch_equipo1.isChecked()){ // si esta activado
                    equipo = 1; // selecciono futbol
                }else if(ch_equipo2.isChecked()){ // si esta activado
                    equipo = 2; // selecciono volley
                }

                // obtiene el nombre del jugador
                String nombres = txt_nombres_matricula.getText().toString();

                if (!nombres.isEmpty()){ // si el nombre no esta vacio
                    // asigna o guarda el nombre del jugador dependiendo del juego seleccionado y el equipo
                    datos.Matricularme(equipo, datos.Obtener_Seleccion_Juego(), nombres);
                    // limpia el campo de nombre
                    txt_nombres_matricula.setText("");
                    // muestra mensaje de confirmacion
                    Toast.makeText(getApplicationContext(), "Jugador agregado.", Toast.LENGTH_SHORT).show();
                    // Llena la lista de jugadores
                    Llenar_Listado();
                }
            }
        });

        btn_regresar = (Button)findViewById(R.id.btn_regresar3);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a la funcion Regresar
                Regresar();
            }
        });
    }

    private void Regresar(){
        // crea la instancia para la actividad Matriculas_Actividad
        Intent Matriculas_Actividad = new Intent(getApplicationContext(), Matriculas.class);
        // llama a la actividad Matriculas_Actividad
        startActivity(Matriculas_Actividad);
        // Cierra la actividad actual
        finish();
    }

    private void Llenar_Listado(){
        // obtiene el numero total de jugadores del equipo 1 dependiendo el jeugo seleccionado
        int total = datos.Numero_Jugadores(datos.Obtener_Seleccion_Juego(), 1);
        // Creamos una variable tipo List
        ArrayList equipo1 = new ArrayList();

        for (int i=0; i<=total; i++){ // Recorre los jugadores disponibles
            // obtiene el nombre de cada jugador
            String dato = datos.Listado(datos.Obtener_Seleccion_Juego(), 1, i);
            // si el dato obtenido es diferente de nulo
            if (dato != null){
                // guarda en el Array Lista el nombre obtenido
                equipo1.add(dato);
            }
        }

        // Muestra mediante el adaptador la lista Array de equipo en el Listview listado_equipo1
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, equipo1);
        listado_equipo1.setAdapter(adapter);

        // obtiene el numero total de jugadores del equipo 2 dependiendo el jeugo seleccionado
        int total2 = datos.Numero_Jugadores(datos.Obtener_Seleccion_Juego(), 2);
        // Creamos una variable tipo List
        ArrayList equipo2 = new ArrayList();

        for (int i=0; i<=total2; i++){// Recorre los jugadores disponibles
            // obtiene el nombre de cada jugador
            String dato = datos.Listado(datos.Obtener_Seleccion_Juego(), 2, i);
            // si el dato obtenido es diferente de nulo
            if (dato!=null) {
                // guarda en el Array Lista el nombre obtenido
                equipo2.add(dato);
            }
        }

        // Muestra mediante el adaptador la lista Array de equipo en el Listview listado_equipo2
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, equipo2);
        listado_equipo2.setAdapter(adapter2);
    }
}
