package com.pascal.parkiraja.service;

import com.pascal.parkiraja.constant.ResponseMessage;
import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Vehicle;
import com.pascal.parkiraja.exception.DataNotFoundException;
import com.pascal.parkiraja.repo.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingLotServiceDbImpl implements ParkingLotService{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    TransactionService transactionService;

    @Override
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot getParkingLotById(String id) {
        if (!parkingLotRepository.findById(id).isPresent()){
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND, ParkingLot.entityName, id));
        }
        ParkingLot parkingLot = parkingLotRepository.findById(id).get();
        Integer sum = parkingLot.getVehicles().size();
        parkingLot.setNumberOfVehicle(sum);
        return parkingLot;
    }

    @Override
    public List<Vehicle> setLongTimeParkedAllVehicle(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.setLongTimeParked(vehicleService.calculateLongTimeParked(vehicle));
        }
        return vehicles;
    }

    @Override
    public Integer exitVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot) {
        Integer parkingFee = calculateTotalBill(vehicle, parkingLot);
        transactionService.createTransaction(vehicle, parkingLot);
        vehicleService.deleteVehicleById(vehicle.getId());
        return parkingFee;
    }

    private Integer calculateTotalBill(Vehicle vehicle, ParkingLot parkingLot) {
        vehicle.setLongTimeParked(vehicleService.calculateLongTimeParked(vehicle));
        Integer longTimeParkedInHour = Math.toIntExact(vehicle.getLongTimeParked() / 60);
        if (longTimeParkedInHour==0) longTimeParkedInHour=1;
        Integer parkingFee = longTimeParkedInHour* parkingLot.getHourlyParkingFee();
        vehicle.setTotalBill(parkingFee);
        return parkingFee;
    }


}
