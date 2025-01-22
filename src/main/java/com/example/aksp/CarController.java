package com.example.aksp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    public static final String REDIRECT_CAR = "redirect:/car";
    List<Car> cars = new ArrayList<>();
    Car car1 = new Car("BMW", "I8");
    Car car2 = new Car("Fiat", "126p");
    Car car3 = new Car("Polonez", "Caro");
    Car car4 = new Car("Opel", "Astra");

    {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @GetMapping("/car")
    public String getCar(Model model) {
//        model.addAttribute("name","Andrzej");
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        return "redirect:car";
    }

    @GetMapping("/car/delete/{index}")
    public String confirmDelete(@PathVariable("index") int index, Model model) {
        if (index >= 0 && index < cars.size()) {
            model.addAttribute("car", cars.get(index)); // Przekazanie elementu
            model.addAttribute("index", index); // Przekazanie indeksu
            return "confirm-delete"; // Widok potwierdzenia
        }
        return REDIRECT_CAR; // Jeśli indeks jest nieprawidłowy, wróć do listy
    }

    @GetMapping("/car/edit/{index}")
    public String selectEditCar(@PathVariable("index") int index, Model model) {
        if (index >= 0 && index < cars.size()) {
            model.addAttribute("car", cars.get(index)); // Przekazanie elementu
            model.addAttribute("index", index); // Przekazanie indeksu
            return "edit"; // Widok potwierdzenia
        }
        return REDIRECT_CAR; // Jeśli indeks jest nieprawidłowy, wróć do listy
    }

    // Usuwanie elementu
    @PostMapping("/car/edit/{index}")
    public String edicCar(@PathVariable("index") int index,@ModelAttribute Car car) {
        if (index >= 0 && index < cars.size()) {
            Car editCar = cars.get(index);
            editCar.setMark(car.getMark());
            editCar.setModel(car.getModel());
        }
        return REDIRECT_CAR;
    }

    @PostMapping("/car/delete/{index}")
    public String deleteItem(@PathVariable("index") int index) {
        if (index >= 0 && index < cars.size()) {
            cars.remove(index);
        }
        return REDIRECT_CAR;
    }
}
