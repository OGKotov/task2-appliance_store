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
import com.epam.jwd35.kotov.task2.appliance_store.entity.Laptop;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class LaptopBuilder implements ApplianceBuilder {
    private String name;
    private String model;
    private int batteryCapacity;
    private String os;
    private int memoryRam;
    private int storageMemory;
    private int cpu;
    private double displayInches;

    public LaptopBuilder() {
    }

    public LaptopBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public LaptopBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public LaptopBuilder setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = Integer.parseInt(batteryCapacity);
        return this;
    }

    public LaptopBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public LaptopBuilder setMemoryRam(String memoryRam) {
        this.memoryRam = Integer.parseInt(memoryRam);
        return this;
    }

    public LaptopBuilder setStorageMemory(String storageMemory) {
        this.storageMemory = Integer.parseInt(storageMemory);
        return this;
    }

    public LaptopBuilder setCpu(String cpu) {
        this.cpu = Integer.parseInt(cpu);
        return this;
    }

    public LaptopBuilder setDisplayInches(String displayInches) {
        this.displayInches = Double.parseDouble(displayInches);
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String batteryCapacity;
        String os;
        String memoryRam;
        String storageMemory;
        String cpu;
        String displayInches;

        name = characteristicMap.get(CharacteristicName.Laptop.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.Laptop.MODEL.getValue());
        batteryCapacity = characteristicMap.get(CharacteristicName.Laptop.
                BATTERY_CAPACITY.getValue());
        os = characteristicMap.get(CharacteristicName.Laptop.OS.getValue());
        memoryRam = characteristicMap.get(CharacteristicName.Laptop.MEMORY_RAM.
                getValue());
        storageMemory = characteristicMap.get(CharacteristicName.Laptop.
                STORAGE_MEMORY.getValue());
        cpu = characteristicMap.get(CharacteristicName.Laptop.CPU.getValue());
        displayInches = characteristicMap.get(CharacteristicName.Laptop.DISPLAY_INCHES.
                getValue());

        setName(name).setModel(model).setBatteryCapacity(batteryCapacity).setOs(os).
                setMemoryRam(memoryRam).setStorageMemory(storageMemory).setCpu(cpu).
                setDisplayInches(displayInches);

        Appliance appliance = new Laptop(this.name, this.model, this.batteryCapacity, this.os,
                this.memoryRam, this.storageMemory, this.cpu, this.displayInches);
        return appliance;
    }
}