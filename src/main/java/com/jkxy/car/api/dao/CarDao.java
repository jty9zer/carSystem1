package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries) values(#{carName},#{carType},#{price},#{carSeries})")
    void insertCar(Car car);

    @Select("select count(*) from carMessage where carName = #{carName} and carSeries= #{carSeries}")
    int getCountByCarNameAndSeries(String carName, String carSeries);

    @Select("select count(*) from carMessage where id = #{id}")
    int getCountById(int id);

    @Delete("delete from carMessage where carName = #{carName} and carSeries= #{carSeries} limit 1")
    void deleteByCarNameAndSeries(String carName, String carSeries);

    @Select("select * from carMessage where carName = #{carName} limit #{start}, #{count}")
    List<Car> findByCarNameByPage(String carName, int start, int count);

}
