package com.example.demo.web.controller;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.StatusCar;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/all")
    public String getAllCars(Model model){
        List<Car> allCars = carService.findAllCars();
    model.addAttribute("cars", allCars);
    return "cars";
    }

    @GetMapping("/carDelete/{id}")
    public String deleteCar(@PathVariable("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/cars/all";
    }


}
