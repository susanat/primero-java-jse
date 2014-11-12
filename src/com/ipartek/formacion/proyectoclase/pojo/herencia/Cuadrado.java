package com.ipartek.formacion.proyectoclase.pojo.herencia;

public class Cuadrado extends Figura implements IRedimensionable {
	/**
	 *
	 */
	private Integer lado;

	/**
	 *
	 * @param p
	 */
	public Cuadrado() {
		super();
		setLado(IRedimensionable.LONG_MIN);
	}

	public Cuadrado(Punto p) {
		super(p);
		// TODO Auto-generated constructor stub
		setLado(IRedimensionable.LONG_MIN);
	}

	/**
	 *
	 * @param p
	 * @param lado
	 */
	public Cuadrado(Punto p, Integer lado) {
		super(p);
		this.lado = lado;
	}

	/**
	 *
	 * @return
	 */
	public Integer getLado() {
		return lado;
	}

	/**
	 *
	 * @param lado
	 */
	public void setLado(Integer lado) {
		this.lado = lado;
	}

	/**
	 *
	 */
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		lVertical();
		for (int i = 0; i < this.lado - 2; i++) {
			lHorizontal();
		}

		lVertical();
	}

	/**
	 *
	 */
	private void lVertical() {
		System.out.print("-");
		for (int i = 0; i < this.lado - 1; i++) {
			System.out.print("-");
		}
		System.out.println("-");
	}

	/**
	 *
	 */
	private void lHorizontal() {

		System.out.print("|");
		for (int i = 0; i < this.lado - 1; i++) {
			System.out.print(" ");
		}
		System.out.println("|");

	}

}
