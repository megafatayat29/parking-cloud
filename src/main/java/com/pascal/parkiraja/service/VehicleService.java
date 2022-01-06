package com.pascal.parkiraja.service;

import com.pascal.parkiraja.entity.Vehicle;

import java.sql.Timestamp;

public interface VehicleService {
    public Vehicle createVehicle(Vehicle vehicle);
    public Long calculateLongTimeParked(Vehicle vehicle);
    public void deleteVehicleById(String id);
    public Vehicle getVehicleById(String id);
    
}
