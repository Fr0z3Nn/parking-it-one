package ru.project.parking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.project.parking.entity.Parking;
import ru.project.parking.repository.ParkingRepository;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@SpringBootApplication
public class ParkingApplication {

    private final ParkingRepository parkingRepository;

    private final int AmountParkingSpaces;

    public ParkingApplication(ParkingRepository parkingRepository, @Value("${parking.capacity}") int amountParkingSpaces) {
        this.parkingRepository = parkingRepository;
        AmountParkingSpaces = amountParkingSpaces;
    }

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

    @PostConstruct
    public void insertParkingPlace() {
        IntStream.range(1, AmountParkingSpaces + 1)
                .forEach(num -> parkingRepository.save(new Parking(num, null,false)));
    }
}
