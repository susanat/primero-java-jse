package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DadoTest {
	private static final int NTIRADAS = 10000;
	private static final int TIRADAMIN = 0;
	private static final int TIRADAMAX = Dado.ALUMNOS.length;
	private static HashSet<String> validados;
	private static TreeSet<String> ordValidados;
	private static HashMap<String, Boolean> valTiradas;
	private static HashMap<String, Integer> controlTiradas;
	private static HashSet<String> controls;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		initListas();
	}

	private void initListas() {
		validados = new HashSet<String>();
		controls = new HashSet<String>();
		valTiradas = new HashMap<String, Boolean>();
		controlTiradas = new HashMap<String, Integer>();
		ordValidados = new TreeSet<String>();
		for (int i = 0; i < TIRADAMAX; i++) {
			valTiradas.put(Dado.ALUMNOS[i], false);
			controlTiradas.put(Dado.ALUMNOS[i], 0);
			controls.add(Dado.ALUMNOS[i]);
			ordValidados.add(Dado.ALUMNOS[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTirar() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetTirada() {
		int tirada = -1;
		String msg = null;
		String alum = null;
		for (int i = 0; i < NTIRADAS; i++) {
			tirada = Dado.getTirada();
			alum = Dado.ALUMNOS[tirada];
			msg = "La tirada ha sido " + tirada + " y tiene que estar entre "
					+ TIRADAMIN + " y " + TIRADAMAX;
			assertTrue(msg, tirada >= TIRADAMIN && tirada <= TIRADAMAX);
			validados.add(alum);
			valTiradas.put(alum, true);
			controlTiradas.put(alum, controlTiradas.get(alum) + 1);
		}
		assertEquals("", controls, validados);
		Arrays.sort(Dado.ALUMNOS);
		assertArrayEquals("", Dado.ALUMNOS, ordValidados.toArray());
		mostrarEstadisticas();

	}

	/**
	 * Muestra por pantalla la lista de participantes y número de veces elegidos
	 * 
	 * ej:
	 * <table>
	 * <thead>
	 * </thead>
	 * <tfoot>
	 * </tfoot>
	 * </table>
	 * --------------------------------------
	 * Participante      |  	Tiradas
	 * --------------------------------------
	 * Susana						12
	 * Zuahitz					 1.112
	 * .......................................
	 */
	private static void mostrarEstadisticas() {
		final char LINE ='-';
		final int ESPACE=20;
		for(int i = 0; i < ESPACE; i++){
			System.out.println("-");
		}
		for (Map.Entry<String, Integer> entry : controlTiradas.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println(key + ": " + value);
		}
	}
}
