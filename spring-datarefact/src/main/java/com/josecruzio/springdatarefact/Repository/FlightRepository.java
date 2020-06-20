package com.josecruzio.springdatarefact.Repository;

import com.josecruzio.springdatarefact.Models.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findById(long id);

}