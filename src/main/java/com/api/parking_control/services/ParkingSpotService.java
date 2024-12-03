package com.api.parking_control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

  @Autowired
  ParkingSpotRepository parkingSpotRepository; //injetando no service

  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

}
