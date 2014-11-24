package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoParametrosTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    int parametroValor = 2;
    VehiculoElectrico parametroReferencia = new VehiculoElectrico();
    
    
    @Test
    public void testPasoParametroValor() {
	incrementar(parametroValor);
	assertEquals(2, parametroValor);
	
	int result = incrementar(parametroValor);
	assertEquals(3, result);
    }
    
    @Test
    public void testPasoParametroReferencia() {
	incrementar(parametroReferencia);
	assertEquals(32,parametroReferencia.getNumPlazas());
    }

    //métodos de apoyo a los test de valor y referencia
    
    //incrementa en uno el valor pasado
    private int incrementar(int parametroValor) {
	parametroValor++;
	return parametroValor;
    }
    
    //incrementar el número de puertas a 32 (defecto 2)
    private VehiculoElectrico incrementar(
	    VehiculoElectrico parametroReferencia) {
	parametroReferencia.setNumPlazas(32);
	return parametroReferencia;
    }
    
}
