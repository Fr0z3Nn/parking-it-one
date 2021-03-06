package ru.project.parking.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.service.BarrierService;

@RestController
@RequestMapping("/api/barrier")
@AllArgsConstructor
public class BarrierController {
    private final BarrierService barrierService;

    @PostMapping("/add")
    public ResponseEntity<ParkingDTO> addCar(@RequestParam String carNum) {
        ParkingDTO parkingDTO = barrierService.addCarToParking(carNum);
        return new ResponseEntity<>(parkingDTO, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeCar(@RequestParam String carNum) {
        barrierService.removeCarFromParking(carNum);
        return new ResponseEntity<>("Car successfully deleted", HttpStatus.OK);
    }
}
