package com.josecruzio.springdatarefact;

import com.josecruzio.springdatarefact.Models.Flight;
import com.josecruzio.springdatarefact.Repository.FlightRepository;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightCrudTest {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void shouldperformCrudOpertaitons(){

		final Flight flight = new Flight();
		flight.setOrigin("Congonhas");
		flight.setDestination("Lisboa");
		flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));

		//Create
		flightRepository.save(flight);
		assertThat(flightRepository.findAll())
				.hasSize(1)
				.first()
				.isEqualToComparingFieldByField(flight);

		//Delete
		//flightRepository.deleteById(flight.getId());
		//assertThat(flightRepository.count()).isZero();
	}

	private Flight createFlight(String origin) {

		final Flight flight = new Flight();
		flight.setOrigin(origin);
		flight.setDestination("Madrid");
		flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));
		return flight;
	}

}
