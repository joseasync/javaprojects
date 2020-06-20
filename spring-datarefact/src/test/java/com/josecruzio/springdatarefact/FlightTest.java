package com.josecruzio.springdatarefact;

        import com.josecruzio.springdatarefact.Models.Flight;
        import com.josecruzio.springdatarefact.Repository.FlightRepository;
        import org.junit.jupiter.api.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import javax.persistence.EntityManager;
        import javax.persistence.TypedQuery;
        import java.time.LocalDateTime;
        import java.util.List;

        import static org.assertj.core.api.Assertions.assertThat;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class FlightTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private FlightRepository repository;

    @Test
    public void testFindByName() {

        final Flight flight = new Flight();
        flight.setOrigin("Congonhas");
        flight.setDestination("Lisboa");
        flight.setSheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));

        entityManager.persist(flight);

        List<Flight> books = repository.findById(flight.getId());
        assertEquals(1, books.size());

        assertThat(books).extracting(Flight::getOrigin).containsOnly(flight.getOrigin());

    }


}
