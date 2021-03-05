package ru.project.parking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingDTO {
    long id;
    boolean isFree;
    String carNumber;
}
