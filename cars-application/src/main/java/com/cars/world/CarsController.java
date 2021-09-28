package com.cars.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarsController {

    @Autowired
    private CarDAO carDAO;

    @RequestMapping("/list")
    public String carList(Model model) {
        model.addAttribute("Cars", carDAO.getCars());
        return "list";
    }

    @RequestMapping("/add")
    public String carAdd(Model model) {
        return "add";
    }

    @RequestMapping("/car-{id}")
    public String carInformation(@PathVariable("name") Integer id, Model model) {
        model.addAttribute("car", carDAO.getCarById(id));
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
