package com.ipartek.formacion.pruebas;


/**
 * Objeto para calcular las vueltas de un cobro de forma mas optima posible
 * 
 *OJO!!  El que funciona es Calculadora.java
 * 
 * @author Susana Costoya
 *
 */

public class CalcularVueltas {
	
	/**
	 * Precio de la compra // valdria 0f
	 */
	float precio;
	
	/**
	 * Pago realiazo o dinero entregado
	 */
	
	float pago;
	
	/**
	 * Array con las vueltas
	 */
	int[] aVueltas;
	
	/**
	 *Array con tipos de monedas y billetes
	 *<ul>
	 *	<li>billete 50€</li> 
	 *	<li>billete 20€</li> 
	 *	<li>billete 10€</li> 
	 *	<li>billete 5€</li> 
	 *	<li>moneda 2€</li> 
	 *	<li>moneda 1€</li> 
	 *	<li>etc...</li>
	 *</ul>
	 * Final que no se modificar por es en mayuscula y con _ // es una constante
	 * 
	 * Static conparten atributo entre todas y esta en memoria una sola vez para ahorrar espacio
	 */
	
	public static final float[] BILLETES_MONEDAS= {50f, 20f, 10f, 5f, 2f, 1f, 0.50f, 0.20f, 0.10f, 0.05f, 0.02f, 0.01f};
	
	/**
	 * Valor en euros del billete de menor tamaño
	 */
	static final int BILLETE_MINIMO = 5;
	
	//Constructor - siempre con super(); absciende de la case primaria object
	public CalcularVueltas(){
		super();
		this.pago = 0;
		this.precio = 0;
		this.aVueltas = new int [BILLETES_MONEDAS.length];
	} 
	
	/**
	 * Obtener las vueltas calculadas
	 * @return{@code array} de {@code int} con las vueltas
	 * @see: para saber el valor usar variable BILLETES_MONEDAS
	 */
	public int[] getVueltas() {
		return aVueltas;
	}

	/**
	 * Calcula las vueltas de forma optima para retornar los minimo billetes
	 * @param pago float dinero entregado o pagado
	 * @param precio {@code float} precio a cobrar
	 * con this hacemos referencia al atributo y con (float pago) al parametro
	 */
	private void calcular(float pago, float precio) {
		this.pago = pago;
		this.precio = precio;
		float resto = this.pago - this.precio;
		
		for (int i = 0; i < aVueltas.length; i++) {
			aVueltas[i] = (int) (resto / BILLETES_MONEDAS[i]);
			resto %= BILLETES_MONEDAS[i];			
		}
			
	}
		
	
	
	/**
	 * Imprime por pantalla las vueltas del cobro
	 */
	
	void imprimirVueltas(){
		System.out.println("Lo que nos tiene que devolver es " + (this.pago - this.precio) + "€");
		String imprimir="";
		for (int i = 0; i < aVueltas.length; i++) {
			System.out.println( aVueltas[i]);
			
			imprimir = aVueltas[i] + " ";
			if( BILLETE_MINIMO <= BILLETES_MONEDAS[i]){
				imprimir += "Billetes " + (int)BILLETES_MONEDAS[i] + "€";
			}else{
				imprimir += "Monedas" + (int)BILLETES_MONEDAS[i] + "€";
			}
			
			System.out.print( imprimir );
			
		}
	}
	
	

	public static void main(String[] args) {
		
		CalcularVueltas calc = new CalcularVueltas();
		calc.calcular(2000f, 1326.24f);
		calc.imprimirVueltas();
		
		
		
		// Declaramos las variable que sabemos
		/*float pagado = 2000;
		float precio = 1326.24f;
		float vueltas = pagado - precio;
		
		System.out.println("Lo que nos tiene que devolver es " + vueltas + "€");
		Calculamos cuantos billetes de 50 nos devulelve 
		System.out.println("Nos devuelven " + (int) vueltas/50 +  " billetes de 50€ ");
		Aqui calculamos el resto que queda en vueltas
		vueltas %= 50;
		System.out.println("Nos devuelven " + (int) vueltas/20 +  " billetes de 20€ ");
		vueltas %= 20;
		System.out.println("Nos devuelven " + (int) vueltas/10 + " billetes de 10€ ");
		vueltas %= 10;
		System.out.println("Nos devuelven " + (int) vueltas/5 + " billetes de 5€");
		vueltas %= 5;
		System.out.println("Nos devuelven " + (int) vueltas/2 + " monedas de 2€");
		vueltas %= 2;
		System.out.println("Nos devuelven " + (int) vueltas/1 + " monedas de 1€");
		vueltas %= 1;
				//multiplicamos *100 para trabajar con centimos
		vueltas *=100;
		System.out.println("Nos devuelven " + (int) vueltas/50 + " monedas de 50 centimos");
		vueltas %=50;
		System.out.println("Nos devuelven " + (int) vueltas/20 + " monedas de 20 centimos");
		vueltas %=20;
		System.out.println("Nos devuelven " + (int) vueltas/10 + " monedas de 10 centimos");
		vueltas %=10;
		System.out.println("Nos devuelven " + (int) vueltas/5 + " monedas de 5 centimos");
		vueltas %=5;
		System.out.println("Nos devuelven " + (int) vueltas/2 + " monedas de 2 centimos");
		vueltas %=2;
		System.out.println("Nos devuelven " + (int) vueltas/1 + " monedas de 1 centimos");
		vueltas %=1;*/
		}

	

}
