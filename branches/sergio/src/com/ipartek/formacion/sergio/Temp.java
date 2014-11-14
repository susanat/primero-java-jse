package com.ipartek.formacion.sergio;

import java.text.Collator;
import java.util.Locale;

import com.ipartek.formacion.sergio.utils.ClsUtilsConstantes;

public class Temp {

	public static void temp1(){
		System.out.println(ClsUtilsConstantes.SALTO_DE_LINEA);
		System.out.println("Locate dentro de Collactor: " + ClsUtilsConstantes.SALTO_DE_LINEA);
		for(Locale s : Collator.getAvailableLocales()){
			System.out.println(
					"Country		: " + s.getDisplayCountry() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.getCountry() + ClsUtilsConstantes.SALTO_DE_LINEA 
					+ "	ISO	: " + s.getISO3Country() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "Lengua		: " + s.getDisplayLanguage() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.getLanguage() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.toString() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "	ISO	: " + s.getISO3Language() + ClsUtilsConstantes.SALTO_DE_LINEA				
					);
		}
	}
	
}
