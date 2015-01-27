package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

    @Test
    public void test() {
	Session session = HibernateUtil.getSession();

	session.close();
	assertTrue("No se ha podido obtener session de Hibernate", true);

    }

}
