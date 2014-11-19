package com.ipartek.formacion.primero.practicas;

import com.ipartek.formacion.primero.util.utilidades;

/**
 * Clase para probar los arrays en Java
 * @author Curso
 *
 */

public class Arrays {

	//para poder mostrar en pantalla 
	public static void main(String[] args) {
		
		// Declarar un array de enteros con 10 posiciones, vacias
		int[] myArray = new int[10];
		
		//llama a la funcion creada en utilidades
  
		
		//Cambiar valor de la posicion 4 a valor 25
		myArray[3]= 25;
		utilidades.pintarArray(myArray);
		
		//Inicializar Array de tres posiciones de enteros y en cada posicion debe de 
		//tener el valor de la posicion
		int[] myArray2 = new int[]{0, 1, 2};
		utilidades.pintarArray(myArray2);
		
		
		//Ejercicio1: Dado el siguiente array funcion para invertir los valores
		//Ej:[0,1,2,3,4] salida: [4,3,2,1,0]
		int[] myArray3 = new int[]{0, 1, 2, 3, 4};	
		System.out.println("Array Original");
		utilidades.pintarArray(myArray3);
		
		int[] invertido = utilidades.pintarArrayinversa(myArray3);
		System.out.println("Array Invertida");
		utilidades.pintarArray(invertido);
		
		//Ejercicio2:Dado un array ordenar sus valores de menor a mayor
		//Ej: [89,54,3,2,45] salida: [2,3,45,54,89]
		int[] myArray4 = new int[]{89, 54, 3, 2, 45};
		System.out.println("Array Original");
		utilidades.pintarArray(myArray4);
		
		
		int[] ordenada = utilidades.ordenarArray(myArray4);
		System.out.println("Array Ordenada");
		utilidades.pintarArray(ordenada);
		
	}

}
