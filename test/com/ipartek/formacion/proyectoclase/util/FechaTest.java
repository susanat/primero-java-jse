package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
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
		String strHoycas = gc.DAY_OF_MONTH + "/" + Calendar.MONTH + "/"
				+ GregorianCalendar.YEAR;
		String strHoyeu = GregorianCalendar.YEAR + "/"
				+ GregorianCalendar.MONTH + "/"
				+ GregorianCalendar.DAY_OF_MONTH;

		assertEquals(strHoycas, strFechacas);
		assertEquals(strHoyeu, strFechaeu);

	}
}
