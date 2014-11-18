package com.ipartek.formacion.primero.util;

import java.util.Arrays;
import java.util.Collections;

/*
 * TODO ¿Añadir a la clase? http://www.discoduroderoer.es/formas-de-ordenar-un-array-en-java/
 */


/**
 * Clase de recopilación de funciones útiles para trabajar con arrays y colecciones
 * 
 * @author baskito
 * @version 04.11.2014
 */
public class UtilidadesColecciones {
	/**
	 * Convierte un array tipo int[] a Integer[]
	 * @param IntegerArray Array de tipo Integer[]
	 * @return array tipo Integer[]
	 */
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}

	/**
	 * Convierte un array tipo Integer[] a int[]
	 * @param integerArray Array de tipo Integer[]
	 * @return Array tipo int[]
	 */
	public static int[] toPrimitive(Integer[] integerArray) {

		int[] result = new int[integerArray.length];
		for (int i = 0; i < integerArray.length; i++) {
			result[i] = integerArray[i].intValue();
		}
		return result;
	}

	/**
	 * Ordena un array de tipo int[]
	 * <br>
	 * Utilizando conversión del array a tipo objeto Integer[]
	 * y devolviéndolo al tipo original
	 * 
	 * @param myArray Array de tipo int a ordenar
	 * @param descent Con true de manera descendente
	 * @return El array ordenado
	 */
	public static int[] sortedArrayInt(int[] myArray,  boolean descent) {
		final Integer[] sorted = UtilidadesColecciones.toObject(myArray);

		if(!descent){
			Arrays.sort(sorted);
		}
		else
		{ 
			Arrays.sort(sorted, Collections.reverseOrder());
		}

		System.arraycopy(UtilidadesColecciones.toPrimitive(sorted), 0, myArray, 0, sorted.length);
		return myArray;
	}

	/**
	 * Ordena ascendente un array de tipo int[]
	 * * <br>
	 * Utilizando conversión del array a tipo objeto Integer[]
	 * y devolviéndolo al tipo original
	 * 
	 * @param myArray Array de tipo int a ordenar
	 * @return El array ordenado
	 */
	public static int[] sortedArrayInt(int[] myArray) {
		return sortedArrayInt(myArray, false);	
	}
	
	/**
	 * Comprueba si existe un elemento dentro del array
	 * 
	 * <br>Alternativa 1 a InArray de PHP
	 * @param arr
	 * @param targetValue
	 * @return booleana, true si existe y false si no existe en el array
	 * @see //http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
	 */
	public static boolean inArray(float[] arr, float targetValue) {	
		//TODO pasar a la clase ClsUtils y comprobar cual es la mejor forma del url en @see
		
		for(float s: arr){
			if(s == targetValue)
				return true;
		}
		return false;
	}
	
	public static boolean inArray(char[] arr, char targetValue) {	
		//TODO pasar a la clase ClsUtils y comprobar cual es la mejor forma del url en @see		
		for(char s: arr){
			if(s == targetValue)
				return true;
		}
		return false;
	}
	
	/***
     * Convierte un array de chars en mayúsculas si no están ya en mayúsculas
     * @param lArray
     * @return
     */
    public static char[] charArrayToUpperCase(char[] lArray ){
    	
    	char[] arrayTmp = lArray;
    	
    	for (int counter = 0; counter < arrayTmp.length; counter++) {
    		if(Character.isLetter(arrayTmp[counter]) && Character.isLowerCase(arrayTmp[counter])){
    			arrayTmp[counter] = Character.toUpperCase(arrayTmp[counter]);
        	}    		
    	}
    	
    	return arrayTmp;    	
    }

}
