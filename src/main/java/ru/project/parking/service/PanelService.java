package ru.project.parking.service;

import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.dto.StatusDTO;

public interface PanelService {
    StatusDTO findFreeParkingPlaces();

    ParkingDTO getFreeParkingPlaceById(long id);
}
