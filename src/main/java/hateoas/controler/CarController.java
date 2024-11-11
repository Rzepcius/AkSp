package hateoas.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v")
public class CarController {

    public CarController() {
    }

    @GetMapping
    public String get(){

        return "Dupa";
    }

//    private CarService carService;

//    @Autowired
//    public CarController(CarService carService) {
//        this.carService = carService;
//    }

//    @GetMapping
//    public ResponseEntity<List<Car>> getCars(){
//        List<Car> cars = carService.getAllCars();
//        return new ResponseEntity<>(cars, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getCarById(@PathVariable long id){
//        Optional<Car> carById = carService.getCarById(id);
//        return new ResponseEntity<>(carById.get(), HttpStatus.OK);
//    }
//    @GetMapping("/color/{color}")
//    public ResponseEntity<List<Car>> getCarById(@PathVariable String color){
//        List<Car> carsByColor = carService.getCarsByColor(color);
//        return new ResponseEntity<>(carsByColor, HttpStatus.OK);
//    }

}
