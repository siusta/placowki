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
        if(!carList.isEmpty()) {return new ResponseEntity<>(carList, HttpStatus.ACCEPTED);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getById/{id}")
    public Place getPlaceById(@PathVariable Long id){
        Place place = placeService.getPlaceById(id);
        if(place != null) return place;
        else return null;
    }

    @GetMapping("/getByName")
    public Place getPlaceByName(@RequestParam String name){
        Place place = placeService.getPlaceByName(name);
        if(place != null) return place;
        else return null;
    }

    @GetMapping("/getByCity")
    public List<Place> getPlaceByCity(@RequestParam String city){
        List<Place> placeList = placeService.getPlaceByCity(city);
        if(placeList.isEmpty()) return null;
        else return placeList;
    }

    @PostMapping("/add")
    public void addPlace(@RequestBody Place newPlace){
        placeService.addPlace(newPlace);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlace(@PathVariable Long id){
        placeService.deletePlace(id);
    }


}
