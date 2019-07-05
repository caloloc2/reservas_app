package com.nibemi.reservas;

public class Datos {
    public static String[] futbol = new String[4];
    public static String[] volley = new String[4];
    public static String[] equipo1_futbol = new String[10];
    public static String[] equipo2_futbol = new String[10];
    public static String[] equipo1_volley = new String[10];
    public static String[] equipo2_volley = new String[10];
    private static int num_fut_e1 = 0;
    private static int num_fut_e2 = 0;
    private static int num_vol_e1 = 0;
    private static int num_vol_e2 = 0;
    private static int seleccion_juego = 0;

    public void Seleccion_Juego(int valor){
        seleccion_juego = valor;
    }

    public int Obtener_Seleccion_Juego(){
        return seleccion_juego;
    }

    public void Datos_Futbol(String nombres, String fecha, String hora, String tiempo){
        futbol[0] = nombres;
        futbol[1] = fecha;
        futbol[2] = hora;
        futbol[3] = tiempo;
    }

    public String[] Datos_Futbol(){
        return futbol;
    }

    public void Datos_Volley(String nombres, String fecha, String hora, String tiempo){
        volley[0] = nombres;
        volley[1] = fecha;
        volley[2] = hora;
        volley[3] = tiempo;
    }

    public String[] Datos_Volley(){
        return futbol;
    }

    public void Matricularme(int equipo, int juego, String nombres){
        if (equipo == 1){
            if (juego==1){
                equipo1_futbol[num_fut_e1] = nombres;
                num_fut_e1+=1;
            }else if(juego==2){
                equipo2_futbol[num_fut_e2] = nombres;
                num_fut_e2+=1;
            }
        }else if (equipo == 2){
            if (juego==1){
                equipo1_volley[num_vol_e1] = nombres;
                num_vol_e1+=1;
            }else if(juego==2){
                equipo2_volley[num_vol_e2] = nombres;
                num_vol_e2+=1;
            }
        }
    }

    public int Numero_Jugadores(int juego, int equipo){
        int aux = 0;
        if (equipo==1){
            if (juego ==1){
                aux = num_fut_e1;
            }else if(juego==2){
                aux = num_fut_e2;
            }
        }else if (equipo==2){
            if (juego ==1){
                aux = num_vol_e1;
            }else if(juego==2){
                aux = num_vol_e2;
            }
        }

        return aux;
    }

    public String Listado(int juego, int equipo, int pos){
        String nombre = "";

        if (equipo==1){
            if (juego==1){
                nombre = equipo1_futbol[pos];
            }else if(juego==2){
                nombre = equipo2_futbol[pos];
            }
        }else if(equipo==2){
            if (juego==1){
                nombre = equipo1_volley[pos];
            }else if(juego==2){
                nombre = equipo2_volley[pos];
            }
        }

        return nombre;
    }
}

