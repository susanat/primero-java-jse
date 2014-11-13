package com.ipartek.formacion.primero.util;

import com.ipartek.formacion.primero.bean.herencia.Ordenable;

public class Utilidades {
	/**
	 * Construye y devuelve una cadena de una longitud solicitada formada a
	 * partir del caracter indicado
	 *
	 * @param caracter
	 * @param tamano_linea
	 * @return cadena
	 */
	public static String pintarLinea(char caracter, int tamano_linea) {
		String cadena = "";
		for (int i = 0; i < tamano_linea; i++) {
			cadena = cadena + caracter;
		}
		return (cadena);
	}

	// Sobrecargamos el metodo para que pueda ser llamado sin parametros y nos
	// pinte una linea por defecto
	public static String pintarLinea() {
		String cadena = "";
		for (int i = 0; i < 30; i++) {
			cadena = cadena + '*';
		}

		return (cadena);
	}

	/**
	 * Muestra el contenido de un array por pantalla ej: [0, 1, 2, 3, 4, 5]
	 *
	 * @param array
	 * @return cadena (String)
	 */
	public static String pintarArray(int[] array) {
		String cadena = null;
		if (array.length == 0) {
			cadena = "Ha introducido un array vacio";
		} else {
			cadena = "[ ";
			for (int i = 0; i < array.length; i++) {

				cadena = cadena + array[i];
				if (i != (array.length - 1)) {
					cadena = cadena + " , ";

				}
			}
			cadena = cadena + " ]";
		}
		return (cadena);
	}

	/**
	 * Funcion que invierte los valores de un array
	 *
	 * @param array
	 * @return
	 */

	public static int[] invertirArray(int[] array) {
		if (array.length == 0) {
			array[0] = 0;
		} else {
			for (int i = 0; i < array.length / 2; i++) {
				int temp = array[i];
				array[i] = array[array.length - 1 - i];
				array[array.length - 1 - i] = temp;
			}

		}
		return array;
	}

	/**
	 * Funcion que ordena un array usando el algoritmo BubbleSort (compara el
	 * valor de un elemento con el siguente y si cumple los criterios que
	 * queremos los intercambia)
	 *
	 * @param array
	 * @return
	 */
	public static int[] ordenarArray(int[] array) {
		boolean flag = true;
		int temp;

		while (flag) {
			flag = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true;
				}
			}
		}
		return array;
	}

	/**
	 * Funcion que recibe un caracter y evalua si es vocal o no
	 *
	 * @param c
	 *            <code>char</code>: el caracter a evaluar
	 * @return <code>true</code> si es vocal, <code>false</code> si es
	 *         consonante
	 */
	public static boolean isVocal(char c) {

		boolean vocal = false;

		switch (Character.toLowerCase(c)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			vocal = true;
			break;
		}
		return vocal;
	}

	/**
	 * Comprueba que sea una vocal: a, e, i, o, u
	 *
	 * @param c
	 *            char a comprobar
	 * @return true si el caracter es vocal
	 */
	public static boolean isVocal2(char c) {
		boolean resul = false;

		switch (Character.toLowerCase(c)) {
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

		return (resul);
	}

	/**
	 * Funcion que comprueba si un dni es valido
	 *
	 * @param dni
	 *            <code>String</code>: el dni a evaluar
	 * @return esCorrecto <code>Boolean</code>: indica si el dni es correcto o
	 *         no
	 */

	public static boolean comprobarDni(String dni) {
		boolean esCorrecto = false;
		String[] abecedario = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z" };
		boolean flag = false;
		if (dni.length() == 9) {// Comprobamos que tenga la longitud apropiada
			int numeroDni = Integer.parseInt(dni.substring(0, 8));

			if (numeroDni >= 00000000 && numeroDni <= 99999999) {

				// obtenemos la letra del dni introducido
				String letra = dni.substring(8, 9).toUpperCase();

				// Recorremos el abecedario en busca de la letra del dni que nos
				// han introducido
				for (int i = 0; i < abecedario.length; i++) {
					if (letra.equals(abecedario[i])) {
						// hemos encontrado la letra dentro de abecedario
						flag = true;
						break;
					}
				}
				if (flag) {
					esCorrecto = true;
				} else {
					// no se ha encontrado la letra dentro del abecedario
					System.out
							.println("El caracter que completa el dni no es correcto");
				}
			} else {
				// el numero es incorrecto
				System.out.println("El numero introducido no es correcto");
			}

		} else {
			// la longitud no es correcta
			System.out
					.println("La longitud del dni no es correcta, por favor introduzca un dni correcto");
		}
		return esCorrecto;
	}

	public static boolean comprobarTelefono(String telefono) {

		boolean esCorrecto = false;

		// Pattern patron_telefono = Pattern.compile("^\+?\d{1,3}?[-
		// .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$");
		// Matcher m = patron_telefono.matcher(telefono);
		// if(m.find()){
		// System.out.println("Telefono correcto");
		// }

		return esCorrecto;
	}

	/**
	 * Ordenar arrayOrdenable
	 *
	 * @param array
	 * @return
	 */
	public static Ordenable[] ordenarArrayOrdenable(Ordenable[] array) {
		boolean flag = true;
		Ordenable temp;

		while (flag) {
			flag = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].getPeso() > array[i + 1].getPeso()) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true;
				}
			}
		}
		return array;
	}

}
