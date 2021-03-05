package ru.project.parking.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.entity.Parking;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.BarrierService;
import ru.project.parking.service.PanelService;

@Service
@AllArgsConstructor
public class BarrierServiceImpl implements BarrierService {
    private final PanelService panelService;
    private final ParkingRepository parkingRepository;
    @Override
    public boolean hasFreeParkingSpace() {
        return panelService.findFreeParkingPlaces() != 0;
    }

    @Override
    public ParkingDTO addCarToParking(String carNumber) {
        if(!hasFreeParkingSpace()) return null;
        int id = parkingRepository.findIDFreeParkingPlace();
        System.out.println(id);
        ParkingDTO parkingDTO = ParkingDTO.builder()
                .id(id)
                .carNumber(carNumber)
                .isFree(false)
                .build();
        parkingRepository.save(new Parking(id,carNumber,false));
        return parkingDTO;
    }
}
