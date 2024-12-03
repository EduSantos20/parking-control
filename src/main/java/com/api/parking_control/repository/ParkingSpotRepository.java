package com.api.parking_control.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.parking_control.models.ParkingSpotModel;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
  
  boolean existsByLicensePlateCar(String licensePlateCar);
  boolean existsByParkingSpotNumber(String parkingSpotNumber);
  boolean existsByApartmentAndBlock(String apartment, String block);
}
