package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDaoImpl;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController extends CarDaoImpl {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public String printAllCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> listCars = carService.getCars(carList, count);
        model.addAttribute("listCars", listCars);
        return "cars";
    }

}
