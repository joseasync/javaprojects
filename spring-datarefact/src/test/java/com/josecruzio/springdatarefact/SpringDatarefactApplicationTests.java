package com.josecruzio.springdatarefact;

import com.josecruzio.springdatarefact.Models.Flight;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class SpringDatarefactApplicationTests {

	@Autowired
	private EntityManager entityManager;


	@Test
	void verifyFlyCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Congonhas");
		flight.setDestination("Lisboa");
		flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));

		entityManager.persist(flight);

		final TypedQuery<Flight> result = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);

		final List<Flight> resultList = result.getResultList();

		assertThat(resultList)
				.hasSize(1)
				.first()
				.isEqualTo(flight);
	}

}
