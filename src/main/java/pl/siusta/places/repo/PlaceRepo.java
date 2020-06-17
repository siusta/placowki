package pl.siusta.places.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.siusta.places.model.Place;

import java.util.List;


@Repository
public interface PlaceRepo extends JpaRepository<Place, Long> {
    Place findByName(String name);
    List<Place> findAllByCity(String city);
}
