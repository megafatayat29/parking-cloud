package com.pascal.parkiraja.service;

import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Transaction;
import com.pascal.parkiraja.entity.Vehicle;

public interface TransactionService {
    public Transaction createTransaction(Vehicle vehicle, ParkingLot parkingLot);
}
