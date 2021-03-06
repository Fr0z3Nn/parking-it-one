package ru.project.parking.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.dto.StatusDTO;
import ru.project.parking.service.PanelService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PanelController {

    private final PanelService panelService;


    @GetMapping("/status")
    public ResponseEntity<StatusDTO> getFreeParkingPlaces() {
        return new ResponseEntity<>(panelService.findFreeParkingPlaces(), HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<ParkingDTO> getFreeParkingPlaceById(@RequestParam("id") long id) {
        return new ResponseEntity<>(panelService.getFreeParkingPlaceById(id), HttpStatus.OK);
    }
}
