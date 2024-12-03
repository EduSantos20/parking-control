package com.api.parking_control.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotRepository, UUID> {

}
