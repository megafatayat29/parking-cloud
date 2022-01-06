package com.pascal.parkiraja.controller;

import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Vehicle;
import com.pascal.parkiraja.service.ParkingLotService;
import com.pascal.parkiraja.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/parkingLot")
    public ParkingLot createParkingLot(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.createParkingLot(parkingLot);
    }

    @GetMapping("/parkingLot/{id}")
    public ParkingLot getParkingLotById(@PathVariable(name = "id") String id) {
        return parkingLotService.getParkingLotById(id);
    }

    @GetMapping("/parkingLot/{id}/vehicles")
    public List<Vehicle> getVehiclesByParkingLotId(@PathVariable(name = "id") String id) {
        List<Vehicle> vehicles = parkingLotService.getParkingLotById(id).getVehicles();
        parkingLotService.setLongTimeParkedAllVehicle(vehicles);
        return vehicles;
    }

    @DeleteMapping("/parkingLot/{parkingLotId}/vehicles")
    public Integer exitVehicleFromParkingLot(@PathVariable(name = "parkingLotId") String parkingLotId,
                                          @RequestParam(name = "vehicleId") String vehicleId) {
        return parkingLotService.exitVehicleFromParkingLot(vehicleService.getVehicleById(vehicleId), parkingLotService.getParkingLotById(parkingLotId));
    }

}
