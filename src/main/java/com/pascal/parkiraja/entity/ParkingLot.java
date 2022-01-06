package com.pascal.parkiraja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_parking_lot")
public class ParkingLot {
    public static final String entityName = "PARKING LOT";
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String name;
    private String address;
    private Integer area;
    private Integer capacity;
    private String category;
    private Integer hourlyParkingFee;
    private Integer numberOfVehicle;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    private List<Vehicle> vehicles;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, Integer area, Integer capacity, String category, Integer hourlyParkingFee) {
        this.name = name;
        this.address = address;
        this.area = area;
        this.capacity = capacity;
        this.category = category;
        this.hourlyParkingFee = hourlyParkingFee;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getHourlyParkingFee() {
        return hourlyParkingFee;
    }

    public void setHourlyParkingFee(Integer hourlyParkingFee) {
        this.hourlyParkingFee = hourlyParkingFee;
    }

    public Integer getNumberOfVehicle() {
        return numberOfVehicle;
    }

    public void setNumberOfVehicle(Integer numberOfVehicle) {
        this.numberOfVehicle = numberOfVehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", capacity=" + capacity +
                ", category='" + category + '\'' +
                ", hourlyParkingFee=" + hourlyParkingFee +
                ", numberOfVehicle=" + numberOfVehicle +
                '}';
    }
}
