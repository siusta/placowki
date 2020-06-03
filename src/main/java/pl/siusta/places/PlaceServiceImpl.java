package pl.siusta.places;

import org.springframework.stereotype.Service;
import pl.siusta.places.Place;
import pl.siusta.places.PlaceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService{
    private PlaceRepo placeRepo;

    public PlaceServiceImpl(PlaceRepo placeRepo){
        this.placeRepo = placeRepo;
    }

    @Override
    public List<Place> getAllPlaces(){
        return placeRepo.findAll();
    }

    @Override
    public Place getPlaceById(Long id){
        Optional<Place> place = placeRepo.findById(id);
        return place.get();
    }

    @Override
    public Place getPlaceByName(String name) {
        Optional<Place> place = Optional.ofNullable(placeRepo.findByName(name));
        return place.get();
    }


    @Override
    public void addPlace(Place place){
        placeRepo.save(place);
    }



    @Override
    public List<Place> getPlaceByCity(String city) {
        Optional<List<Place>> placeList = Optional.ofNullable(placeRepo.findAllByCity(city));
        return placeList.get();
    }

    @Override
    public void deletePlace(Long id) {
        Place placeToDelete = getPlaceById(id);
        placeRepo.delete(placeToDelete);
    }

}
