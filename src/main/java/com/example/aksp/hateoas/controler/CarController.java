package com.example.aksp.hateoas.controler;

import com.example.aksp.hateoas.model.Car;
import com.example.aksp.hateoas.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    public CarController() {
    }


    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<Car>> getCars(){
        List<Car> cars = carService.getAllCars();
        cars.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarId()).withSelfRel()));
        CollectionModel<Car> carCollectionModel = CollectionModel.of(cars,linkTo(CarController.class).withSelfRel());
        return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable long id){
        Link link = linkTo(CarController.class)
                .slash(id).withSelfRel();
        Optional<Car> carById = carService.getCarById(id);
        EntityModel<Car> carEntityModel = EntityModel.of(carById.get(),link);
        return new ResponseEntity<>(carEntityModel, HttpStatus.OK);
    }
    @GetMapping("/color/{color}")
    public ResponseEntity<CollectionModel<Car>> getCarById(@PathVariable String color){
        List<Car> carsByColor = carService.getCarsByColor(color);
        carsByColor.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarId()).withSelfRel()));
        carsByColor.forEach(car -> car.add(linkTo(CarController.class).withRel("allColors")));
        CollectionModel<Car> carCollectionModel = CollectionModel.of(carsByColor,linkTo(CarController.class).withSelfRel());
        return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
    }

}
