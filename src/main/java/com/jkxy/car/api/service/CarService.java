package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    boolean buyByCarNameAndSeries(String carName, String carSeries);

    boolean buyCarById(int id);

    List<Car> findByCarNameByPage(String carName, int start, int end);


}
