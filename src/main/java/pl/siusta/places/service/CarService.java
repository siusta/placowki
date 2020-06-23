package pl.siusta.places.service;

import pl.siusta.places.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    List<Car> getCarsInPlace(Long placeId);
    List<Car> getAvInPlace(Long placeId);
    Car getCarById(Long id);
    boolean addCarToPlace(Long placeId, Long id);
    boolean deleteCar(Long id);
    boolean changeAvailability(Long id);
    Car testCar();
}
