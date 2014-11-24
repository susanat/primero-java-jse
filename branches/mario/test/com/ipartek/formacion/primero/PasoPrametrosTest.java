package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoPrametrosTest {

    int parametroValor = 2;
    VehiculoElectrico parametroReferencia = new VehiculoElectrico();

    @Test
    public void testPasoParametroValor() {

	int result = incrementar(parametroValor);
	assertEquals(2, parametroValor);
	assertEquals(3, result);

    }

    @Test
    public void testPasoParametroReferencia() {
	incrementar(parametroReferencia);
	assertEquals(3, parametroReferencia.getNumPlazas());

	VehiculoElectrico vCopia = parametroReferencia;
	incrementar(vCopia);

	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(4, vCopia.getNumPlazas());

	VehiculoElectrico vClon = null;
	try {
	    // Recordar que debemos implementar la interfaz Cloneable en la
	    // clase que se quiere clonar
	    vClon = parametroReferencia.clone();
	} catch (CloneNotSupportedException e) {
	    fail("No se puede clonar ");
	}
	incrementar(vClon);
	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(5, vClon.getNumPlazas());
    }

    // Crear dos metros para poder modificar los parametros

    // incrementar en uno de 2 a 3
    int incrementar(int parametroValor) {
	parametroValor++;

	return parametroValor;
    }

    // incrementar el numero de puertas de 2 a 3
    VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {

	parametroReferencia
	.setNumPlazas(parametroReferencia.getNumPlazas() + 1);

	return parametroReferencia;
    }

}
