Api z placówkami wypożyczalni samochodów na SOA

https://placowki.herokuapp.com/places

/all                                  <- getAllPlaces
/getById/{id}                         <- getPlaceByID
/getByName                            <- getPlaceByName (przez parametr)
/getByCity                            <- getPlaceByCity (przez parametr)
/add                                  <- addPlace (body)
/delete/{id}                          <- deletePlace
/editPlace/{id}                       <- editPlace (body)
/editAvailable/{id}/{availableCars}   <- editAvailableCars
/editAllCars/{id}/{allCars}           <- editAllCars

Przykładowe placówki są w "sample data.txt".
