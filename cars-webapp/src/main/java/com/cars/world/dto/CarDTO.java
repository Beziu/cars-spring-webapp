package com.cars.world.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CarDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp="[0-3]?[0-9]\\.[0-1]?[0-9]\\.[1-2]?[0-9]{3}")
    private String productionDate;

    @NotNull
    private Float price;

    @NotBlank
    private String engine;


    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
