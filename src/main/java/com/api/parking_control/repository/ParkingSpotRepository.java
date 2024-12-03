package com.api.parking_control.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parking_control.models.ParkingSpotModel;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotRepository, UUID> {

  ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

}
