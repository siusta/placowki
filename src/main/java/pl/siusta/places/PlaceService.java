package pl.siusta.places;

import pl.siusta.places.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceById(Long id);
    Place getPlaceByName(String name);
    boolean addPlace(Place place);
    List<Place> getPlaceByCity(String city);
    boolean deletePlace(Long id);
    boolean editAllCars(Long id, int allCars);
    boolean editAvailableCars(Long id, int availableCars);
    boolean editPlace(Long id,Place place);
}
