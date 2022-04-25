package com.example.docker.controller;

import com.example.docker.dto.CarDTO;
import com.example.docker.model.Car;
import com.example.docker.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  CarRepository carRepository;

  @GetMapping("/add")
  public String add(){
    Car car = Car.builder().carName("way").build();
    carRepository.save(car);
    return "hello Nam";
  }

  @GetMapping("/get")
  public ResponseEntity<CarDTO> get(){
    Car car = carRepository.getById(1);
    CarDTO carDTO = CarDTO.builder().id(car.getId()).carName(car.getCarName()).build();
    return new ResponseEntity<>(carDTO, HttpStatus.OK);
  }
}
