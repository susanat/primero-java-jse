package com.ipartek.formacion.proyectoclase.pojo.herencia;

public class VehiculoElectrico extends Vehiculo {

	private Double capaBateria; 
	/**
	 * 
	 */
	public static final double MIN_CAP_BATERIA = 0.0;
	public static final double MIN_POTENCIA = 150.0;
	
	public VehiculoElectrico() {
		super();
		// TODO Auto-generated constructor stub
		this.setCapaBateria(VehiculoElectrico.MIN_CAP_BATERIA);
		this.setPotencia(VehiculoElectrico.MIN_POTENCIA);
	}
	
	
	@Override
	public void setPotencia(Double potencia) {
		super.setPotencia(potencia);
		
	};
	@Override
	public String toString() {
		return "VehiculoElectrico [capaBateria=" + capaBateria + ", numPlazas="
				+ numPlazas + ", dim=" + dim + ", potencia=" + potencia + "]";
	}
	public Double getCapaBateria() {
		return capaBateria;
	}
	public void setCapaBateria(Double capaBateria) {
		if(capaBateria>=MIN_CAP_BATERIA)
			this.capaBateria = capaBateria;
	}
	
	
	
	
	
}
