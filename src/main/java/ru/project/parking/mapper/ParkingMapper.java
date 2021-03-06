package ru.project.parking.mapper;

import org.springframework.stereotype.Component;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.entity.Parking;

@Component
public class ParkingMapper {
    public Parking fromParkingDTOtoParking(ParkingDTO parkingDTO) {
        return new Parking(parkingDTO.getId(), parkingDTO.getCarNumber(), parkingDTO.isFree());
    }

    public ParkingDTO fromParkingToParkingDTO(Parking parking) {
        return ParkingDTO.builder()
                .id(parking.getId())
                .isFree(parking.isFree())
                .carNumber(parking.getCarNumber())
                .build();
    }
}
