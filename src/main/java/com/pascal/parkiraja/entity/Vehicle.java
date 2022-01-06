package com.pascal.parkiraja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mst_vehicle")
public class Vehicle {
    public static final String entityName = "VEHICLE";
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(unique = true)
    private String plateNumber;
    private String type;
    private Timestamp entryTime = new Timestamp(System.currentTimeMillis());
    private Timestamp endTime;
    private Long longTimeParked;
    private Integer totalBill;

    @Transient
    private String parkingLotId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    public Vehicle() {
    }

    public Vehicle(String plateNumber, String type) {
        this.plateNumber = plateNumber;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Long getLongTimeParked() {
        return longTimeParked;
    }

    public void setLongTimeParked(Long longTimeParked) {
        this.longTimeParked = longTimeParked;
    }

    public Integer getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Integer totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", type='" + type + '\'' +
                ", entryTime=" + entryTime +
                ", endTime=" + endTime +
                ", longTimeParked=" + longTimeParked +
                ", parkingLotId='" + parkingLotId + '\'' +
//                ", parkingLot=" + parkingLot +
                '}';
    }
}
