/**
 * 
 */
package com.curso.practica9_11_2023;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 */
public class Equipo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Se crean 4 jugadores
		Jugador j1 = new Delantero("Cristiano", "Ronaldo", 7);
		Jugador j2 = new Portero("Iker", "Casillas", 1);
		Jugador j3 = new Defensa("Sergio", "Ramos", 4);
		Jugador j4 = new Centrocampista("Xabi", "Alonso", 14);
		
		//Se prueban los distintos metodos para cada tipo de Jugador (simulacion de un partido)
		j1.pasar(j4);
		((Delantero) j1).disparar(15);
		j2.pasar(j3);
		((Portero) j2).detenerDisparo(22);
		j3.pasar(j4);
		((Defensa) j3).rematar(12);
		((Defensa) j3).despejar();
		((Defensa) j3).recuperar();
		j4.pasar(j3);
		((Centrocampista) j4).recuperar();
		((Centrocampista) j4).disparar(30);
		
		//Se muestran las estadisticas de los Jugadores tras realizar las acciones del partido
		j1.mostrarEstadisticas();
		j2.mostrarEstadisticas();
		j3.mostrarEstadisticas();
		j4.mostrarEstadisticas();
		
		
		//Se muestran los goles anotados y recibidos por todos los jugadores (se asume que forman un equipo)
		System.out.println("Goles anotados por el equipo: " + Jugador.getTotal_goles_marcados());
		System.out.println("Goles recibidos por el equipo: " + Jugador.getTotal_goles_recibidos());
	}

}
