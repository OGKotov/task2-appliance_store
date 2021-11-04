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
import com.epam.jwd35.kotov.task2.appliance_store.entity.TabletPC;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class TabletPCConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        TabletPC tabletPC;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof TabletPC) {
            tabletPC = (TabletPC) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(tabletPC);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(TabletPC tabletPC) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.TabletPC.
                class.getSimpleName());
        if (tabletPC.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.TabletPC.NAME.getValue(),
                tabletPC.getName());
        applianceCharacteristic.add(CharacteristicName.TabletPC.MODEL.getValue(),
                tabletPC.getModel());
        applianceCharacteristic.add(CharacteristicName.TabletPC.BATTERY_CAPACITY.getValue(),
                tabletPC.getBatteryCapacity());
        applianceCharacteristic.add(CharacteristicName.TabletPC.DISPLAY_INCHES.getValue(),
                tabletPC.getDisplayInches());
        applianceCharacteristic.add(CharacteristicName.TabletPC.MEMORY_RAM.getValue(),
                tabletPC.getMemoryRam());
        applianceCharacteristic.add(CharacteristicName.TabletPC.STORAGE_MEMORY.getValue(),
                tabletPC.getStorageMemory());
        applianceCharacteristic.add(CharacteristicName.TabletPC.COLOR.getValue(),
                tabletPC.getColor());
        return applianceCharacteristic;
    }
}