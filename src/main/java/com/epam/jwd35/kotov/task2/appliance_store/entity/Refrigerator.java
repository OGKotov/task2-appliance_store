/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity;

import java.io.Serializable;

public class Refrigerator extends Appliance implements Serializable {
    private int powerConsumption;
    private double weight;
    private int freezerCapacity;
    private int overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {
    }

    public Refrigerator(String name, String model, int powerConsumption, double weight,
                        int freezerCapacity, int overallCapacity, double height, double width) {
        super(name, model);
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public int getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(int overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Refrigerator that = (Refrigerator) o;

        if (powerConsumption != that.powerConsumption) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (freezerCapacity != that.freezerCapacity) return false;
        if (overallCapacity != that.overallCapacity) return false;
        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + powerConsumption;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + freezerCapacity;
        result = 31 * result + overallCapacity;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}