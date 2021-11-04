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

public class TabletPCValidator extends Validator {
    public static final int BATTERY_CAPACITY_MIN = 2000;
    public static final int BATTERY_CAPACITY_MAX = 10500;
    public static final double DISPLAY_INCHES_MIN = 5;
    public static final double DISPLAY_INCHES_MAX = 17.3;
    public static final String DISPLAY_INCHES_REGEXP = "(\\d{2})(\\.?)(\\d?)";
    public static final int MEMORY_RAM_MIN = 1;
    public static final int MEMORY_RAM_MAX = 16;
    public static final int STORAGE_MEMORY_MIN = 4;
    public static final int STORAGE_MEMORY_MAX = 2000;
    public static final String WHITE_REGEXP = "White";
    public static final String BLACK_REGEXP = "Black";
    public static final String RED_REGEXP = "Red";
    public static final String GREY_REGEXP = "Grey";
    public static final String GREEN_REGEXP = "Green";
    public static final String PINK_REGEXP = "Pink";
    public static final String YELOW_REGEXP = "Yelow";
    public static final String BROWN_REGEXP = "Brown";
    public static final String GOLD_REGEXP = "Gold";
    public static final String SILVER_REGEXP = "Silver";

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

            if(applianceCharacteristic.equals(CharacteristicName.TabletPC.NAME.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.MODEL.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.BATTERY_CAPACITY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidBatteryCapacity((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.DISPLAY_INCHES.getValue())) {
                if (!(characterisitcValue instanceof Number)) {
                    return false;
                }
                validValue &= isValidDisplayInches(((Number) characterisitcValue).doubleValue());
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.MEMORY_RAM.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidMemoryRam((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.STORAGE_MEMORY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidStorageMemory((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.TabletPC.COLOR.getValue())) {
                if (!(characterisitcValue instanceof String)) {
                    return false;
                }
                validValue &= isValidColor((String) characterisitcValue);
            } else {
                return false;
            }
        }
        return validValue;
    }

    public boolean isValidBatteryCapacity(int batteryCapacity) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(batteryCapacity, BATTERY_CAPACITY_MIN,
                BATTERY_CAPACITY_MAX);
        return validValue;
    }

    public boolean isValidDisplayInches(double displayInches) {
        boolean validValue;
        String displayInchesStr;

        displayInchesStr = Double.toString(displayInches);
        validValue = isValueBeetwenMaxMin(displayInches, DISPLAY_INCHES_MIN,
                DISPLAY_INCHES_MAX) && displayInchesStr.matches(DISPLAY_INCHES_REGEXP);
        return validValue;
    }

    public boolean isValidMemoryRam(int memoryRam) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(memoryRam, MEMORY_RAM_MIN, MEMORY_RAM_MAX);
        return validValue;
    }

    public boolean isValidStorageMemory(int storageMemory) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(storageMemory, STORAGE_MEMORY_MIN, STORAGE_MEMORY_MAX);
        return validValue;
    }

    public boolean isValidColor(String color) {
        boolean validValue;

        validValue = color.matches(WHITE_REGEXP) || color.matches(BLACK_REGEXP)
                     || color.matches(RED_REGEXP) || color.matches(GREEN_REGEXP)
                     || color.matches(GREY_REGEXP) || color.matches(PINK_REGEXP)
                     || color.matches(YELOW_REGEXP) || color.matches(BROWN_REGEXP)
                     || color.matches(GOLD_REGEXP) || color.matches(SILVER_REGEXP);
        return validValue;
    }
}