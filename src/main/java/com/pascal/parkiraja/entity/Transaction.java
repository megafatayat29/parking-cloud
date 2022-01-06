package com.pascal.parkiraja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trx_parking_lot_vehicle")
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String plateNumber;
    private String parkingLotId;
    private Long durationInMinutes;
    private Integer totalBill;

    @JsonIgnore
    @OneToMany(mappedBy = "transaction")
    private List<ParkingLot> parkingLots;

    public Transaction() {
    }

    public Transaction(String plateNumber, String parkingLotId, Long durationInMinutes, Integer totalBill) {
        this.plateNumber = plateNumber;
        this.parkingLotId = parkingLotId;
        this.durationInMinutes = durationInMinutes;
        this.totalBill = totalBill;
    }

    public String getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Long getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Long durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Integer getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Integer totalBill) {
        this.totalBill = totalBill;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}