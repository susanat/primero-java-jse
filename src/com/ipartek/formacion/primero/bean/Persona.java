package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;



/**
 * Clase para reprensentar un Alumno, se compone de:
 * <ol>
 * 	<li>nombre {@code String} obligatorio</li>
 * </ol>
 * 
 * 
 * @author Ander Uraga Real
 *
 */
public class Persona {
	
	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';
	
	public static final int MAYOR_EDAD = 18;
	
	public static final int MAX_EDAD = 99;
	public static final int MIN_EDAD = 18;
	
	public static final String NOMBRE_NULO = "undefined";
	
	public static final int STRING_MAYOR_QUE = 2;
	
	
	// Atributos
	private String nombre = NOMBRE_NULO;
	private String apellido1 = NOMBRE_NULO;
	private String apellido2 = NOMBRE_NULO;
	private int edad = 0;
	private String dni = NOMBRE_NULO;
	private String poblacion = NOMBRE_NULO;
	private boolean mayorEdad = false;
	private String telefono = NOMBRE_NULO;
	private char sexo = SEXO_OTROS;	
	private ArrayList<Libro> libros = null;
	
	
	// Constructor
	public Persona() {
		super();
		
	}
	
	public Persona(String nombre, int edad) throws PersonaException
	{
		this.setNombre(nombre);
		this.setEdad(edad);
		
	}
	
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if(nombre == null || nombre.length() <= Persona.STRING_MAYOR_QUE){
			throw new PersonaException(PersonaException.MSG_STRING_CORTO, PersonaException.COD_STRING_CORTO);
		}
				
		this.nombre = nombre;
	}

	public String getApellido1() {		
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if(apellido1 == null || apellido1.length() <= Persona.STRING_MAYOR_QUE){
			throw new PersonaException(PersonaException.MSG_STRING_CORTO, PersonaException.COD_STRING_CORTO);
		}
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if(apellido1 == null || apellido2.length() <= Persona.STRING_MAYOR_QUE){
			throw new PersonaException(PersonaException.MSG_STRING_CORTO, PersonaException.COD_STRING_CORTO);
		}
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if(edad < Persona.MIN_EDAD || edad > Persona.MAX_EDAD){
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA, PersonaException.COD_EDAD_NO_VALIDA);			
		}
		
		
		this.edad = edad;
		this.mayorEdad = (this.edad>=MAYOR_EDAD)? true: false;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	
	// Metodos
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}
	
	/**
	 * Enumeración para los ordenamientos de las listas
	 *
	 *
	 */
	enum ObjetoComparator implements Comparator<Persona> {		
		
		SORT_NOMBRE {
			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}
		},	
		SORT_NOMBRE_IGNORE_CASE {
			@Override
			public int compare(Persona o1, Persona o2) {				
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		},
		SORT_NOMBRE_COLLATOR {
			@Override
			public int compare(Persona o1, Persona o2) {
				//Usar Collator.IDENTICAL para que no ignore mayusculas y minúsculas
				//usar Collactor.PRIMARY para ignorar mayúsculas y minúsculas
				Locale locale = Locale.getDefault();
				Collator coll = Collator.getInstance(locale);
				coll.setStrength(Collator.PRIMARY); // thanks to @BheshGurung for reminding me						
				
				return coll.compare(o1.getNombre(), o2.getNombre());
			}
		},
		SORT_NOMBRE_LOCALE {
			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		},
		SORT_EDAD {
			public int compare(Persona o1, Persona o2) {
				return Integer.compare(o1.getEdad(), o2.getEdad());
			}
		};
		
		
		/**
		 * Compara en orden descendente
		 *
		 * @param objCompare Objeto compare
		 * @return
		 */
		public static Comparator<Persona> decending(final Comparator<Persona> objCompare) {
			return new Comparator<Persona>() {
				public int compare(Persona o1, Persona o2) {
					return -1 * objCompare.compare(o1, o2);
				}
			};
		}

		/**
		 * Compara en orden ascendendente
		 *
		 * @param other
		 * @return
		 */
		public static Comparator<Persona> ascending(final Comparator<Persona> objCompare) {
			return new Comparator<Persona>() {
				public int compare(Persona o1, Persona o2) {
					return objCompare.compare(o1, o2);
				}
			};
		}

		public static Comparator<Persona> getComparator(final ObjetoComparator... multipleOptions) {
			return new Comparator<Persona>() {
				public int compare(Persona o1, Persona o2) {
					for (ObjetoComparator option : multipleOptions) {
						int result = option.compare(o1, o2);
						if (result != 0) {
							return result;
						}
					}
					return 0;
				}
			};
		}
	}//fin enum
	
	

}
