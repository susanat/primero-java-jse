package com.ipartek.ejercicio.migracion;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.aeat.valida.Validador;
import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsNumeros;

public class Validations {

    
    /**
     * Check if number of fields is expected
     * @param line
     * @return
     */
    public static eErrorCause isValidNumberFields(final String line, int numberFields){
	
	eErrorCause errorCause = null;
	
	String[] splited = line.split(Constantes.STR_SEPARATOR);
	
	if(splited.length < numberFields){
	    errorCause = eErrorCause.MIN_FIELDS;
	}else if(splited.length > numberFields){
	    errorCause = eErrorCause.MAX_FIELDS;
	}
	
	return errorCause;
    }
    
    /**
     * Check duplicated lines.
     * 
     * <br>It is a duplicate line if they have the same dni
     * 
     * <br>Omited:
     * <br> - error in numbers of fields
     * <br> - error in DNI number
     * 
     * @return Map with duplicated lines group by key DNI
     */
    public static HashMap<String, List<String>> checkDuplicated(HashMap<eErrorCause, List<String>> agrupedLinesByError ){
	//condiciones:
	//Omitir: lista de números de campos max o menos
	//Omitir: dni incorrecto
	
	return null;
	
	
	
    }
    
    
    /**
     * Check valid email
     * 
     * <br>Need library valnif.jar
     * 
     * @see 
     *      https://amatellanes.wordpress.com/2013/07/30/java-validar-dni-nie-o-cif
     *      -en-java/
     * @see 
     *      https://www.agenciatributaria.es/AEAT.desarrolladores/Desarrolladores/
     *      Descarga_de_modulos/Descarga_de_modulos.html
     * @param dni String with dni format: (00000000X)
     * @return false if not valid format, true if ok
     */
    public static boolean isValidDNI(String dni) {

	Validador validador = new Validador();
	int e = validador.checkNif(dni);

	if (e > 0)
	    return true;
	else
	    return false;

    }
    
    /**
     * Validate if a UTF-8 string contains mal-encoded characters
     * 
     * @param input Text to check     
     * @return boolean false if has error, true if not 
     */
    public static boolean isUTF8MisInterpreted( String input ) {
	//convenience overload for the most common UTF-8 misinterpretation
	//which is also the case in your question
	return isUTF8MisInterpreted( input, "UTF-8");  
    }

    /**
     * Validate if a UTF-8 string contains mal-encoded characters
     * 
     * @param input Text to check
     * @param encoding Type of encoding based
     * @return boolean false if has error, true if not 
     */
    public static boolean isUTF8MisInterpreted( String input, String encoding) {

	CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
	CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
	ByteBuffer tmp;
	try {
	    tmp = encoder.encode(CharBuffer.wrap(input));
	}

	catch(CharacterCodingException e) {
	    return false;
	}

	try {
	    decoder.decode(tmp);
	    return true;
	}
	catch(CharacterCodingException e){
	    return false;
	}       
    }
    
    /**
     * Check if edad if correct.
     * 
     *<br> - Check if is a number
     *<br> - Check if is lower that min number and bigger that max number
     * 
     * @param edad String with edad;
     * @return True if is correct, false if not
     * 
     * @throws NumberFormatException number format exceptions
     */
    public static boolean isValidEdad(String edad) 
	    throws NumberFormatException{
	
	if(!ClsUtilsNumeros.isNumeric(edad)){
	    throw new NumberFormatException();
	}
	
	int numberEdad = Integer.valueOf(edad);
	
	if(numberEdad < Constantes.MIN_EDAD || numberEdad > Constantes.MAX_EDAD){
	    return false;
	}
	
	return true;
	
    }
    
    /**
     * Check for valid email
     * 
     * Need library javax.mail.jar
     * 
     * @see https://java.net/projects/javamail/pages/Home
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
	boolean isValid = false;
	try {
		//
		// Create InternetAddress object and validated the supplied
		// address which is this case is an email address.
		InternetAddress internetAddress = new InternetAddress(email);
		internetAddress.validate();
		isValid = true;
	} catch (AddressException e) {
		System.out.println("You are in catch block -- Exception Occurred for: " + email);
	}
	
	return isValid;
    }

}
