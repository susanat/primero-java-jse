package com.ipartek.formacion.primero.variables;

import com.ipartek.formacion.primero.util.Utilidades;


public class VariablesNumericas {

	public static void main(String[] args) {
		System.out.println("Variables numericas enteras");
		
		System.out.println("Tipo   Bytes Nombre               Rango");
		
		Utilidades.pintarLinea('*', 85);
		
		System.out.println("byte   " + Byte.SIZE/8 
				+	"     byte                 " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);
		
		System.out.println("short  " + Short.SIZE/8 + 
				"     entero corto         " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);
		
		System.out.println("int    " + Integer.SIZE/8 + 
				"     entero largo         " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
		
		System.out.println("long   " + Long.SIZE/8 + 
				"     entero largo         " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
		
		System.out.println("double " + Double.SIZE/8 + 
				"     coma flotante doble  " + Double.MIN_VALUE + " a " + Double.MAX_VALUE);
		
		System.out.println("Float  " + Float.SIZE/8 + 
				"     coma flotante        " + Float.MIN_VALUE + " a " + Float.MAX_VALUE);
		
		
		
	}

}
