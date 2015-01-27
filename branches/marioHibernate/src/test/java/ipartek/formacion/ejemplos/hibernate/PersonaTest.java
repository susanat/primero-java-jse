package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
    static Session s = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	s = HibernateUtil.getSession();
	s.beginTransaction();
	// Crear nueva persona
	Persona p = new Persona();
	p.setNombre("dummy");
	p.setFechaNacimiento(new Date());
	p.setApellidos("foo bar");
	p.setEdad(18);

	// insertar en BBDD
	s.save(p);

	Persona p2 = new Persona();
	p2.setNombre("pepe");
	p2.setFechaNacimiento(new Date());
	p2.setApellidos("popo pipi");
	p2.setEdad(25);

	// insertar en BBDD
	s.save(p2);

	Persona p3 = new Persona();
	p3.setNombre("juana");
	p3.setFechaNacimiento(new Date());
	p3.setApellidos("de arco");
	p3.setEdad(32);

	// insertar en BBDD
	s.save(p3);

    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
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
    public void testInsert() {
	Persona p4 = new Persona();
	p4.setNombre("jojo");
	p4.setFechaNacimiento(new Date());
	p4.setApellidos("juju jiji");
	p4.setEdad(55);

	// insertar en BBDD
	s.save(p4);

	// segun guardamos tenemos el ID
	// assertTrue(4 == p4.getId());

    }

    @Test
    public void testGetAll() {
	List<Persona> personas = s.createQuery("from Persona ORDER BY edad")
		.list();

	assertEquals(18, personas.get(0).getEdad());
	assertEquals(25, personas.get(1).getEdad());
    }

    @Test
    public void testGetById() {

	// se castea en long el "id" porque en la clase Persona esta a "long" y
	// en la BBDD a "bigint"
	Persona p = (Persona) s.get(Persona.class, (long) 1);
	assertEquals("dummy", p.getNombre());
	assertEquals(18, p.getEdad());

    }

    @Test
    public void testDelete() {
	Persona pe = new Persona();
	pe.setNombre("fofo");

	// insertar en BBDD
	s.save(pe);
	long id = pe.getId();
	// segun guardamos tenemos el ID
	// assertTrue(4 == p4.getId());

	// obtener Persona by ID

	// eliminar persona pasando el objeto
	s.delete(pe);

	Persona eliminada = (Persona) s.get(Persona.class, id);
	assertNull(eliminada);

    }

    @Test
    public void testUpdate() {

	Persona pe = new Persona();
	pe.setNombre("fofo");

	// insertar en BBDD
	s.save(pe);
	long id = pe.getId();

	// modificamos el nombre de "Eliminar" a "Modificado"
	pe.setNombre("Modificado");
	s.update(pe);

	// recuperar de la BBDD para comprobar cambio de nombre
	Persona modificada = (Persona) s.get(Persona.class, id);

	assertEquals("Modificado", modificada.getNombre());
    }

}
