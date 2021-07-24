package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public boolean buyByCarNameAndSeries(String carName, String carSeries) {
        int count = carDao.getCountByCarNameAndSeries(carName, carSeries);
        if(count >0){
            carDao.deleteByCarNameAndSeries(carName, carSeries);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean buyCarById(int id) {
        int count = carDao.getCountById(id);
        if(count >0){
            carDao.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Car> findByCarNameByPage(String carName, int start, int end) {
        int count;
        count = end - start + 1;
        start = start - 1;
        return carDao.findByCarNameByPage(carName, start, count);
    }



}
