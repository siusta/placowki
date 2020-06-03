package pl.siusta.places;

import pl.siusta.places.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceById(Long id);
    Place getPlaceByName(String name);
    void addPlace(Place place);
    List<Place> getPlaceByCity(String city);
    void deletePlace(Long id);
    void editAllCars(Long id, int allCars);
    void editAvailableCars(Long id, int availableCars);
    void editPlace(Long id,Place place);
}
