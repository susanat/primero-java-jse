package com.ipartek.formacion.sergio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ipartek.formacion.sergio.utils.ClsUtilsUI;

public class ClsAlumno {

	/*
	 * TODO mirar lo de los logs:
	 * http://expertojava.ua.es/j2ee/publico/lja-2012-13/sesion06-apuntes.html
	 */

	// ////INICIO LOGICA DE LOS EVENTOS
	/**
	 * Interface de eventos del list view
	 * 
	 * @author baskito 2013/09/30
	 *
	 */
	public interface onAlumno {
		void onCargado(ClsAlumno obj);

		void onMostrado(ClsAlumno obj);
	}

	/**
	 * Array de listeners
	 *
	 * @version 30.09.2013
	 */
	private List<onAlumno> onAlumnoIListener = new ArrayList<onAlumno>();

	/**
	 * Función para añadir el listener
	 * 
	 * @param listener
	 *            listener a añadir
	 */
	public void setonListado(onAlumno listener) {
		onAlumnoIListener.add(listener);
	}

	/**
	 * Función para remover el lístener
	 * 
	 * @param listener
	 *            listener a remover
	 */
	public void removeonListado(onAlumno listener) {
		onAlumnoIListener.remove(listener);
	}

	/**
	 * Función que recorre el array de listener y los ejecuta
	 * 
	 * @param chk
	 *            checkBox del item
	 */
	private void onCargado(ClsAlumno obj) {
		for (onAlumno listener : onAlumnoIListener)
			listener.onCargado(obj);
	}

	private void onMostrado(ClsAlumno obj) {
		for (onAlumno listener : onAlumnoIListener)
			listener.onMostrado(obj);
	}

	// ////FIN LOGICA DE LOS EVENTOS

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String poblacion;
	private boolean mayoredad;
	private String telefono;
	private char sexo;
	private ArrayList<ClsLibro> arrayLibro = null;
	private ArrayList<ClsCalificacion> arrayCalificacion = null;

	public ClsAlumno() {

	}

	public ClsAlumno(String nombre, String apellido1, String apellido2,
			int edad, String dni, String poblacion, boolean mayoredad,
			String telefono, char sexo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.dni = dni;
		this.poblacion = poblacion;
		this.mayoredad = mayoredad;
		this.telefono = telefono;
		this.sexo = sexo;

		onCargado(this);
	}

	/**
	 * Función que añade una calificación al alumno
	 * 
	 * @param calificacion
	 *            ClsCalificacion
	 */
	public void addCalificacion(ClsCalificacion calificacion) {
		if (arrayCalificacion == null)
			arrayCalificacion = new ArrayList<ClsCalificacion>();

		arrayCalificacion.add(calificacion);
	}

	/**
	 * Función que optiene una calificación por su nombre
	 * 
	 * @param asignature
	 * @return ClsCalificacion o null si no existe
	 */
	public ClsCalificacion getCalificacionByAsignature(String asignature) {

		return checkIfExistCalificacion(asignature);

	}

	/**
	 * Elimina una calificación por su nombre
	 * 
	 * @param asignature
	 */
	public void removeCalificacion(String asignature) {

		ClsCalificacion obj = checkIfExistCalificacion(asignature);

		if (arrayCalificacion != null && obj != null)
			arrayCalificacion.remove(obj);

	}

	/**
	 * Elimina una calificación por su objeto
	 * 
	 * @param calificacion
	 */
	public void removeCalificacion(ClsCalificacion calificacion) {
		this.removeCalificacion(calificacion.getAsignatura());
	}

	/**
	 * Comprueba si existe una calificación
	 * 
	 * @param asignature
	 * @return
	 */
	private ClsCalificacion checkIfExistCalificacion(String asignature) {

		if (arrayCalificacion == null)
			return null;

		for (ClsCalificacion d : arrayCalificacion) {
			if (d.getAsignatura() != null
					&& d.getAsignatura().equalsIgnoreCase(asignature))
				return d;
		}

		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public boolean isMayoredad() {
		return mayoredad;
	}

	public void setMayoredad(boolean mayoredad) {
		this.mayoredad = mayoredad;
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

	@Override
	public String toString() {

		// ejecutamos el evento de mostrado (sin sentido, para guardar el
		// código)
		onMostrado(this);

		return "clsAlumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayoredad=" + mayoredad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClsAlumno other = (ClsAlumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public static void main(String[] args) {
		try {

			ClsAlumno objAlumno = new ClsAlumno("Sergio", "Apellido1",
					"Apellido2", 25, "23659857d", "Barakaldo", true,
					"6985654225", 'V');

			// le añadimos los eventos
			objAlumno.setonListado(new onAlumno() {

				@Override
				public void onMostrado(ClsAlumno obj) {
					ClsUtilsUI.mensajeError("No es de error",
							"El alumno será mostrado");
					System.out.println("Mostrado");
				}

				@Override
				public void onCargado(ClsAlumno obj) {
					ClsUtilsUI.mensajeError("No es de error",
							"El alumno ha sido cargado");
					System.out.println("Cargado");

				}
			});
			System.out.println("Ejercicio 1");
			System.out.println(objAlumno.toString());

		} catch (Exception ex) {

		}

	}

	/**
	 * Enumeración para los ordenamientos de las listas
	 *
	 *
	 */
	enum ObjetoComparator implements Comparator<ClsAlumno> {

		SORT_APELLIDO1 {
			public int compare(ClsAlumno o1, ClsAlumno o2) {
				return o1.getApellido1().compareTo(o2.getApellido1());
			}
		},
		SORT_NOMBRE {
			public int compare(ClsAlumno o1, ClsAlumno o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}
		},
		SORT_MAYOREDAD {
			public int compare(ClsAlumno o1, ClsAlumno o2) {
				Boolean uno = o1.isMayoredad();
				Boolean dos = o2.isMayoredad();
				return uno.compareTo(dos);
			}
		};

		/**
		 * Compara en orden descendente por tipo y luego por nombre
		 *
		 * @param other
		 * @return comparation
		 */
		public static Comparator<ClsAlumno> decending(
				final Comparator<ClsAlumno> other) {
			return new Comparator<ClsAlumno>() {
				public int compare(ClsAlumno o1, ClsAlumno o2) {
					return -1 * other.compare(o1, o2);
				}
			};
		}

		/**
		 * Compara en orden ascendendente por tipo y luego por nombre
		 *
		 * @param other
		 * @return comparation
		 */
		public static Comparator<ClsAlumno> ascending(
				final Comparator<ClsAlumno> other) {
			return new Comparator<ClsAlumno>() {
				public int compare(ClsAlumno o1, ClsAlumno o2) {
					return other.compare(o1, o2);
				}
			};
		}

		public static Comparator<ClsAlumno> getComparator(
				final ObjetoComparator... multipleOptions) {
			return new Comparator<ClsAlumno>() {
				public int compare(ClsAlumno o1, ClsAlumno o2) {
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
	}// fin enum

}
