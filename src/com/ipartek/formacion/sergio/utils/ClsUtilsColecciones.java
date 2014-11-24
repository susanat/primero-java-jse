package com.ipartek.formacion.sergio.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * TODO ¿Añadir a la clase? http://www.discoduroderoer.es/formas-de-ordenar-un-array-en-java/
 */

/**
 * Clase de recopilación de funciones útiles para trabajar con arrays y
 * colecciones
 * 
 * @author baskito
 * @version 04.11.2014
 */
public class ClsUtilsColecciones {
	/**
	 * Convierte un array tipo int[] a Integer[]
	 * 
	 * @param IntegerArray
	 *            Array de tipo Integer[]
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
	 * 
	 * @param IntegerArray
	 *            Array de tipo Integer[]
	 * @return Array tipo int[]
	 */
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}

	/**
	 * Ordena un array de tipo int[] <br>
	 * Utilizando conversión del array a tipo objeto Integer[] y devolviéndolo
	 * al tipo original
	 * 
	 * @param myArray
	 *            Array de tipo int a ordenar
	 * @param descent
	 *            Con true de manera descendente
	 * @return El array ordenado
	 */
	public static int[] sortedArrayInt(int[] myArray, boolean descent) {
		final Integer[] sorted = ClsUtilsColecciones.toObject(myArray);

		if (!descent) {
			Arrays.sort(sorted);
		} else {
			Arrays.sort(sorted, Collections.reverseOrder());
		}

		System.arraycopy(ClsUtilsColecciones.toPrimitive(sorted), 0, myArray,
				0, sorted.length);
		return myArray;
	}

	/**
	 * Ordena ascendente un array de tipo int[] * <br>
	 * Utilizando conversión del array a tipo objeto Integer[] y devolviéndolo
	 * al tipo original
	 * 
	 * @param myArray
	 *            Array de tipo int a ordenar
	 * @return El array ordenado
	 */
	public static int[] sortedArrayInt(int[] myArray) {
		return sortedArrayInt(myArray, false);
	}

	/**
	 * Comprueba si existe un elemento dentro del array
	 * 
	 * <br>
	 * Alternativa 1 a InArray de PHP
	 * 
	 * @param arr
	 * @param targetValue
	 * @return booleana, true si existe y false si no existe en el array
	 * @see 
	 *      //http://www.programcreek.com/2014/04/check-if-array-contains-a-value
	 *      -java/
	 */
	public static boolean inArray(float[] arr, float targetValue) {
		// TODO pasar a la clase ClsUtils y comprobar cual es la mejor forma del
		// url en @see

		for (float s : arr) {
			if (s == targetValue)
				return true;
		}
		return false;
	}

	public static boolean inArray(char[] arr, char targetValue) {
		// TODO pasar a la clase ClsUtils y comprobar cual es la mejor forma del
		// url en @see
		for (char s : arr) {
			if (s == targetValue)
				return true;
		}
		return false;
	}

	/***
	 * Convierte un array de chars en mayúsculas si no están ya en mayúsculas
	 * 
	 * @param lArray
	 * @return
	 */
	public static char[] charArrayToUpperCase(char[] lArray) {

		char[] arrayTmp = lArray;

		for (int counter = 0; counter < arrayTmp.length; counter++) {
			if (Character.isLetter(arrayTmp[counter])
					&& Character.isLowerCase(arrayTmp[counter])) {
				arrayTmp[counter] = Character.toUpperCase(arrayTmp[counter]);
			}
		}

		return arrayTmp;
	}

	public static <T> List<T> reverse(List<T> src) {
		List<T> results = new ArrayList<T>(src);
		Collections.reverse(results);
		return results;
	}

	public static boolean inArrayA(char[] arr, char targetValue) {
		// TODO pasar a la clase ClsUtils y comprobar cual es la mejor forma del
		// url en @see
		for (char s : arr) {
			if (s == targetValue)
				return true;
		}
		return false;
	}

	
	
	/**
	 * Paramterized method to sort Map e.g. HashMap or Hashtable in Java throw
	 * NullPointerException if Map contains null key
	 * 
	 * @see http 
	 *      ://javarevisited.blogspot.com/2012/12/how-to-sort-hashmap-java-by
	 *      -key-and-value.html#ixzz3JPWZiBTW
	 * 
	 * @map Map<K,V> to sort
	 * @descend boolean idicate if order descent (default false)
	 * 
	 * @return Map<K,V> sorted
	 */
	public static <K extends Comparable, V extends Comparable> Map<K, V> mapSortByKeys(
			Map<K, V> map, boolean descent) {
		List<K> keys = new LinkedList<K>(map.keySet());

		if (descent)
			Collections.sort(keys, Collections.reverseOrder());
		else
			Collections.sort(keys);

		// LinkedHashMap will keep the keys in the order they are inserted
		// which is currently sorted on natural ordering
		Map<K, V> sortedMap = new LinkedHashMap<K, V>();
		for (K key : keys) {
			sortedMap.put(key, map.get(key));
		}

		return sortedMap;
	}

	/**
	 * Paramterized method to sort Map e.g. HashMap or Hashtable in Java throw
	 * NullPointerException if Map contains null key
	 * 
	 * @see http 
	 *      ://javarevisited.blogspot.com/2012/12/how-to-sort-hashmap-java-by
	 *      -key-and-value.html#ixzz3JPWZiBTW
	 * 
	 * @map Map<K,V> to sort
	 * 
	 * @return Map<K,V> sorted
	 */
	public static <K extends Comparable, V extends Comparable> Map<K, V> mapSortByKeys(
			Map<K, V> map) {
		return mapSortByKeys(map, false);
	}

	/**
	 * Java method to sort Map in Java by value e.g. HashMap or Hashtable throw
	 * NullPointerException if Map contains null values It also sort values even
	 * if they are duplicates
	 * 
	 * @see http 
	 *      ://javarevisited.blogspot.com/2012/12/how-to-sort-hashmap-java-by
	 *      -key-and-value.html#ixzz3JPWZiBTW
	 * 
	 * @map Map<K,V> to sort
	 * @descend boolean idicate if order descent (default false)
	 * 
	 * @return Map<K,V> sorted
	 */
	public static <K extends Comparable, V extends Comparable> Map<K, V> mapSortByValues(
			Map<K, V> map, boolean descent) {
		List<Map.Entry<K, V>> entries = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());

		if (!descent) {
			Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
				@Override
				public int compare(Entry<K, V> o1, Entry<K, V> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
			});
		} else {
			Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
				@Override
				public int compare(Entry<K, V> o1, Entry<K, V> o2) {
					return (-1 * o1.getValue().compareTo(o2.getValue()));
				}
			});
		}

		// LinkedHashMap will keep the keys in the order they are inserted
		// which is currently sorted on natural ordering
		Map<K, V> sortedMap = new LinkedHashMap<K, V>();

		for (Map.Entry<K, V> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	/**
	 * Java method to sort Map in Java by value e.g. HashMap or Hashtable throw
	 * NullPointerException if Map contains null values It also sort values even
	 * if they are duplicates
	 * 
	 * @see http 
	 *      ://javarevisited.blogspot.com/2012/12/how-to-sort-hashmap-java-by
	 *      -key-and-value.html#ixzz3JPWZiBTW
	 * 
	 * @map Map<K,V> to sort
	 * 
	 * @return Map<K,V> sorted
	 */
	public static <K extends Comparable, V extends Comparable> Map<K, V> mapSortByValues(
			Map<K, V> map) {
		return mapSortByValues(map, false);
	}


}
