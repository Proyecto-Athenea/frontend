package com.example.reto3atenea.Controller;

import com.example.reto3atenea.Model.Car;
import com.example.reto3atenea.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all") // ->>>> localhost......./api/
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}") // ->>>>>>> localhost......../api/car/12
    public Optional<Car> getCar (@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }
}
