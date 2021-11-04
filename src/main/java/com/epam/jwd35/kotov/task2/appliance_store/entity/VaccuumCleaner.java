/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity;

public class VaccuumCleaner extends Appliance {
    private int powerConsumption;
    private int vaccuumPower;
    private String filterType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VaccuumCleaner() {
    }

    public VaccuumCleaner(String name, String model, int powerConsumption, int vaccuumPower,
                          String filterType, int motorSpeedRegulation, int cleaningWidth) {
        super(name, model);
        this.powerConsumption = powerConsumption;
        this.vaccuumPower = vaccuumPower;
        this.filterType = filterType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getVaccuumPower() {
        return vaccuumPower;
    }

    public void setVaccuumPower(int vaccuumPower) {
        this.vaccuumPower = vaccuumPower;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VaccuumCleaner that = (VaccuumCleaner) o;

        if (powerConsumption != that.powerConsumption) return false;
        if (vaccuumPower != that.vaccuumPower) return false;
        if (motorSpeedRegulation != that.motorSpeedRegulation) return false;
        if (cleaningWidth != that.cleaningWidth) return false;
        return filterType.equals(that.filterType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + powerConsumption;
        result = 31 * result + vaccuumPower;
        result = 31 * result + filterType.hashCode();
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + cleaningWidth;
        return result;
    }

    @Override
    public String toString() {
        return "VaccuumCleaner{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", vaccuumPower=" + vaccuumPower +
                ", filter_type='" + filterType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}