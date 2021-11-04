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
import com.epam.jwd35.kotov.task2.appliance_store.entity.TabletPC;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class TabletPCBuilder implements ApplianceBuilder{
    private String name;
    private String model;
    private int batteryCapacity;
    private double displayInches;
    private int memoryRam;
    private int storageMemory;
    private String color;

    public TabletPCBuilder() {
    }

    public TabletPCBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TabletPCBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public TabletPCBuilder setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = Integer.parseInt(batteryCapacity);
        return this;
    }

    public TabletPCBuilder setDisplayInches(String displayInches) {
        this.displayInches = Double.parseDouble(displayInches);
        return this;
    }

    public TabletPCBuilder setMemoryRam(String memoryRam) {
        this.memoryRam = Integer.parseInt(memoryRam);
        return this;
    }

    public TabletPCBuilder setStorageMemory(String storageMemory) {
        this.storageMemory = Integer.parseInt(storageMemory);
        return this;
    }

    public TabletPCBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String batteryCapacity;
        String displayInches;
        String memoryRam;
        String storageMemory;
        String color;

        name = characteristicMap.get(CharacteristicName.TabletPC.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.TabletPC.MODEL.getValue());
        batteryCapacity = characteristicMap.get(CharacteristicName.TabletPC.BATTERY_CAPACITY.
                getValue());
        displayInches = characteristicMap.get(CharacteristicName.TabletPC.DISPLAY_INCHES.
                getValue());
        memoryRam = characteristicMap.get(CharacteristicName.TabletPC.MEMORY_RAM.getValue());
        storageMemory = characteristicMap.get(CharacteristicName.TabletPC.STORAGE_MEMORY.
                getValue());
        color = characteristicMap.get(CharacteristicName.TabletPC.COLOR.getValue());

        setName(name).setModel(model).setBatteryCapacity(batteryCapacity).
                setDisplayInches(displayInches).setMemoryRam(memoryRam).
                setStorageMemory(storageMemory).setColor(color);

        Appliance appliance = new TabletPC(this.name, this.model, this.batteryCapacity,
                this.displayInches, this.memoryRam, this.storageMemory, this.color);
        return appliance;
    }
}