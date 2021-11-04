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

public class Laptop extends Appliance implements Serializable {
    private int batteryCapacity;
    private String os;
    private int memoryRam;
    private int storageMemory;
    private int cpu;
    private double displayInches;

    public Laptop() {
    }

    public Laptop(String name, String model, int batteryCapacity, String os, int memoryRam,
                  int storageMemory, int cpu, double displayInches) {
        super(name, model);
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRam = memoryRam;
        this.storageMemory = storageMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (batteryCapacity != laptop.batteryCapacity) return false;
        if (memoryRam != laptop.memoryRam) return false;
        if (storageMemory != laptop.storageMemory) return false;
        if (cpu != laptop.cpu) return false;
        if (Double.compare(laptop.displayInches, displayInches) != 0) return false;
        return os.equals(laptop.os);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + batteryCapacity;
        result = 31 * result + os.hashCode();
        result = 31 * result + memoryRam;
        result = 31 * result + storageMemory;
        result = 31 * result + cpu;
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryRam=" + memoryRam +
                ", storageMemory=" + storageMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }
}