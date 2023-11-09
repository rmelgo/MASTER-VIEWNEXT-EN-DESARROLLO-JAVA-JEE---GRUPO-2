/**
 * 
 */
package com.curso.practica9_11_2023;

import java.util.Random;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 */
public class Delantero extends Jugador implements IDelantero {
	
	private int goles_marcados;
	private int disparos_realizados;
	private int disparos_realizados_a_porteria;
	private final String posicion;
	private final static int MAX_DISTANCIA_DISPARO = 40;
	private final int DISPARO_FUERA = 0;
	private final int DISPARO_ATAJADO = 1;
	
	/**
	 * Constructor de la clase Delantero
	 * 
	 * @param nombre			Nombre del Jugador
	 * @param apellido			Apellido del Jugador
	 * @param dorsal			Dorsal del Jugador
	 * @since 1.0.0
	 */
	
	public Delantero(String nombre, String apellido, int dorsal) {
		super(nombre, apellido, dorsal);
		this.posicion = "DELANTERO";
	}
	
	/**
	 * El delantero dispara desde la distancia en metros indicada como parametro
	 * 
	 * @param distancia_a_porteria		Numero entero que hace referencia a la distancia en metros 
	 * 									en la que se encuentra el jugador en el momento de realizar el disparo
	 * @since 1.0.0
	 */
	
	public void disparar(int distancia_a_porteria) {
		System.out.println("El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " se dispone a chutar a la portería");
		
		Random rnd = new Random();
		int temp = rnd.nextInt(0, MAX_DISTANCIA_DISPARO);
		
		if (temp >= distancia_a_porteria) {
			System.out.println("Gooool!!!. El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " ha anotado un gol en la portería rival");
			System.out.println("El gol será anotado a su cuenta particular");
			this.disparos_realizados = this.disparos_realizados + 1;
			this.goles_marcados = this.goles_marcados + 1;
			Jugador.setTotal_goles_marcados(Jugador.getTotal_goles_marcados() + 1);
		} else {
			int motivo_fallo = rnd.nextInt(0, 2);
			
			if (motivo_fallo == DISPARO_FUERA) {
				System.out.println("Ha fallado!!. El disparo ha salido desviado"); 
				this.disparos_realizados = this.disparos_realizados + 1;
			}
			else if (motivo_fallo == DISPARO_ATAJADO) {
				System.out.println("Ha fallado!!. El portero realiza una gran intervencion para evitar el gol"); 
				this.disparos_realizados_a_porteria = this.disparos_realizados_a_porteria + 1;
			}			 
		}
	}
	
	/**
	 * Muestra las estadisticas recogidas por el delantero 
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
		System.out.println("Goles anotados: " + this.goles_marcados);
		System.out.println("Disparos realizados a puerta: " + this.disparos_realizados_a_porteria);
		System.out.println("Disparos realizados: " + this.disparos_realizados);
		System.out.println("===========================");
	}
}
