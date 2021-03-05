package ru.project.parking.repository;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.project.parking.entity.Parking;

@SuppressWarnings("all")
public interface ParkingRepository extends JpaRepository<Parking,Long> {
    @Override
    <S extends Parking> S save(S s);
    @Query("SELECT count(isFree) FROM Parking WHERE isFree = true")
    int findFreeParkingPlaces();
    @Query(value = "SELECT id FROM Parking WHERE is_free = true ORDER BY id LIMIT 1", nativeQuery = true)
    int findIDFreeParkingPlace();
}
