package pl.siusta.places.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.siusta.places.service.CarService;
import pl.siusta.places.model.Car;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/places/cars")
public class CarApi {
    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllCars(){
        List<Car>carList=carService.getAllCars();
        return carList;
    }

    @GetMapping("/all/{placeId}")
    public List<Car> getCarsInPlace(@PathVariable Long placeId){
        List<Car>carList=carService.getCarsInPlace(placeId);
        return carList;
    }

    @GetMapping("/available/{placeId}")
    public List<Car> getAvCarsInPlace(@PathVariable Long placeId){
        List<Car>carList=carService.getAvInPlace(placeId);
        return carList;
    }

    @PostMapping("/addCarToPlace/{placeId}/{carId}")
    public void addCar(@PathVariable Long placeId, @PathVariable Long carId){
        carService.addCarToPlace(placeId, carId);
    }

    @PutMapping("/changeStatus/{carId}")
    public void changeStatus(@PathVariable Long carId){
        carService.changeAvailability(carId);
    }

    @DeleteMapping("/delete/{carId}")
    public void deleteCar(@PathVariable Long carId){
        carService.deleteCar(carId);
    }

}
