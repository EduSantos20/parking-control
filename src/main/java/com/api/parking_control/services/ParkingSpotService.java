package com.api.parking_control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parking_control.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

  @Autowired
  ParkingSpotRepository parkingSpotRepository; //injetando no service

  //criando via construtor
  //public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    //this.parkingSpotRepository = parkingSpotRepository;
  //}
  
}
