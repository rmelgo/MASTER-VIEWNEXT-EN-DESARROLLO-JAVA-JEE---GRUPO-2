/**
 * 
 */
package com.curso.practica9_11_2023;

import java.util.Random;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 *
 */
public class Defensa extends Jugador implements IDefensa {

	private int goles_marcados;
	private int balones_recuperados;
	private int despejes_realizados;
	private final String posicion;
	private final static int MAX_DISTANCIA_REMATE = 20;
	private final int REMATE_FUERA = 0;
	private final int REMATE_ATAJADO = 1;
	
	/**
	 * Constructor de la clase Defensa
	 * 
	 * @param nombre				Nombre del Jugador
	 * @param apellido				Apellido del Jugador
	 * @param dorsal				Dorsal del Jugador
	 * @since 1.0.0
	 */
	
	public Defensa(String nombre, String apellido, int dorsal) {
		super(nombre, apellido, dorsal);
		this.posicion = "DEFENSA";
	}
	
	/**
	 * El defensa remata desde la distancia en metros indicada como parametro
	 * 
	 * @param distancia_a_porteria		Numero entero que hace referencia a la distancia en metros 
	 * 									en la que se encuentra el jugador en el momento de realizar el remate
	 * @since 1.0.0
	 */
	
	public void rematar(int distancia_a_porteria) {
		System.out.println("El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " se dispone a realizar un remate de cabeza hacia la portería");
		
		Random rnd = new Random();
		int temp = rnd.nextInt(0, MAX_DISTANCIA_REMATE);
		
		if (temp >= distancia_a_porteria) {
			System.out.println("Gooool!!!. El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " ha anotado un gol en la portería rival");
			System.out.println("El gol será anotado a su cuenta particular");
			this.goles_marcados = this.goles_marcados + 1;
			Jugador.setTotal_goles_marcados(Jugador.getTotal_goles_marcados() + 1);
		} else {
			int motivo_fallo = rnd.nextInt(0, 2);
			
			if (motivo_fallo == REMATE_FUERA) {
				System.out.println("Ha fallado!!. El remate ha salido desviado"); 
			}
			else if (motivo_fallo == REMATE_ATAJADO) {
				System.out.println("Ha fallado!!. El portero realiza una gran intervencion para evitar el gol"); 
			}			 
		}
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
	
	/**
	 * El defensa despeja el balon
	 * 
	 * @since 1.0.0
	 */
	
	public void despejar() {
		System.out.println("El jugador " + super.getNombre() + " " + super.getApellido() + " con dorsal " + super.getDorsal() + " se dispone a realizar un despeje");
		
		System.out.println("El balon sale por linea de banda. Buena acción defensiva por parte del defensa");
		this.despejes_realizados = this.despejes_realizados + 1;
	}
	
	/**
	 * Muestra las estadisticas recogidas por el defensa
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
		System.out.println("Goles marcados: " + this.goles_marcados);
		System.out.println("Balones recuperados: " + this.balones_recuperados);
		System.out.println("Despejes realizados: " + this.despejes_realizados);
		System.out.println("===========================");
	}
}
