package ru.project.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.parking.dto.ParkingDTO;
import ru.project.parking.entity.Parking;

import java.util.Optional;

@SuppressWarnings("all")
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Override
    <S extends Parking> S save(S s);

    @Query("SELECT count(isFree) FROM Parking WHERE isFree = true")
    long findFreeParkingPlaces();

    @Query(value = "SELECT id FROM Parking WHERE is_free = true ORDER BY id LIMIT 1", nativeQuery = true)
    long findIDFreeParkingPlace();

    @Modifying
    @Query(value = "UPDATE Parking SET is_free = true WHERE car_number = :car")
    void removeCarFromParkingSpace(@Param("car") String carNumber);

    @Query(value = "SELECT * FROM Parking WHERE car_number = :car",nativeQuery = true)
    Optional<ParkingDTO> findParkingPlaceByCarNumber(@Param("car") String carNumber);
}
