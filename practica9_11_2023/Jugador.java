/**
 * 
 */
package com.curso.practica9_11_2023;

/**
 * @author Raul Melgosa Salvador
 * @version 1.0.0
 */
public abstract class Jugador {

	private String nombre;
	private String apellido;
	private int dorsal;
	
	private static int total_goles_marcados = 0;
	private static int total_goles_recibidos = 0;
	
	/**
	 * Constructor de la clase Jugador
	 * 
	 * @param nombre			Nombre del Jugador
	 * @param apellido			Apellido del Jugador
	 * @param dorsal			Dorsal del Jugador
	 * @since 1.0.0
	 */
	
	public Jugador(String nombre, String apellido, int dorsal) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dorsal = dorsal;
	}

	/**
	 * Obtiene el valor del nombre del Jugador
	 * 
	 * @return El nombre del Jugador
	 * @since 1.0.0
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el valor del nombre del Jugador con el valor pasado como parámetro
	 * 
	 * @param El nombre del Jugador
	 * @since 1.0.0
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el valor del apellido del Jugador
	 * 
	 * @return El apellido del Jugador
	 * @since 1.0.0
	 */

	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el valor del apellido del Jugador con el valor pasado como parámetro
	 * 
	 * @param El apellido del Jugador
	 * @since 1.0.0
	 */

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el valor del dorsal del Jugador
	 * 
	 * @return El dorsal del Jugador
	 * @since 1.0.0
	 */

	public int getDorsal() {
		return dorsal;
	}

	/**
	 * Establece el valor del dorsal del Jugador con el valor pasado como parámetro
	 * 
	 * @param El dorsal del Jugador
	 * @since 1.0.0
	 */

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	/**
	 * Obtiene el valor del número de goles marcados por todos los jugadores
	 * 
	 * @return Numero total de goles marcados por todos los jugadores
	 * @since 1.0.0
	 */
	
	public static int getTotal_goles_marcados() {
		return total_goles_marcados;
	}

	/**
	 * Establece el valor del número de goles marcados por todos los jugadores con el valor pasado como parámetro
	 * 
	 * @param El número de goles marcados
	 * @since 1.0.0
	 */

	public static void setTotal_goles_marcados(int total_goles_marcados) {
		Jugador.total_goles_marcados = total_goles_marcados;
	}

	/**
	 * Obtiene el valor del número de goles recibidos por todos los jugadores
	 * 
	 * @return Numero total de goles recibidos por todos los jugadores
	 * @since 1.0.0
	 */

	public static int getTotal_goles_recibidos() {
		return total_goles_recibidos;
	}

	/**
	 * Establece el valor del número de goles recibidos por todos los jugadores con el valor pasado como parámetro
	 * 
	 * @param El número de goles recibidos
	 * @since 1.0.0
	 */

	public static void setTotal_goles_recibidos(int total_goles_recibidos) {
		Jugador.total_goles_recibidos = total_goles_recibidos;
	}

	/**
	 * El jugador realiza un pase hacia otro jugador 
	 * 
	 * @param jugador_destinatario_pase 	El jugador destinatario del pase
	 * @since 1.0.0
	 */

	public void pasar(Jugador jugador_destinatario_pase) {
		System.out.println("El jugador " + this.nombre + " " + this.apellido + " con dorsal " + this.dorsal + " se dispone a realizar un pase a " + jugador_destinatario_pase.nombre + " " + jugador_destinatario_pase.apellido + " con dorsal " + jugador_destinatario_pase.dorsal);
		
		System.out.println("Ahora, el jugador " + jugador_destinatario_pase.nombre + " " + jugador_destinatario_pase.apellido + " con dorsal " + jugador_destinatario_pase.dorsal + " tiene el control del balón");
	}

	/**
	 * Se muestran las estadisticas del jugador
	 * 
	 * @since 1.0.0
	 */
	
	public abstract void mostrarEstadisticas();
}
