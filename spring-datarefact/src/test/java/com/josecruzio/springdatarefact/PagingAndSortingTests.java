package com.josecruzio.springdatarefact;

import com.josecruzio.springdatarefact.Models.Flight;
import com.josecruzio.springdatarefact.Repository.FlightRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PagingAndSortingTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setUp(){
       flightRepository.deleteAll();
    }

    @Test
    public void shouldSortFlightsByDestination(){
        final Flight flight = createFlight("Madrid");
    }

    private Flight createFlight(String origin) {

        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination("Madrid");
        flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));
        return flight;
    }




}
