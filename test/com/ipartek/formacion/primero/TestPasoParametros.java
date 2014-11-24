package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class TestPasoParametros {

    int parametroValor = 2;
    VehiculoElectrico parametroReferencia = new VehiculoElectrico();

    @Test
    public void testPasoParametroValor() {
	int resul = incrementar(parametroValor);
	assertEquals(2, parametroValor);
	assertEquals(3, resul);

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
	    vClon = (VehiculoElectrico) parametroReferencia.clone();
	    // Recordar que debemos implementar la interface Cloneable en la
	    // clase
	    // para poder
	    // clonar un objeto
	} catch (CloneNotSupportedException e) {
	    fail("No se pudo clonar");
	}

	incrementar(vClon);
	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(5, vClon.getNumPlazas());

    }

    // Crear 2 metodos para poder modificar los parametros

    // incrementar en uno
    int incrementar(int parametroValor) {
	parametroValor++;
	return parametroValor;
    }

    // incrementar el numero de plazas
    VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {
	parametroReferencia
		.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
	return parametroReferencia;
    }

}
