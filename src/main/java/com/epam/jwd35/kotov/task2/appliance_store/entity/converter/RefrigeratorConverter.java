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
import com.epam.jwd35.kotov.task2.appliance_store.entity.Refrigerator;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class RefrigeratorConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        Refrigerator refrigerator;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof Refrigerator) {
            refrigerator = (Refrigerator) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(refrigerator);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(Refrigerator refrigerator) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.Refrigerator.
                class.getSimpleName());
        if (refrigerator.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.Refrigerator.NAME.getValue(),
                refrigerator.getName());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.MODEL.getValue(),
                refrigerator.getModel());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.POWER_CONSUMPTION.getValue(),
                refrigerator.getPowerConsumption());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.WEIGHT.getValue(),
                refrigerator.getWeight());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.FREEZER_CAPACITY.getValue(),
                refrigerator.getFreezerCapacity());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.OVERALL_CAPACITY.getValue(),
                refrigerator.getOverallCapacity());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.HEIGHT.getValue(),
                refrigerator.getHeight());
        applianceCharacteristic.add(CharacteristicName.Refrigerator.WIDTH.getValue(),
                refrigerator.getWidth());
        return applianceCharacteristic;
    }
}