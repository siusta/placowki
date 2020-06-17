package pl.siusta.places.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private Long id;
    private Long placeId;
    private Boolean available;

    public Car(Long id, Long placeId, Boolean available) {
        this.id=id;
        this.placeId=placeId;
        this.available=available;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
