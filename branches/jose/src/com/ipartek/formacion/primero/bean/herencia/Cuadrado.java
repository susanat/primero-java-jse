/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Jose A. Perez
 *
 */
public class Cuadrado extends Figura implements Redimensionable{

	private int cara;		//longitud la cara del cuadrado
	
	
	
	public Cuadrado(Punto punto) {
		super(punto);
		setCara(LONG_MIN);
	}


	public Cuadrado(Punto punto, int cara){
		super(punto);
		setCara(cara);
	}

	public int getCara() {
		return cara;
	}



	public void setCara(int cara) {
		this.cara = cara;
	}



	/**
	 * dibuja un Cuadrado del tamaño de la cara
	 */
	@Override
	void dibujar() {
		int nCaraInterna=getCara()-1;
		
		// Filas
		for(int i=0; i<getCara(); i++){
			// Pintar Coordenada(0,y)
			System.out.print("+");
			// Columnas
			for (int j=1; j<nCaraInterna; j++){
				// Si es la primera Fila o la ultima
				if (i==0 || i == nCaraInterna){
					System.out.print("+");
				}else{
					System.out.print(" ");
				}
			}
			// Pintar Coordenada(n,y) 
			System.out.println("+");
		}
	}

}
