/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.service.validation;

import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class VaccuumCleanerValidator extends Validator {
    public static final int POWER_CONSUMPTION_MIN = 10;
    public static final int POWER_CONSUMPTION_MAX = 3600;
    public static final int VACCUUM_POWER_MIN = 7;
    public static final int VACCUUM_POWER_MAX = 750;
    public static final String FILTER_TYPE_REGEXP = "[A-Da-d]";
    public static final int MOTOR_SPEED_REGULATION_MIN = 500;
    public static final int MOTOR_SPEED_REGULATION_MAX = 5000;
    public static final int CLEANING_WIDTH_MIN = 10;
    public static final int CLEANING_WIDTH_MAX = 70;

    @Override
    public boolean isValidData(ApplianceCharacteristic applianceCharacteristic) {
        if (isEmptyCharacteristicValueList(applianceCharacteristic)
                && isValidCharacteristic(applianceCharacteristic)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidCharacteristic(ApplianceCharacteristic characteristicValueList) {
        boolean validValue;
        String applianceCharacteristic;
        Object characterisitcValue;
        Map<String, Object> criteriaSet;

        criteriaSet = characteristicValueList.getValueList();
        validValue = true;

        for (Map.Entry entry: criteriaSet.entrySet()) {
            applianceCharacteristic = (String) entry.getKey();
            characterisitcValue = entry.getValue();

            if(applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.NAME.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.MODEL.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.POWER_CONSUMPTION.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidPowerConsumption((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.VACCUUM_POWER.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidVaccuumPower((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.FILTER_TYPE.getValue())) {
                if (!(characterisitcValue instanceof String)) {
                    return false;
                }
                validValue &= isValidFilterType((String) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.MOTOR_SPEED_REGULATION.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidMotorSpeedRegulation((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.VaccuumCleaner.CLEANING_WIDTH.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidCleaningWidth((Integer) characterisitcValue);
            } else {
                return false;
            }
        }
        return validValue;
    }

    public boolean isValidPowerConsumption(int powerConsumption) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(powerConsumption, POWER_CONSUMPTION_MIN,
                POWER_CONSUMPTION_MAX);
        return validValue;
    }

    public boolean isValidVaccuumPower(int vaccuumPower) {
        boolean validValue;
        validValue = isValueBeetwenMaxMin(vaccuumPower, VACCUUM_POWER_MIN,
                VACCUUM_POWER_MAX);
        return validValue;
    }

    public boolean isValidFilterType(String filterType) {
        boolean validValue;

        validValue = filterType.matches(FILTER_TYPE_REGEXP);
        return validValue;
    }

    public boolean isValidMotorSpeedRegulation(int motorSpeedRegulation) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(motorSpeedRegulation, MOTOR_SPEED_REGULATION_MIN,
                MOTOR_SPEED_REGULATION_MAX);
        return validValue;
    }

    public boolean isValidCleaningWidth(int cleaningWidth) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(cleaningWidth, CLEANING_WIDTH_MIN,
                CLEANING_WIDTH_MAX);
        return validValue;
    }
}