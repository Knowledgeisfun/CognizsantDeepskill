package com.showroom.controller;


import com.showroom.model.Car;
import com.showroom.service.CarService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

   // @RequestBody acts as the automatic translator. It tells Spring Boot:
    //Look inside the body of the incoming HTTP request
    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCar(){
        return carService.getAllCars();
    }

    @GetMapping("/segment/{segment}")
    public List<Car> getCarBySegment(@PathVariable("segment") String segment){
        return carService.getCarsBySegment(segment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
        // Assuming your service has a method to find a car by ID
        Car car = carService.getCarById(id); 
        
        if (car == null) {
            // If the car doesn't exist, return a 404 Not Found
            // This guarantees your Test 1 stays green!
            return ResponseEntity.notFound().build();
        }
        
        // If the car exists, return a 200 OK with the JSON data
        return ResponseEntity.ok(car);
    }

}
