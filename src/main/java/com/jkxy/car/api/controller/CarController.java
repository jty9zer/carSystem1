package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

    /**
     * 通过车名和型号购买车辆
     *
     * @param carName
     * @param carSeries
     * @return
     */
    @GetMapping("buyCarByNameAndSeries")
    public JSONResult buyCarByNameAndSeries(@RequestParam(value = "carName") String carName,
                                            @RequestParam(value = "carSeries") String carSeries) {
        if (carService.buyByCarNameAndSeries(carName, carSeries)) {
            return JSONResult.ok("购买车辆成功");
        } else {
            return JSONResult.errorMsg("购买车辆出错，车辆已售空");
        }
    }

    /**
     * 通过车辆ID购买车辆
     *
     * @param id
     * @return
     */
    @GetMapping("buyCarById/{id}")
    public JSONResult buyCarById(@PathVariable int id) {
        if (carService.buyCarById(id)) {
            return JSONResult.ok("购买车辆成功");
        } else {
            return JSONResult.errorMsg("购买车辆出错，车辆已出售");
        }

    }

    /**
     * 通过车名分页查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarNameByPage/{carName}")
    public JSONResult findByCarNameByPage(@PathVariable String carName,
                                          @RequestParam(value = "start", required = false, defaultValue = "1") int start,
                                          @RequestParam(value = "end", required = false, defaultValue = "5") int end) {
        List<Car> cars = carService.findByCarNameByPage(carName, start, end);
        return JSONResult.ok(cars);
    }


}
