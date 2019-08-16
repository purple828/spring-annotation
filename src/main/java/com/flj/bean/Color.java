package com.flj.bean;

import lombok.ToString;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 11:14
 **/
@ToString
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
