/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.builder;

import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Refrigerator;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class RefrigeratorBuilder implements ApplianceBuilder {
    private String name;
    private String model;
    private int powerConsumption;
    private double weight;
    private int freezerCapacity;
    private int overallCapacity;
    private double height;
    private double width;

    public RefrigeratorBuilder() {
    }

    public RefrigeratorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RefrigeratorBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public RefrigeratorBuilder setPowerConsumption(String powerConsumption) {
        this.powerConsumption = Integer.parseInt(powerConsumption);
        return this;
    }

    public RefrigeratorBuilder setWeight(String weight) {
        this.weight = Double.parseDouble(weight);
        return this;
    }

    public RefrigeratorBuilder setFreezerCapacity(String freezerCapacity) {
        this.freezerCapacity = Integer.getInteger(freezerCapacity);
        return this;
    }

    public RefrigeratorBuilder setOverallCapacity(String overallCapacity) {
        this.overallCapacity = Integer.parseInt(overallCapacity);
        return this;
    }

    public RefrigeratorBuilder setHeight(String height) {
        this.height = Double.parseDouble(height);
        return this;
    }

    public RefrigeratorBuilder setWidth(String width) {
        this.width = Double.parseDouble(width);
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String powerConsumption;
        String weight;
        String freezerCapacity;
        String overallCapacity;
        String height;
        String width;

        name = characteristicMap.get(CharacteristicName.Refrigerator.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.Refrigerator.MODEL.getValue());
        powerConsumption = characteristicMap.get(CharacteristicName.Refrigerator.
                POWER_CONSUMPTION.getValue());
        weight = characteristicMap.get(CharacteristicName.Refrigerator.WEIGHT.getValue());
        freezerCapacity = characteristicMap.get(CharacteristicName.Refrigerator.FREEZER_CAPACITY.
                getValue());
        overallCapacity = characteristicMap.get(CharacteristicName.Refrigerator.OVERALL_CAPACITY
                .getValue());
        height = characteristicMap.get(CharacteristicName.Refrigerator.HEIGHT.getValue());
        width = characteristicMap.get(CharacteristicName.Refrigerator.WIDTH.getValue());

        setName(name).setModel(model).setWeight(powerConsumption). setWeight(weight).
                setFreezerCapacity(freezerCapacity).setOverallCapacity(overallCapacity).
                setHeight(height).setWidth(width);

        Appliance appliance = new Refrigerator(this.name, this.model, this.powerConsumption,
                this.weight, this.freezerCapacity, this.overallCapacity, this.height,
                this.width);
        return appliance;
    }
}