package com.ipartek.formacion.primero;

import com.ipartek.formacion.primero.bean.Libro;

public class HolaMundo {

	public static void main(String[] args) {
		
		
		String cadena = "Hola";
		String nombre = "Pepe";
		
		int repeticion = 12;
		
		for (int i = 0; i < repeticion; i++) {
			
			//saludo con la varible 
			System.out.println( cadena + " " + nombre + " " + i );
			

			
		} 
		
		
		//instanciar objeto de tipo Libro
		Libro lib = new Libro();
		
		lib.setTitulo("titulo");
		System.out.println(lib);
		
		
		Libro lib2 = new Libro(10,"Java 7");
		System.out.println(lib2);
		
		lib.setTitulo("Quijote");
		System.out.println(lib.getTitulo());
		
		
		
		
		
		
	}

}
