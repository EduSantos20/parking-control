package com.api.parking_control.dto;

import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ParkingSpotDto {
  //OBS: esses serão os campos que vai ser add na rota 
  @NotBlank(message = "Número da vaga é Obrigatório") // verificar se o campo esta nullo ou se não tem strinh vazia
  private String parkingSpotNumber; // numero da vaga
  @NotBlank(message = "Placa do carro é Obrigatória")
  @Size(max = 7) // numero de caracteres
  //@Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "Placa inválida")
  private String licensePlateCar; // placa do carro
  @NotBlank
  private String brandCar; // marca do carro
  @NotBlank
  private String modelCar; // modelo do carro
  @NotBlank
  private String colorCar; // cor do carro
  @NotBlank
  private String responsibleName; // nome do responsavel
  @NotBlank
  private String apartment; // apartamento
  @NotBlank
  private String block; // bloco

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
