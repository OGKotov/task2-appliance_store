/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity;

public class Appliance {
    String name;
    String model;

    public Appliance() {
    }

    public Appliance(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliance appliance = (Appliance) o;

        if (!name.equals(appliance.name)) return false;
        return model.equals(appliance.model);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}