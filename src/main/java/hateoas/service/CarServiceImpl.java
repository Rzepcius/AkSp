package hateoas.service;

import hateoas.model.Car;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import hateoas.model.Color;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getAllCars() {
        return createListOfCars();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return createListOfCars().stream()
                .filter(car -> car.getCarId() == id)
                .findFirst();
    }
    @Override
    public List<Car> getCarsByColor(String color) {
        return createListOfCars()
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());
    }
    private List<Car> createListOfCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1L,"Mercedes", "GLC 300", Color.NAVY_BLUE));
        carList.add(new Car(2L,"Maserati", "Quattroporte", Color.MARINE));
        carList.add(new Car(3L,"Alfa Romeo","Giulia", Color.RED));
        carList.add(new Car(4L,"Mercedes",  "EQC", Color.BLUE));
        carList.add(new Car(5L,"Ferrari",  "California", Color.BLACK));
        carList.add(new Car(6L,"Bugatti", "La Voiture Noire", Color.WHITE));
        return carList;
    }
}
