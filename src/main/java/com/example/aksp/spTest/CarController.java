package com.example.aksp.spTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    //    Bez IoC
//    private CarService carService = new CarService();
//    Z IoC iniekcja przez pole jest niezalecana
    public CarService carService;

    //    Zaleca się iniekcje przy pomocy konstruktora, autowired mile widziane, lecz nie wymagane
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

//    Wstrzykiwanie do metody(przez setter)
//    @Autowired
//    public void setCarService(CarService carService) {
//        this.carService = carService;
//    }

    @GetMapping
    public List<Car> get() {
        return carService.getCars();
    }

}
