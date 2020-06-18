package pl.siusta.places.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.siusta.places.service.PlaceService;
import pl.siusta.places.model.Place;

import java.util.List;

@CrossOrigin
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
        List<Place>placeList=placeService.getAllPlaces();
        if(!placeList.isEmpty()) {return new ResponseEntity<>(placeList, HttpStatus.FOUND);}
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
        if(!placeList.isEmpty()) return new ResponseEntity<>(placeList,HttpStatus.FOUND);
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

    @PutMapping("/editPlace/{id}")
    public @ResponseBody ResponseEntity  editPlace(@PathVariable Long id, @RequestBody Place place){
        if(placeService.editPlace(id,place))return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
