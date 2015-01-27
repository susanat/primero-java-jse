package ipartek.formacion.ejemplos.hibernate;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CursoTest {
    static Session s = null;
    static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	s = HibernateUtil.getSession();
	s.beginTransaction();
	// Crear nueva persona
	Curso c = new Curso();
	c.setNombre("Desarrollo Web");
	c.setCodigo("UF389");

	String sInicio = "11-09-2014";
	String sFin = "12-02-2015";
	c.setFechaFin(formato.parse(sFin));
	c.setFechaInicio(formato.parse(sInicio));

	s.save(c);

	Curso c2 = new Curso();
	c2.setNombre("Desarrollo en Android");
	c2.setCodigo("AN489");
	String sInicio2 = "05-10-2014";
	String sFin2 = "16-01-2015";
	c2.setFechaFin(formato.parse(sFin2));
	c2.setFechaInicio(formato.parse(sInicio2));

	s.save(c2);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	s.getTransaction().commit();
	s.close();

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInsert() throws Exception {
	Curso cur = new Curso();
	cur.setNombre("Java");
	cur.setCodigo("JA339");
	String sInicio = "11-11-2014";
	String sFin = "12-01-2015";
	cur.setFechaFin(formato.parse(sFin));
	cur.setFechaInicio(formato.parse(sInicio));

	// insertar en BBDD
	s.save(cur);

    }

}
