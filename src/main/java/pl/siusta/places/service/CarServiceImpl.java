package pl.siusta.places.service;

import org.springframework.stereotype.Service;
import pl.siusta.places.model.Car;
import pl.siusta.places.repo.CarRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepo carRepo;

    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> getCarsInPlace(Long placeId) {
        Optional<List<Car>> carList = Optional.ofNullable(carRepo.findAllByPlaceId(placeId));
        return carList.get();
    }

    @Override
    public List<Car> getAvInPlace(Long placeId) {
        Optional<List<Car>> carList = Optional.ofNullable(carRepo.findAllByPlaceIdAndAvailable(placeId,true));
        return carList.get();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> car = carRepo.findById(id);
        return car.get();
    }

    @Override
    public boolean addCarToPlace(Long placeId, Long id) {
        carRepo.save( new Car(id,placeId,true));
        return true;
    }

    @Override
    public boolean deleteCar(Long id) {
        carRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean changeAvailability(Long id) {
        Car car = getCarById(id);
        if(car.getAvailable()){
            car.setAvailable(false);

        } else {
            car.setAvailable(true);
        }
        carRepo.save(car);
        return true;
    }
}
