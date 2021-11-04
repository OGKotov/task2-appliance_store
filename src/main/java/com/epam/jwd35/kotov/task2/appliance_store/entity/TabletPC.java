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

public class TabletPC extends Appliance implements Serializable {
    private int batteryCapacity;
    private double displayInches;
    private int memoryRam;
    private int storageMemory;
    private String color;

    public TabletPC() {
    }

    public TabletPC(String name, String model, int batteryCapacity, double displayInches,
                    int memoryRam, int storageMemory, String color) {
        super(name, model);
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRam = memoryRam;
        this.storageMemory = storageMemory;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(int memoryRam) {
        this.memoryRam = memoryRam;
    }

    public int getStorageMemory() {
        return storageMemory;
    }

    public void setStorageMemory(int storageMemory) {
        this.storageMemory = storageMemory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (batteryCapacity != tabletPC.batteryCapacity) return false;
        if (Double.compare(tabletPC.displayInches, displayInches) != 0) return false;
        if (memoryRam != tabletPC.memoryRam) return false;
        if (storageMemory != tabletPC.storageMemory) return false;
        return color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + batteryCapacity;
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + memoryRam;
        result = 31 * result + storageMemory;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRam=" + memoryRam +
                ", storageMemory=" + storageMemory +
                ", color='" + color + '\'' +
                '}';
    }
}