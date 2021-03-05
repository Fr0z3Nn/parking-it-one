package ru.project.parking.service;

import ru.project.parking.dto.ParkingDTO;

public interface BarrierService {
    boolean hasFreeParkingSpace();
    ParkingDTO addCarToParking(String carNumber);
}
