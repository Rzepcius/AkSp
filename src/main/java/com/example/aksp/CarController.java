package com.example.aksp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    List<Car> cars =new ArrayList<>();
    Car car1 = new Car("BMW", "I8");
    Car car2 = new Car("Fiat", "126p");
    Car car3 = new Car("Polonez", "Caro");
    Car car4 = new Car("Opel", "Astra");

    @GetMapping("/car")
    public String getCar(Model model){

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

//        model.addAttribute("name","Andrzej");
        model.addAttribute("cars",cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    private String addCar(@ModelAttribute  Car car){
        cars.add(car);
        return "redirect:car";
    }

    @DeleteMapping("/del-car")
    private String delCar(@ModelAttribute String model){
        System.out.println();
        return "redirect:car";
    }
}
