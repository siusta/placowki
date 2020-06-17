package pl.siusta.places.service;

import pl.siusta.places.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceById(Long id);
    Place getPlaceByName(String name);
    boolean addPlace(Place place);
    List<Place> getPlaceByCity(String city);
    boolean deletePlace(Long id);
    boolean editPlace(Long id,Place place);
}
