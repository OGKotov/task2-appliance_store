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
import com.epam.jwd35.kotov.task2.appliance_store.entity.VaccuumCleaner;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class VaccuumCleanerBuilder implements ApplianceBuilder {
    private String name;
    private String model;
    private int powerConsumption;
    private int vaccuumPower;
    private String filterType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VaccuumCleanerBuilder() {
    }

    public VaccuumCleanerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public VaccuumCleanerBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VaccuumCleanerBuilder setPowerConsumption(String powerConsumption) {
        this.powerConsumption = Integer.parseInt(powerConsumption);
        return this;
    }

    public VaccuumCleanerBuilder setVaccuumPower(String vaccuumPower) {
        this.vaccuumPower = Integer.parseInt(vaccuumPower);
        return this;
    }

    public VaccuumCleanerBuilder setFilterType(String filterType) {
        this.filterType = filterType;
        return this;
    }

    public VaccuumCleanerBuilder setMotorSpeedRegulation(String motorSpeedRegulation) {
        this.motorSpeedRegulation = Integer.parseInt(motorSpeedRegulation);
        return this;
    }

    public VaccuumCleanerBuilder setCleaningWidth(String cleaningWidth) {
        this.cleaningWidth = Integer.parseInt(cleaningWidth);
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String powerConsumption;
        String vaccuumPower;
        String filterType;
        String motorSpeedRegulation;
        String cleaningWidth;

        name = characteristicMap.get(CharacteristicName.VaccuumCleaner.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.VaccuumCleaner.MODEL.getValue());
        powerConsumption = characteristicMap.get(CharacteristicName.VaccuumCleaner.
                POWER_CONSUMPTION.getValue());
        vaccuumPower = characteristicMap.get(CharacteristicName.VaccuumCleaner.VACCUUM_POWER.
                getValue());
        filterType = characteristicMap.get(CharacteristicName.VaccuumCleaner.FILTER_TYPE.
                getValue());
        motorSpeedRegulation = characteristicMap.get(CharacteristicName.VaccuumCleaner.
                MOTOR_SPEED_REGULATION.getValue());
        cleaningWidth = characteristicMap.get(CharacteristicName.VaccuumCleaner.CLEANING_WIDTH.
                getValue());

        setName(name).setModel(model).setPowerConsumption(powerConsumption).
                setVaccuumPower(vaccuumPower).setFilterType(filterType).
                setMotorSpeedRegulation(motorSpeedRegulation).
                setCleaningWidth(cleaningWidth);

        Appliance appliance = new VaccuumCleaner(this.name, this.model, this.powerConsumption,
                this.vaccuumPower, this.filterType, this.motorSpeedRegulation,
                this.cleaningWidth);
        return appliance;
    }
}