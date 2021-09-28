package com.cars.world;

import java.util.ArrayList;
import java.util.List;

import com.cars.world.domain.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO {

    List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

}
