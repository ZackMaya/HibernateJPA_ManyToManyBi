package mx.edu.uacm.primerproyectohbm.test.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.primerproyectohbm.HibernateJpaManyToManyBiApplication;
import mx.edu.uacm.primerproyectohbm.domain.Address;
import mx.edu.uacm.primerproyectohbm.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HibernateJpaManyToManyBiApplication.class)
public class PersonTest {

	@PersistenceContext
	protected EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersona() {

		// Vamos a crear dos direcciones
		// Vamos a crear a dos personas
		// La persona1 tendra 2 direcciones
		// La persona2 tendra 1 direccion

		Person person1 = new Person("37356");
		Person person2 = new Person("4565");

		Address address1 = new Address("STL", "0800","9633");
		Address address2 = new Address("Av. del Arbol", "0700","05621");

		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);
		person2.getAddresses().add(address1);
		
		entityManager.persist(person1);
		entityManager.persist(person2);
		
		//person1.removeAddress(address1);
		
		entityManager.flush();		
		
	}

}
