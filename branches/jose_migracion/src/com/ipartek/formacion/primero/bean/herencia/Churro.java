package com.ipartek.formacion.primero.bean.herencia;

/**
 * Tipos de churros
 *
 * @author Jose A. Perez
 *
 */
public class Churro implements Ordenable {
	// Atributos
	/**
	 *
	 */
	private float calorias;
	/**
	 *
	 */
	private char tipo;

	/**
	 * Diferentes tipos de churros
	 */
	public static final char CHOCOLATE = 'C';
	public static final char RELLENO = 'R';
	public static final char NORMAL = 'N';
	public static final char LIGHT = 'L';

	/**
	 * Calorias minimas y maximas que puede tener un churro
	 */
	public static final float MIN_CALORIAS = 0f;
	public static final float MAX_CALORIAS = 200f;

	// Constructor
	/**
	 * Crea un churro de un tipo con las minimas calorias
	 *
	 * @param tipo
	 *            <code>String</code> tipo de churro
	 */
	public Churro(char tipo) {
		super();
		setTipo(tipo);
		setCalorias(0f);
	}

	/**
	 * Crea un churro del tipo y la caloria expecificada
	 *
	 * @param calorias
	 *            <code>float</code> calorias que tiene el churro
	 * @param tipo
	 *            <code>String</code> tipo de churro
	 */
	public Churro(float calorias, char tipo) {
		super();
		setTipo(tipo);
		setCalorias(calorias);
	}

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		if (calorias < MIN_CALORIAS) {
			this.calorias = MIN_CALORIAS;
		} else {
			if (calorias > MAX_CALORIAS) {
				this.calorias = MAX_CALORIAS;
			} else {
				this.calorias = calorias;
			}
		}
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		switch (Character.toUpperCase(tipo)) {
		case CHOCOLATE:
		case RELLENO:
		case NORMAL:
		case LIGHT:
			this.tipo = Character.toUpperCase(tipo);
			break;
		default:
			this.tipo = NORMAL;
			break;
		}
	}

	// Metodos
	@Override
	public String toString() {
		return "Churro [calorias=" + calorias + ", tipo=" + tipo + "]";
	}

	// Metodos de la interfaz
	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return 0;
	}

}
