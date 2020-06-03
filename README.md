Api z placówkami wypożyczalni samochodów na SOA<br>
<br>
https://placowki.herokuapp.com/places<br>
<br>
/all                                  <- getAllPlaces<br>
/getById/{id}                         <- getPlaceByID<br>
/getByName                            <- getPlaceByName (przez parametr)<br>
/getByCity                            <- getPlaceByCity (przez parametr)<br>
/add                                  <- addPlace (body)<br>
/delete/{id}                          <- deletePlace<br>
/editPlace/{id}                       <- editPlace (body)<br>
/editAvailable/{id}/{availableCars}   <- editAvailableCars<br>
/editAllCars/{id}/{allCars}           <- editAllCars<br>
<br>
Przykładowe placówki są w "sample data.txt".
