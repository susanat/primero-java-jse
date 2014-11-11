package com.ipartek.formacion.proyectoclase;

import java.util.Calendar;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;





import com.ipartek.formacion.proyectoclase.pojo.Alumno;
import com.ipartek.formacion.proyectoclase.pojo.Libro;
import com.ipartek.formacion.proyectoclase.util.Cambio;
import com.ipartek.formacion.proyectoclase.util.Util;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar f_nacimiento = Calendar.getInstance();
		Alumno al = new Alumno();
		Libro l = new Libro();
		JSONObject json1 = new JSONObject(l);
		Iterator<String> it = json1.keys();		
		Cambio calcular = new Cambio();		

		String texto = null;
		if(texto ==null){
			System.out.println("Es nulo");
		}
		if(!"".equals(texto)){
			System.out.println("distinto de \"\" pero no compueba que sea nulo");
		}
		
		calcular.calcularVueltas(2000.0,1326.24);
		calcular.mostrarCambios();
			
		if(Util.isVocal('t'))
			System.out.println("Es vocal");
		else
			System.out.println("no es vocal");
		

		/*
		f_nacimiento.set(1976, 10, 24);		
		al.setF_nacimiento(f_nacimiento);
		System.out.println(dimeNombre(al));
				
		while(it.hasNext()){
			String key =  (String) it.next();
			try {
				System.out.println(key+": "+json1.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
*/
		
	} 
/**
 * 
 * @param Alumno al
 * @return nombreClase: nombreAlumno
 */
	public static String dimeNombre(Alumno al){
		String nombre = Main.class.getName();
		nombre = Main.class.getSimpleName();
		return nombre+": "+al.getNombre() ;
	}

}
