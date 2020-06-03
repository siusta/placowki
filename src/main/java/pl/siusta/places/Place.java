package pl.siusta.places;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private String city;
    private String street;
    private int buildingNumber;
    private Double latitude;
    private Double longitude;
    private int allCars;
    private int availableCars;

    public Place() {
    }

    public Place(String name, String owner, String city, String street, int buildingNumber, Double latitude, Double longitude, int allCars, int availableCars) {
        this.name = name;
        this.owner = owner;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.allCars = allCars;
        this.availableCars = availableCars;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getAllCars() {
        return allCars;
    }

    public void setAllCars(int allCars) {
        this.allCars = allCars;
    }

    public int getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(int availableCars) {
        this.availableCars = availableCars;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", allCars=" + allCars +
                ", availableCars=" + availableCars +
                '}';
    }
}
