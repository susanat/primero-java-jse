package com.ipartek.formacion.primero.bean.herencia;

import com.ipartek.formacion.sergio.bd.Database;
import com.ipartek.formacion.sergio.bd.IDBEvents;

public class Linea extends Figura implements IRedimensionable {

	private int longitud;

	public Linea(int x, int y) {
		super(x, y);
		setLongitud(LONG_MIN);
	}

	public Linea(int x, int y, int longitud) {
		super(x, y);
		setLongitud(longitud);
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		Linea objLinea = new Linea(1, 1);

		Database objDatabase = new Database();
		objDatabase.addIDBEventListener(new IDBEvents() {
			@Override
			public void onExit() {

			}

			@Override
			public void onConnected() {
				System.out.println("Evento ejecutado");
			}
		});

		objDatabase.lanzarEvento();
	}
}