/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.converter;

import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Laptop;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class LaptopConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        Laptop laptop;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof Laptop) {
            laptop = (Laptop) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(laptop);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(Laptop laptop) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.Laptop.
                class.getSimpleName());
        if (laptop.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.Laptop.NAME.getValue(),
                laptop.getName());
        applianceCharacteristic.add(CharacteristicName.Laptop.MODEL.getValue(),
                laptop.getModel());
        applianceCharacteristic.add(CharacteristicName.Laptop.BATTERY_CAPACITY.getValue(),
                laptop.getBatteryCapacity());
        applianceCharacteristic.add(CharacteristicName.Laptop.OS.getValue(),
                laptop.getOs());
        applianceCharacteristic.add(CharacteristicName.Laptop.MEMORY_RAM.getValue(),
                laptop.getMemoryRam());
        applianceCharacteristic.add(CharacteristicName.Laptop.STORAGE_MEMORY.getValue(),
                laptop.getStorageMemory());
        applianceCharacteristic.add(CharacteristicName.Laptop.CPU.getValue(),
                laptop.getCpu());
        applianceCharacteristic.add(CharacteristicName.Laptop.DISPLAY_INCHES.getValue(),
                laptop.getDisplayInches());
        return applianceCharacteristic;
    }
}