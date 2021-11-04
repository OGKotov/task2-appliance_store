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
import com.epam.jwd35.kotov.task2.appliance_store.entity.VaccuumCleaner;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class VaccuumCleanerConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        VaccuumCleaner vaccuumCleaner;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof VaccuumCleaner) {
            vaccuumCleaner = (VaccuumCleaner) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(vaccuumCleaner);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(VaccuumCleaner vaccuumCleaner) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.VaccuumCleaner.
                class.getSimpleName());
        if (vaccuumCleaner.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.NAME.getValue(),
                vaccuumCleaner.getName());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.MODEL.getValue(),
                vaccuumCleaner.getModel());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.POWER_CONSUMPTION.getValue(),
                vaccuumCleaner.getPowerConsumption());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.VACCUUM_POWER.getValue(),
                vaccuumCleaner.getVaccuumPower());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.FILTER_TYPE.getValue(),
                vaccuumCleaner.getFilterType());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.MOTOR_SPEED_REGULATION.getValue(),
                vaccuumCleaner.getMotorSpeedRegulation());
        applianceCharacteristic.add(CharacteristicName.VaccuumCleaner.CLEANING_WIDTH.getValue(),
                vaccuumCleaner.getCleaningWidth());
        return applianceCharacteristic;
    }
}