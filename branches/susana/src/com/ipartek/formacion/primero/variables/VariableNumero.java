package com.ipartek.formacion.primero.variables;

import com.ipartek.formacion.primero.util.utilidades;

public class VariableNumero {

	public static void main(String[] args) {

		// variable numericas enteras
		System.out.println("Variables numericas enteras");
		
		//TODO funcion para pintar linea con un char y longitud pasada
		//System.out.println("_____________________________________________");
		//		ej:utilidades.pintarLinea( '_', 45); -- llamamos a una funcion estatica
		
		utilidades.pintarLinea( '_', 45);
		
		System.out.println("TIPO     Bytes/Nombre        Rango       ");

		// Hemos creado dos variables y le asignamos el valor minimo y maximo para variable numericas
		byte _byte_min = Byte.MIN_VALUE;
		byte _byte_max = Byte.MAX_VALUE;
		
		short _short_min = Short.MIN_VALUE;
		short _short_max = Short.MAX_VALUE;
		
		int _int_min = Integer.MIN_VALUE;
		int _int_max = Integer.MAX_VALUE;
		
		long _long_min = Long.MIN_VALUE;
		long _long_max = Long.MAX_VALUE;
		
		double _double_min = Double.MIN_VALUE;
		double _double_max = Double.MAX_VALUE;
		
		float _float_min = Float.MIN_VALUE;
		float _float_max = Float.MAX_VALUE;
		

		System.out.println("byte     " + Byte.SIZE/8 + " byte " + "             "
				+ _byte_min + "   hasta  " + _byte_max);
		
		System.out.println("Short    " + Short.SIZE/8 + " entero corto " + "    "
				+ _short_min + "   hasta  " + _short_max);
		
		System.out.println("Int      " + Integer.SIZE/8 + " entero largo " + "    "
				+ _int_min + "   hasta  " + _int_max);
		
		System.out.println("Long     " + Long.SIZE/8 + " entero largo " + "    "
				+ _long_min + "   hasta  " + _long_max);
		
		System.out.println("double   " + Double.SIZE/8 + " coma flotante doble " + "     "
				+ _double_min + "   hasta  " + _double_max);
		
		System.out.println("float    " + Float.SIZE/8 + " coma flotante " + "     "
				+ _float_min + "   hasta  " + _float_max);
		
		

	}

}
