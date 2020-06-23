Api z placówkami wypożyczalni samochodów na SOA<br>
<br>
https://placowki.herokuapp.com/places<br>
<br>
/all                                     <- getAllPlaces<br>
/getById/{id}                            <- getPlaceByID<br>
/getByName                               <- getPlaceByName (przez parametr)<br>
/getByCity                               <- getPlaceByCity (przez parametr)<br>
/add                                     <- addPlace (body)<br>
/delete/{id}                             <- deletePlace<br>
/editPlace/{id}                          <- editPlace (body)<br>
/test                                    <- pusta placówka<br>
<br>    
/cars/all                                <- getAllCars<br>
/cars/all/{id}                           <- getCarsInPlace (wszystkie dane samochodów)<br>
/cars/available/{id}                     <- getAvailableCarsInPlace (wszystkie dane wolnych samochodów)<br>
/cars/addCarToPlace/{placeId}/{carId}    <- addCar<br>
/cars/changeStatus/{carId}               <- changeStatus (wolny lub nie)<br>
/cars//delete/{carId}                    <- deleteCar<br>
/cars/test                               <- pusty samochód<br>
<br>
ID samochodu powinno być takie samo jak w kartotece pojazdów.<br>
Przykładowe placówki są w "sample data.txt".
