package com.api.parking_control.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking_control.dto.ParkingSpotDto;
import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.services.ParkingSpotService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

  final ParkingSpotService parkingSpotService;

  public ParkingSpotController(ParkingSpotService parkingSpotService) {
    this.parkingSpotService = parkingSpotService;
  }

  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

    if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do carro já está em uso!");
    }
    if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga de estacionamento já está em uso!");
    }
    if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflito: Vaga de estacionamento já registrada para este apartamento/bloco!");
    }

    ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); // convertendo o dto em models copiando todas as
    // propriedades
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
  }

  // Listando todos os carros do estacionamento
  @GetMapping
  public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getIdParkingSpots(@PathVariable(value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    if(!parkingSpotModelOptional.isPresent()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada!");
    }
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteIdParkingSpots(@PathVariable(value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    if (!parkingSpotModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada!");
    }
    parkingSpotService.delete(parkingSpotModelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Vaga de estacionamento excluida com sucesso.");
  }

  //para atualizar
  @PutMapping("/{id}")
  public ResponseEntity<Object> upadateIdParkingSpots(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    if (!parkingSpotModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada!");
    }
    var parkingSpotModel =  parkingSpotModelOptional.get();
    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
    parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
  }

  @GetMapping("/parking-spot")
  public String form() {
    return "parkingStop/formCar";
  }

  @PostMapping("/parking-spot")
  public String form(ParkingSpotDto parkingSpotDto) {
    // repositoryDto.save(parkingSpotDto); // salvando meus dados no banco de dados
    return "redirect:/formCar"; // chamando meu cadastro evento html
  }

}
