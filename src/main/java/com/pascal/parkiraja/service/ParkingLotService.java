package com.pascal.parkiraja.service;

import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Vehicle;

import java.util.List;

public interface ParkingLotService {
    public ParkingLot createParkingLot(ParkingLot parkingLot);
    public ParkingLot getParkingLotById(String id);
    public List<Vehicle> setLongTimeParkedAllVehicle(List<Vehicle> vehicles);
    public Integer exitVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot);
}
