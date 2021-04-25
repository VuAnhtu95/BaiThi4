package com.example.baithi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
@Data
@Table(name = "citys")
public class City implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "mày điên à nhập đi ai cho để trống")
    @Size(max = 12, message = "nhập vừa thôi chỉ được 12 ký tự")
    private String name;

    private double area;

    private long population;

    private double GDP;

    private String description;

    @ManyToOne
    private Country country;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city = (City) target;
        double area = city.getArea();
        long population = city.getPopulation();
        double GDP = city.getGDP();
        if (area<0){
            errors.rejectValue("area", "area");
        }
        if (population<0){
            errors.rejectValue("population", "population");
        }
        if (GDP<0){
            errors.rejectValue("GDP", "GDP");
        }
    }
}
