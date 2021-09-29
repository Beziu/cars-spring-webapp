package com.cars.world;

import java.util.ArrayList;
import java.util.List;

import com.cars.world.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CarDAO {

    @Autowired
    private DataSource dataSource;

    List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarById(Integer id) {
        if (id < cars.size()) {
            return cars.get(id);
        } else {
            return null;
        }
    }

}
