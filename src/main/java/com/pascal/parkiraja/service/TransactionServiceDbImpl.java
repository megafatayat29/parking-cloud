package com.pascal.parkiraja.service;

import com.pascal.parkiraja.entity.ParkingLot;
import com.pascal.parkiraja.entity.Transaction;
import com.pascal.parkiraja.entity.Vehicle;
import com.pascal.parkiraja.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceDbImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Vehicle vehicle, ParkingLot parkingLot) {
        Transaction transaction = new Transaction(vehicle.getPlateNumber(), parkingLot.getId(), vehicle.getLongTimeParked(), vehicle.getTotalBill());
        transactionRepository.save(transaction);
        return transaction;
    }
}
