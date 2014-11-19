package com.ipartek.formacion.primero.util;

public class Dado {

	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana", "Zuahitz", "Kepa",
			"Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz", "Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}
	
	/**
	 * 
	 * Muestra por pantalla una tabla con todos los participantes y el numero de veces 
	 * que han salido elegidos
	 * 
	 * ej;
	 * 		--------------------------------------------
	 * 		Participante			|		Tiradas	
	 * 		--------------------------------------------
	 * 		Susana								 12
	 * 		Zuhaitz								 98
	 * 		Fran							  1.112
	 * 		etc									etc
	 * 		--------------------------------------------
	 * 		13 Participante					  2.345
	 * 		--------------------------------------------
	 * 
	 * 
	 * @param numTiradas
	 * 			num de veces a tirar Dado
	 */
	public static void estatidisticas(int numTiradas) {
		 
		//TODO usar un HashMap 
		System.out.println("Estadisticas");
	}
	
	
	public static void main(String[] args) {
		tirar();
		estatidisticas(1);

	}

}
