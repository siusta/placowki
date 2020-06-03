package pl.siusta.places;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.siusta.places.Place;
import pl.siusta.places.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceApi {

    private PlaceService placeService;

    @Autowired
    public PlaceApi(PlaceService placeService){
        this.placeService = placeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Place>> getAllPlaces(){
        List<Place>carList=placeService.getAllPlaces();
        if(!carList.isEmpty()) {return new ResponseEntity<>(carList, HttpStatus.FOUND);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id){
        Place place = placeService.getPlaceById(id);
        if(place != null) return new ResponseEntity<>(place,HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByName")
    public ResponseEntity<Place> getPlaceByName(@RequestParam String name){
        Place place = placeService.getPlaceByName(name);
        if(place != null) return new ResponseEntity<>(place,HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByCity")
    public ResponseEntity<List<Place>> getPlaceByCity(@RequestParam String city){
        List<Place> placeList = placeService.getPlaceByCity(city);
        if(placeList.isEmpty()) return new ResponseEntity<>(placeList,HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity addPlace(@RequestBody Place newPlace){
        if(placeService.addPlace(newPlace)) return new ResponseEntity(HttpStatus.CREATED);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlace(@PathVariable Long id){
       if(placeService.deletePlace(id))return new ResponseEntity(HttpStatus.OK);
       else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editAllCars/{id}/{allCars}")
    public ResponseEntity  editAllCars(@PathVariable Long id,@PathVariable int allCars){
        if(placeService.editAllCars(id,allCars))return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editAvailable/{id}/{availableCars}")
    public ResponseEntity editAviableCars(@PathVariable Long id,@PathVariable int availableCars){
        if(placeService.editAvailableCars(id,availableCars))return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editPlace/{id}")
    public @ResponseBody ResponseEntity  editPlace(@PathVariable Long id, @RequestBody Place place){
        if(placeService.editPlace(id,place))return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
