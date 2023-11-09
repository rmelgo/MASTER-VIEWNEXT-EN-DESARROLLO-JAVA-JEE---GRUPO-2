/**
 * 
 */
package com.curso.practica9_11_2023;

import java.util.Random;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 */
public class Centrocampista extends Jugador implements ICentrocampista {

	private int goles_marcados;
	private int pases_realizados;
	private int balones_recuperados;
	private final String posicion;
	private final static int MAX_DISTANCIA_DISPARO = 40;
	private final int DISPARO_FUERA = 0;
	private final int DISPARO_ATAJADO = 1;
	
	/**
	 * Constructor de la clase Centrocampista
	 * 
	 * @param nombre				Nombre del Jugador
	 * @param apellido				Apellido del Jugador
	 * @param dorsal				Dorsal del Jugador
	 * @since 1.0.0
	 */
	
	public Centrocampista(String nombre, String apellido, int dorsal) {
		super(nombre, apellido, dorsal);
		this.posicion = "CENTROCAMPISTA";
	}
	
	/**
	 * El centrocampista dispara desde la distancia en metros indicada como parametro
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
			this.goles_marcados = this.goles_marcados + 1;
			Jugador.setTotal_goles_marcados(Jugador.getTotal_goles_marcados() + 1);
		} else {
			int motivo_fallo = rnd.nextInt(0, 2);
			
			if (motivo_fallo == DISPARO_FUERA) {
				System.out.println("Ha fallado!!. El disparo ha salido desviado"); 
			}
			else if (motivo_fallo == DISPARO_ATAJADO) {
				System.out.println("Ha fallado!!. El portero realiza una gran intervencion para evitar el gol"); 
			}			 
		}
	}
	
	/**
	 * El jugador realiza un pase hacia otro jugador 
	 * 
	 * @param jugador_destinatario_pase 	El jugador destinatario del pase
	 * @since 1.0.0
	 */
	
	@Override
	public void pasar(Jugador jugador_destinatario_pase) {
		super.pasar(jugador_destinatario_pase);
		this.pases_realizados = this.pases_realizados + 1;
	}
	
	/**
	 * El defensa intenta recuperar el balon
	 * 
	 * @since 1.0.0
	 */
	
	public void recuperar() {
		System.out.println("El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " se dispone a recuperar el balón");
		
		Random rnd = new Random();
		int resultado_recuperacion = rnd.nextInt(0, 2);
		
		if (resultado_recuperacion == 0) {
			System.out.println("El defensa fallo en su intento de recuperar el balón"); 
		}
		else {
			System.out.println("Gran recuperación del balón por parte de la defensa"); 
			this.balones_recuperados = this.balones_recuperados + 1;
		}	
	}

	@Override
	public void mostrarEstadisticas() {
		System.out.println("=======DATOS JUGADOR=======");
		System.out.println("Nombre: " + super.getNombre());
		System.out.println("Apellido: " + super.getApellido());
		System.out.println("Dorsal: " + super.getDorsal());
		System.out.println("Posicion: " + this.posicion);
		System.out.println("Goles marcados: " + this.goles_marcados);
		System.out.println("Pases realizados: " + this.pases_realizados);
		System.out.println("Balones recuperados: " + this.balones_recuperados);
		System.out.println("===========================");	
	}

}
