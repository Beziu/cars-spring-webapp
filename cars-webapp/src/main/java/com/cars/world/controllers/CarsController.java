package com.cars.world.controllers;

import com.cars.world.CarDAO;
import com.cars.world.domain.Car;
import com.cars.world.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class CarsController {

    @Autowired
    private CarDAO daoCar;

    @RequestMapping("/list")
    public String carList(Model model) {
        model.addAttribute("Cars", daoCar.getCars());
        return "list";
    }

    @RequestMapping("/add")
    public String carAdd(
            HttpServletRequest request,
            @ModelAttribute("dtoCar") @Valid CarDTO dtoCar,
            BindingResult result) {

        if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
            Car car = new Car();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                car.setProductionDate(sdf.parse(dtoCar.getProductionDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            car.setName(dtoCar.getName());
            car.setPrice(dtoCar.getPrice());
            car.setEngine(dtoCar.getEngine());
            daoCar.addCar(car);
            return "redirect:/list";
        }
        return "add";
    }

    @RequestMapping("/car-{id}")
    public String carInformation(@PathVariable("name") Integer id, Model model) {
        model.addAttribute("car", daoCar.getCarById(id));
        return "information";
    }




    @RequestMapping("/car/{name}")
    public String carInf(@PathVariable("name") String carName) {
        return "main";
    }

    @RequestMapping("/car1")
    public String view1(
            @RequestParam("a") String danaA,
            @RequestParam("b") Integer danaB) {
        return "main";
    }

    @RequestMapping("/car2")
    public String view2(
            @RequestParam("a") String danaA,
            @RequestParam(value = "b", required = false, defaultValue = "0") Integer danaB) {
        return "main";
    }

}
