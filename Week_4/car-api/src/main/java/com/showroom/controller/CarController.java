package com.showroom.controller;

import com.showroom.model.Car;
import com.showroom.service.CarService;
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

}
