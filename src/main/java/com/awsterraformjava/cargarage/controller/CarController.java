package com.awsterraformjava.cargarage.controller;

import com.awsterraformjava.cargarage.repository.CarRepository;
import com.awsterraformjava.cargarage.model.Car;
import com.awsterraformjava.cargarage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable(value = "id") Long carId) {
      return carRepository.findById(carId)
        .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
    }

    @PostMapping("/cars")
    public Car createCar(@Valid @RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody Car carDetail) {
      Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
      car.setMake(carDetail.getMake());
      car.setModel(carDetail.getModel());

      Car updatedCar = carRepository.save(car);

      return updatedCar;
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long carId) {
      Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
      carRepository.delete(car);

      return ResponseEntity.ok().build();
    }
}
