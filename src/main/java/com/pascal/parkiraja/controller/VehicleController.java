package com.pascal.parkiraja.controller;

import com.pascal.parkiraja.entity.Vehicle;
import com.pascal.parkiraja.service.ParkingLotService;
import com.pascal.parkiraja.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }
}
