package com.ipartek.formacion.primero;
//Organizacion carpetas: Compañia/Empresa/Departamento/ Lo que quieras


import com.ipartek.formacion.primero.bean.Alumno;
import com.ipartek.formacion.primero.bean.Libro;

public class HolaMundo {

	public static void main(String[] args) {
		
		String cadena = "Hola";
		String nombre = "Pepe";
		
		int repeticion =10;
	
		//Saludo con variable
		
		for (int i=0; i<repeticion; i++){
		System.out.println(cadena + " " + nombre + " " + i );
		}
		
		//Instanciar objeto de tipo Libro
		Libro lib = new Libro();
		System.out.println(lib);
		
		Libro lib2 = new Libro(10, "Java 7");
		System.out.println(lib2);
		
		lib.setTitulo("Quijote");
		System.out.println(lib.getTitulo());
		
		//Instanciar objeto de tipo Alumno
		Alumno alum= new Alumno();
		System.out.println(alum);
		
		Alumno alum2 = new Alumno();
		System.out.println(alum2);
		
		System.out.println(alum2.isMayorEdad());
		
		alum.setNombre("Pepe");
		alum.setApellido1("Garcia");
		alum.setApellido2("Lopez");
		alum.setEdad(15);
		alum.setDni("47880196R");
		alum.setPoblacion("Gasteiz");
		alum.setTfno("478541269");
		alum.setSexo('m');
		System.out.println(alum);
	}
	

}
