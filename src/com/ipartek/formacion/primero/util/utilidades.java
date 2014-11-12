package com.ipartek.formacion.primero.util;


/**
 * Clase con metodos staticos para no tener que crear un objeto al usarlo
 * 
 * @author Curso
 *
 */

public class utilidades {

	/**
	 * Muestra por pantalla una linea con un caracter y de longitud deseado
	 * 
	 * @param c
	 *            caracter a mostrar
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
	 * Clase para probar los Arrays en Java
	 * 
	 * @param myArray
	 */
	public static void pintarArray(int[] myArray) {
		// para mostrar todas las posiciones
		System.out.print("[ ");
		for (int i = 0; i < myArray.length; i++) {
			// pintar valor de la posicion
			System.out.print(myArray[i]);
			// Si no es el ultimo pintar el separador
			// (myArray.length -1) para que se ejecute lo primero
			if (i != (myArray.length - 1)) {
				System.out.print(" , ");
			}
		}
		System.out.println(" ]");
	}

	/**
	 * Retorna un Array invertido Ej:[0,1,2,3,4] salida: [4,3,2,1,0]
	 * 
	 * @param myArray3
	 * @return int[] array pasado por parametro invertido
	 */

	public static int[] pintarArrayinversa(int[] array) {

		// Declaror tamaño array
		int tamanio = array.length;

		// Crear nuevo array para retornar
		int[] resul = new int[tamanio];

		// recorrer array de parametro y rellenar el de retorno
		for (int i = 0; i < tamanio; i++) {
			resul[(tamanio - 1) - i] = array[i];
		}

		// retornar array invertido
		return resul;

	}

	/**
	 * Retorna un Array ordenado de enteros de menor a mayor [89,54,3,2,45]
	 * salida: [2,3,45,54,89]
	 * 
	 * @param array
	 *            desordenado
	 * @return array ordenado
	 */

	public static int[] ordenarArray(int[] array) {

		int[] resul = new int[array.length];

		// ordenacion en burbuja o bubble sort
		int j;
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) // change to > for ascending
													// sort
				{
					temp = array[j]; // te guarda el valor en una variable temporal
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
	 * Comprueba que sea una vocal: a,e,i,o,u,A,E,I,O,U y con acentos
	 * @param caracter char a comprobar
	 * @return true si es una vocal
	 */
	
	public static boolean isVocal( char caracter){
		
		boolean resul = false;
		
		//Asi comprobamos tambien las mayusculas Character.toLowerCase(caracter)
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
			resul=true;
			break;
		
		default:
			break;
		}
		
		
		return resul;
	}
	

}
