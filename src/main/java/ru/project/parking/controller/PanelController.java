package ru.project.parking.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.BarrierService;
import ru.project.parking.service.PanelService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PanelController {
    private final PanelService panelService;
    private final BarrierService barrierService;
    private final ParkingRepository parkingRepository;
    @GetMapping("/status")
    public String getFreeParkingPlaces(){
        return "СВОБОДНО";
    }
}
