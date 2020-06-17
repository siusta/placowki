package pl.siusta.places.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.siusta.places.model.Car;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findAllByPlaceId(Long placeId);
    List<Car> findAllByPlaceIdAndAvailable(Long placeId, Boolean available);
}
