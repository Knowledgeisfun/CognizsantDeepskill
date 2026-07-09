package com.showroom.service;

import com.showroom.model.Car;
import com.showroom.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        // Business Validation: Prevent adding cars with negative pricing
        if (car.getPrice() < 0) {
            throw new IllegalArgumentException("Car price cannot be negative!");
        }
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarsBySegment(String segment) {
        return carRepository.findBySegment(segment);
    }
}
