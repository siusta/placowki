package pl.siusta.places.api;


import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Place> getAllPlaces(){
        List<Place>placeList=placeService.getAllPlaces();
        return placeList;
    }

    @GetMapping("/getById/{id}")
    public Place getPlaceById(@PathVariable Long id){
        Place place = placeService.getPlaceById(id);
        return place;
    }

    @GetMapping("/getByName")
    public Place getPlaceByName(@RequestParam String name){
        Place place = placeService.getPlaceByName(name);
        return place;
    }

    @GetMapping("/getByCity")
    public List<Place> getPlaceByCity(@RequestParam String city){
        List<Place> placeList = placeService.getPlaceByCity(city);
        return placeList;
    }

    @PostMapping("/add")
    public void addPlace(@RequestBody Place newPlace){
        placeService.addPlace(newPlace);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlace(@PathVariable Long id){
       placeService.deletePlace(id);
    }

    @PutMapping("/editPlace/{id}")
    public @ResponseBody void  editPlace(@PathVariable Long id, @RequestBody Place place){
        placeService.editPlace(id,place);
    }
}
