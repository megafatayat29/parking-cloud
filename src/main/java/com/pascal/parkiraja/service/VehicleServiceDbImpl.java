package com.pascal.parkiraja.service;

import com.pascal.parkiraja.constant.ResponseMessage;
import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Vehicle;
import com.pascal.parkiraja.exception.DataNotFoundException;
import com.pascal.parkiraja.exception.ForbiddenToParkHere;
import com.pascal.parkiraja.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class VehicleServiceDbImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingLotService parkingLotService;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLotService.getParkingLotById(vehicle.getParkingLotId());
        if (vehicle.getType().equals(parkingLot.getCategory()) || parkingLot.getCategory().equals("All")) {
            Integer idleCapacity = parkingLot.getCapacity()-parkingLot.getNumberOfVehicle();
            if (idleCapacity<1) {
                throw new ForbiddenToParkHere(String.format(ResponseMessage.PARKING_LOT_FULL));
            } else {
                vehicle.setParkingLot(parkingLot);
            }
        } else {
            throw new ForbiddenToParkHere(String.format(ResponseMessage.FORBIDDEN_TO_PARK_HERE, vehicle.getType()));
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Long calculateLongTimeParked(Vehicle vehicle) {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        vehicle.setEndTime(endTime);
        Long longTimeParkedInMillis = vehicle.getEndTime().getTime() - vehicle.getEntryTime().getTime();
        Long longTimeParkedInMinutes = (longTimeParkedInMillis / 1000) / 60;
        vehicle.setLongTimeParked(longTimeParkedInMinutes);
        return vehicle.getLongTimeParked();
    }

    @Override
    public void deleteVehicleById(String id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getVehicleById(String id) {
        if (!(vehicleRepository.findById(id).isPresent())) {
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND, Vehicle.entityName, id));
        }
        return vehicleRepository.getById(id);
    }


}
