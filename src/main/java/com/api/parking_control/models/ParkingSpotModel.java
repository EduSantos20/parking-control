package com.api.parking_control.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_parking_control") // tabela que vai ser criada no banco
public class ParkingSpotModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID) // id vai ser gerado de forma automática na base dados
  private UUID id;

  @Column(nullable = false, unique = true, length = 10) // não pode ser nulo/não pode ter numero repetidos/tamanho de 10
  private String parkingSpotNumber; // numero da vaga

  @Column(nullable = false, unique = true, length = 7) // não pode ser nulo/não pode ter numero repetidos/tamanho de 10
  private String licensePlateCar; // placa do carro

  @Column(nullable = false, length = 70)
  private String brandCar; // marca do carro

  @Column(nullable = false, length = 70)
  private String modelCar; // modelo do carro

  @Column(nullable = false, length = 70)
  private String colorCar; // cor do carro

  @Column(nullable = false)
  private LocalDateTime registrationDate; // data do registro

  @Column(nullable = false, length = 130)
  private String responsibleName; // nome do responsavel

  @Column(nullable = false, length = 30)
  private String apartment; // apartamento

  @Column(nullable = false, length = 30)
  private String block; // bloco

  // OBS: para implementar depois, fazer uma class para carro para fazer o
  // relacionamento com o dono do carro

  // criando os getter e setter

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  public void setParkingSpotNumber(String parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

  public String getLicensePlateCar() {
    return licensePlateCar;
  }

  public void setLicensePlateCar(String licensePlateCar) {
    this.licensePlateCar = licensePlateCar;
  }

  public String getBrandCar() {
    return brandCar;
  }

  public void setBrandCar(String brandCar) {
    this.brandCar = brandCar;
  }

  public String getModelCar() {
    return modelCar;
  }

  public void setModelCar(String modelCar) {
    this.modelCar = modelCar;
  }

  public String getColorCar() {
    return colorCar;
  }

  public void setColorCar(String colorCar) {
    this.colorCar = colorCar;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public String getResponsibleName() {
    return responsibleName;
  }

  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
  }

  public String getApartment() {
    return apartment;
  }

  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  public String getBlock() {
    return block;
  }

  public void setBlock(String block) {
    this.block = block;
  }

}
