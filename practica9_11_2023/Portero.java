/**
 * 
 */
package com.curso.practica9_11_2023;

import java.util.Random;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 */
public class Portero extends Jugador implements IPortero {
	
	private int goles_encajados;
	private int paradas_realizadas;
	private final String posicion;
	private final static int MAX_DISTANCIA_DISPARO = 40;
	private final int DISPARO_FUERA = 0;
	private final int DISPARO_ANOTADO = 1;
	
	/**
	 * Constructor de la clase Portero
	 * 
	 * @param nombre				Nombre del Jugador
	 * @param apellido				Apellido del Jugador
	 * @param dorsal				Dorsal del Jugador
	 * @since 1.0.0
	 */
	
	public Portero(String nombre, String apellido, int dorsal) {
		super(nombre, apellido, dorsal);
		this.posicion = "PORTERO";
	}

	/**
	 * El portero intenta realizar una parado a un disparo realizado desde la distancia en metros indicada como parametro
	 * 
	 * @param distancia_disparo		Numero entero que hace referencia a la distancia en metros del disparo que el portero intenta parar									
	 * @since 1.0.0
	 */
	
	public void detenerDisparo(int distancia_disparo) {	
		System.out.println("El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " se dispone a detener el disparo realizado hacia la portería");
		
		Random rnd = new Random();
		int temp = rnd.nextInt(0, MAX_DISTANCIA_DISPARO);
		
		if (temp <= distancia_disparo) {
			System.out.println("Parada!!!. El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " ha evitado el gol en la portería rival con una gran parada");
			this.paradas_realizadas = this.paradas_realizadas + 1;
		} else {
			int motivo_fallo = rnd.nextInt(0, 2);
			
			if (motivo_fallo == DISPARO_FUERA) {
				System.out.println("El disparo ha salido desviado "); 
			}
			else if (motivo_fallo == DISPARO_ANOTADO) {
				System.out.println("Gooool!!. El portero no ha podido llegar a tiempo para evitar el gol"); 
				this.goles_encajados = this.goles_encajados + 1;
				Jugador.setTotal_goles_recibidos(Jugador.getTotal_goles_recibidos() + 1);
			}			 
		}
	}
	
	/**
	 * Muestra las estadisticas recogidas por el portero
	 * 
	 * @since 1.0.0
	 */
	
	@Override
	public void mostrarEstadisticas() {
		System.out.println("=======DATOS JUGADOR=======");
		System.out.println("Nombre: " + super.getNombre());
		System.out.println("Apellido: " + super.getApellido());
		System.out.println("Dorsal: " + super.getDorsal());
		System.out.println("Posicion: " + this.posicion);
		System.out.println("Goles encajados: " + this.goles_encajados);
		System.out.println("Paradas realizadas: " + this.paradas_realizadas);
		System.out.println("===========================");
	}

}
