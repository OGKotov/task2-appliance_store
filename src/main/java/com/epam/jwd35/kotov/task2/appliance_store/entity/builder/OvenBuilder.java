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
import com.epam.jwd35.kotov.task2.appliance_store.entity.Oven;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class OvenBuilder implements ApplianceBuilder{
    private String name;
    private String model;
    private int powerConsumption;
    private double weight;
    private int capacity;
    private double depth;
    private double height;
    private double width;

    public OvenBuilder() {
    }

    public OvenBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OvenBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public OvenBuilder setPowerConsumption(String powerConsumption) {
        this.powerConsumption = Integer.parseInt(powerConsumption);
        return this;
    }

    public OvenBuilder setWeight(String weight) {
        this.weight = Double.parseDouble(weight);
        return this;
    }

    public OvenBuilder setCapacity(String capacity) {
        this.capacity = Integer.parseInt(capacity);
        return this;
    }

    public OvenBuilder setDepth(String depth) {
        this.depth = Double.parseDouble(depth);
        return this;
    }

    public OvenBuilder setHeight(String height) {
        this.height = Double.parseDouble(height);
        return this;
    }

    public OvenBuilder setWidth(String width) {
        this.width = Double.parseDouble(width);
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String powerConsumption;
        String weight;
        String capacity;
        String depth;
        String height;
        String width;

        name = characteristicMap.get(CharacteristicName.Oven.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.Oven.MODEL.getValue());
        powerConsumption = characteristicMap.get(CharacteristicName.Oven.POWER_CONSUMPTION
                .getValue());
        weight = characteristicMap.get(CharacteristicName.Oven.WEIGHT.getValue());
        capacity = characteristicMap.get(CharacteristicName.Oven.CAPACITY.getValue());
        depth = characteristicMap.get(CharacteristicName.Oven.DEPTH.getValue());
        height = characteristicMap.get(CharacteristicName.Oven.HEIGHT.getValue());
        width = characteristicMap.get(CharacteristicName.Oven.WIDTH.getValue());

        setName(name).setModel(model).setWeight(powerConsumption). setWeight(weight).
                setCapacity(capacity).setDepth(depth).setHeight(height).setWidth(width);

        Appliance appliance = new Oven(this.name, this.model, this.powerConsumption,
                this.weight, this.capacity, this.depth, this.height, this.width);
        return appliance;
    }
}