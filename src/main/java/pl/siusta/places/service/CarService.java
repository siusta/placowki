package pl.siusta.places.service;

import org.springframework.stereotype.Service;
import pl.siusta.places.model.Car;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCars();
    List<Car> getCarsInPlace(Long placeId);
    List<Car> getAvInPlace(Long placeId);
    boolean addCarToPlace(Long placeId, Long id);
    boolean deleteCar(Long id);
    boolean changeAvailability(Long id);
}
