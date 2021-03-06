package ru.project.parking.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.dto.StatusDTO;
import ru.project.parking.handler.exception.CustomException;
import ru.project.parking.mapper.ParkingMapper;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.PanelService;

@Service
public class PanelServiceImpl implements PanelService {
    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;
    private final long amountParkingSpaces;

    public PanelServiceImpl(ParkingRepository parkingRepository, ParkingMapper parkingMapper, @Value("${parking.capacity}") long amountParkingSpaces) {
        this.parkingRepository = parkingRepository;
        this.parkingMapper = parkingMapper;
        this.amountParkingSpaces = amountParkingSpaces;
    }

    @Override
    public StatusDTO findFreeParkingPlaces() {
        long freeParkingSpaces = parkingRepository.findFreeParkingPlaces();
        return StatusDTO.builder()
                .amountOfParkingSpaces(amountParkingSpaces)
                .amountOfFreeSpaces(freeParkingSpaces)
                .amountOfTakenSpaces(amountParkingSpaces - freeParkingSpaces)
                .build();
    }

    @Override
    public ParkingDTO getFreeParkingPlaceById(long id) {
        return parkingMapper.fromParkingToParkingDTO(parkingRepository.findById(id)
                .orElseThrow(() -> new CustomException("ID is not corrected")));
    }
}
