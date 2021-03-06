package ru.project.parking.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    long amountOfFreeSpaces;
    long amountOfTakenSpaces;
    long amountOfParkingSpaces;
}
