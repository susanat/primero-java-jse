package com.ipartek.formacion.primero.util;

/**
 * Clase con metodos staticos para no tener que crear un objeto al usarlos
 * 
 * @author ur00
 *
 */
public class Utilidades {

	/**
	 * Muestra por pantalla una linea con un caracter y de longitud desada
	 * 
	 * @param c
	 *            character a mostrar
	 * @param longitud
	 *            de la linea
	 */
	public static void pintarLinea(char c, int longitud) {

		for (int i = 0; i < longitud; i++) {
			System.out.print(c);
		}
		System.out.println("");
	}

	/**
	 * Muetsra todas las posciones del Array por pantalla usando un separador de
	 * "," y comienzo y final con "[" y "]" respectivamente ej: [ 0 , 1 , 2 , 3
	 * , 4 ]
	 * 
	 * @param myArray
	 *            array con datos a mostrar
	 */
	public static void pintarArray(int[] myArray) {

		System.out.print("[ ");
		for (int i = 0; i < myArray.length; i++) {
			// pintar valor de la posicion del array
			System.out.print(myArray[i]);
			// Si no es el ulitmo, pintar separador
			if (i != (myArray.length - 1)) {
				System.out.print(" , ");
			}

		}
		System.out.println(" ]");

	}

	/**
	 * Retorna un Array invertido Ej: [0,1,2,3,4] salida: [4,3,2,1,0]
	 * 
	 * @param array
	 *            array de tipo {@code int} para invertir
	 * @return int[] array pasado por parametro invertido
	 */
	public static int[] invertirArray(int[] array) {

		// declara tamaño array
		int tamanio = array.length;

		// crear nuevo array para retornar
		int[] resul = new int[tamanio];

		// recorrer array de parametro y rellenar el de retorno
		for (int i = 0; i < tamanio; i++) {
			resul[tamanio - 1 - i] = array[i];
		}

		// retornar array invertido
		return resul;
	}

	/**
	 * Ordena un array de enteros de menor a mayor
	 * 
	 * @param array
	 *            desordenado
	 * @return array ordenado
	 */
	public static int[] ordenarArray(int[] array) {

		int[] resul = new int[array.length];
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) // change to > for ascending sort
				{
					temp = array[j]; // swap elements
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}
		resul = array;
		return resul;
	}

	/**
	 * Comprueba que sea una vocal: a,e,i,o,u,A,E,I,O,U y con acento
	 * 
	 * @param caracter
	 *            char a comprobar
	 * @return true si es un caracter vocal
	 */
	public static boolean isVocal(char caracter) {
		boolean resul = false;

		switch (Character.toLowerCase(caracter)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'á':
		case 'é':
		case 'í':
		case 'ó':
		case 'ú':
			resul = true;
			break;

		default:
			break;
		}

		return resul;
	}

}
