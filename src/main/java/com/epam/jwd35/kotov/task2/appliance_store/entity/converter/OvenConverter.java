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
import com.epam.jwd35.kotov.task2.appliance_store.entity.Oven;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class OvenConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        Oven oven;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof Oven) {
            oven = (Oven) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(oven);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(Oven oven) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.Oven.
                class.getSimpleName());
        if (oven.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.Oven.NAME.getValue(),
                oven.getName());
        applianceCharacteristic.add(CharacteristicName.Oven.MODEL.getValue(),
                oven.getModel());
        applianceCharacteristic.add(CharacteristicName.Oven.POWER_CONSUMPTION.getValue(),
                oven.getPowerConsumption());
        applianceCharacteristic.add(CharacteristicName.Oven.WEIGHT.getValue(),
                oven.getWeight());
        applianceCharacteristic.add(CharacteristicName.Oven.CAPACITY.getValue(),
                oven.getCapacity());
        applianceCharacteristic.add(CharacteristicName.Oven.DEPTH.getValue(),
                oven.getDepth());
        applianceCharacteristic.add(CharacteristicName.Oven.HEIGHT.getValue(),
                oven.getHeight());
        applianceCharacteristic.add(CharacteristicName.Oven.WIDTH.getValue(),
                oven.getWidth());
        return applianceCharacteristic;
    }
}