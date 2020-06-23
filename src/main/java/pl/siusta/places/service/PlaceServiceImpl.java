package pl.siusta.places.service;

import org.springframework.stereotype.Service;
import pl.siusta.places.model.Place;
import pl.siusta.places.repo.PlaceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
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
    public boolean addPlace(Place place){
        placeRepo.save(place);
        return true;
    }

    @Override
    public List<Place> getPlaceByCity(String city) {
        Optional<List<Place>> placeList = Optional.ofNullable(placeRepo.findAllByCity(city));
        return placeList.get();
    }

    @Override
    public boolean deletePlace(Long id) {
        placeRepo.deleteById(id);
        return true;

    }

    @Override
    public boolean editPlace(Long id, Place placeEdit) {
        Place place = getPlaceById(id);
        place = placeEdit;
        placeRepo.save(place);
        return true;
    }

    @Override
    public Place testPlace() {
        return new Place("","","","",0,0.0,0.0);
    }
}
