package ru.project.parking.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.PanelService;

@Service
@AllArgsConstructor
public class PanelServiceImpl implements PanelService {
    private final ParkingRepository parkingRepository;

    @Override
    public int findFreeParkingPlaces() {
        return parkingRepository.findFreeParkingPlaces();
    }
}
