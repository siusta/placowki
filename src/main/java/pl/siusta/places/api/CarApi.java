package pl.siusta.places.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.siusta.places.service.CarService;
import pl.siusta.places.model.Car;

import java.util.List;

@RestController
@RequestMapping("/places/cars")
public class CarApi {
    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car>carList=carService.getAllCars();
        if(!carList.isEmpty()) {return new ResponseEntity<>(carList, HttpStatus.FOUND);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all/{placeId}")
    public ResponseEntity<List<Car>> getCarsInPlace(@PathVariable Long placeId){
        List<Car>carList=carService.getCarsInPlace(placeId);
        if(!carList.isEmpty()) {return new ResponseEntity<>(carList, HttpStatus.FOUND);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/available/{placeId}")
    public ResponseEntity<List<Car>> getAvCarsInPlace(@PathVariable Long placeId){
        List<Car>carList=carService.getAvInPlace(placeId);
        if(!carList.isEmpty()) {return new ResponseEntity<>(carList, HttpStatus.FOUND);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCarToPlace/{placeId}/{carId}")
    public ResponseEntity addCar(@PathVariable Long placeId, @PathVariable Long carId){
        if(carService.addCarToPlace(placeId, carId)) return new ResponseEntity(HttpStatus.CREATED);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/changeStatus/{carId}")
    public ResponseEntity changeStatus(@PathVariable Long carId){
        if(carService.changeAvailability(carId)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{carId}")
    public ResponseEntity deleteCar(@PathVariable Long carId){
        if(carService.deleteCar(carId)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
