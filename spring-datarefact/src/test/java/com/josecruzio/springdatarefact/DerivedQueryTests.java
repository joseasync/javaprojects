package com.josecruzio.springdatarefact;

import com.josecruzio.springdatarefact.Models.Flight;
import com.josecruzio.springdatarefact.Repository.FlightRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest //faz o request de um DB embedded
@AutoConfigureTestDatabase(replace = NONE)
public class DerivedQueryTests {
    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setUp(){
        //flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromLondon(){

        List<Flight> xpto = flightRepository.findByOrigin("Brasilia");




        final Flight flight1 = createFlight("London");
        final Flight flight2 = createFlight("London");
        final Flight flight3 = createFlight("New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);


        List<Flight> flightToLondon = flightRepository.findByOrigin("London");

        List<Flight> flightsFromNewYtoMadrid = flightRepository.findByOriginAndDestination("New York", "Madrid");


        assertThat(flightsFromNewYtoMadrid).hasSize(1);
        assertThat(flightsFromNewYtoMadrid.get(0)).isEqualToComparingFieldByField(flight3);

        assertThat(flightToLondon).hasSize(2);
        assertThat(flightToLondon.get(0)).isEqualToComparingFieldByField(flight1);
        assertThat(flightToLondon.get(1)).isEqualToComparingFieldByField(flight2);

    }

    private Flight createFlight(String origin) {

        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination("Madrid");
        flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));
        return flight;
    }

}
