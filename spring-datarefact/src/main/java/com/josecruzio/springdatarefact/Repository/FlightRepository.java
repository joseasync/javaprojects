package com.josecruzio.springdatarefact.Repository;

import com.josecruzio.springdatarefact.Models.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginIgnoreCase(String origin); //toUpper

    List<Flight> findByOriginAndDestination(String origin, String destination);
    //select * from Flight where origin =@origin AND destination = @destination

    List<Flight> findByOriginIn(String ... origin);
    //select * from flight WHERE origin IN ()


}