package ru.project.parking.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.handler.exception.CustomException;
import ru.project.parking.mapper.ParkingMapper;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.BarrierService;
import ru.project.parking.service.PanelService;

@Service
@AllArgsConstructor
public class BarrierServiceImpl implements BarrierService {
    private final PanelService panelService;
    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;


    @Override
    @Transactional
    public boolean removeCarFromParking(String carNum) {
        parkingRepository.findParkingPlaceByCarNumber(carNum).orElseThrow(
                () -> new CustomException("This car number is not present on parking")
        );
        parkingRepository.removeCarFromParkingSpace(carNum);
        return true;
    }

    @Override
    public boolean hasFreeParkingSpace() {
        return panelService.findFreeParkingPlaces().getAmountOfFreeSpaces() > 0;
    }

    @Override
    public ParkingDTO addCarToParking(String carNumber) {
        if (!hasFreeParkingSpace()) throw new CustomException("All places is taken");
        long id = parkingRepository.findIDFreeParkingPlace();
        ParkingDTO parkingDTO = ParkingDTO.builder()
                .id(id)
                .carNumber(carNumber)
                .isFree(false)
                .build();
        parkingRepository.save(parkingMapper.fromParkingDTOtoParking(parkingDTO));
        return parkingDTO;
    }
}
