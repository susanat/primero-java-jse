package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.proyectoclase.pojo.Fecha;

public class FechaTest {
	GregorianCalendar gc;
	SimpleDateFormat fmt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fmt = new SimpleDateFormat("MMM");
		gc = new GregorianCalendar();

		gc.setTime(new Date());
	}

	@After
	public void tearDown() throws Exception {
		gc = null;
	}

	@Test
	public void testFecha() throws Exception {
		String strFechacas = Fecha.getString(gc, Idioma.CASTELLANO);

		String strFechaeu = Fecha.getString(gc, Idioma.EUSKERA);
		String strHoycas = gc.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ (gc.get(GregorianCalendar.MONTH) + 1) + "/"
				+ gc.get(GregorianCalendar.YEAR);
		String strHoyeu = gc.get(GregorianCalendar.YEAR) + "/"
				+ (gc.get(GregorianCalendar.MONTH) + 1) + "/"
				+ gc.get(GregorianCalendar.DAY_OF_MONTH);

		assertEquals(strHoycas, strFechacas);
		assertEquals(strHoyeu, strFechaeu);

		gc.set(GregorianCalendar.MONTH, 02);
		strFechacas = Fecha.getString(gc, Idioma.CASTELLANO);

		strFechaeu = Fecha.getString(gc, Idioma.EUSKERA);
		strHoycas = gc.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ (gc.get(GregorianCalendar.MONTH) + 1) + "/"
				+ gc.get(GregorianCalendar.YEAR);
		strHoyeu = gc.get(GregorianCalendar.YEAR) + "/"
				+ (gc.get(GregorianCalendar.MONTH) + 1) + "/"
				+ gc.get(GregorianCalendar.DAY_OF_MONTH);

		assertEquals(strHoycas, strFechacas);
		assertEquals(strHoyeu, strFechaeu);

	}
}
