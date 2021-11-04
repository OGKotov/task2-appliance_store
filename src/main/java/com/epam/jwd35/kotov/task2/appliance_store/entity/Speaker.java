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

public class Speaker extends Appliance implements Serializable {
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speaker() {
    }

    public Speaker(String name, String model, int powerConsumption, int numberOfSpeakers,
                   String frequencyRange, int cordLength) {
        super(name, model);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Speaker speaker = (Speaker) o;

        if (powerConsumption != speaker.powerConsumption) return false;
        if (numberOfSpeakers != speaker.numberOfSpeakers) return false;
        if (cordLength != speaker.cordLength) return false;
        return frequencyRange.equals(speaker.frequencyRange);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + powerConsumption;
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + frequencyRange.hashCode();
        result = 31 * result + cordLength;
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}