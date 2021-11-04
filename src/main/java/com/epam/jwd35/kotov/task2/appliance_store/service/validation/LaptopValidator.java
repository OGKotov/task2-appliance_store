/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.service.validation;

import static com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName.Laptop;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import java.util.Map;

public class LaptopValidator extends Validator{
    public static final int BATTERY_CAPACITY_MIN = 2000;
    public static final int BATTERY_CAPACITY_MAX = 12000;
    public static final String OS_NAME1_REGEXP = "Linux";
    public static final String OS_NAME2_REGEXP = "Windows";
    public static final String OS_NAME3_REGEXP = "Mac OS";
    public static final String OS_NAME4_REGEXP = "Dos";
    public static final int MEMORY_RAM_MIN = 1;
    public static final int MEMORY_RAM_MAX = 128;
    public static final int STORAGE_MEMORY_MIN = 32;
    public static final int STORAGE_MEMORY_MAX = 4000;
    public static final int CPU_MIN = 800;
    public static final int CPU_MAX = 3800;
    public static final double DISPLAY_INCHES_MIN = 11.6;
    public static final double DISPLAY_INCHES_MAX = 18.4;
    public static final String DISPLAY_INCHES_REGEXP = "(\\d{2})(\\.?)(\\d?)";


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

            if(applianceCharacteristic.equals(Laptop.NAME.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(Laptop.MODEL.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(Laptop.BATTERY_CAPACITY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidBatteryCapacity((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Laptop.OS.getValue())) {
                if (!(characterisitcValue instanceof String)) {
                    return false;
                }
                validValue &= isValidOS((String) characterisitcValue);
            } else if (applianceCharacteristic.equals(Laptop.MEMORY_RAM.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidMemoryRam((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Laptop.STORAGE_MEMORY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidStorageMemory((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Laptop.CPU.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidCpu((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Laptop.DISPLAY_INCHES.getValue())) {
                if (!(characterisitcValue instanceof Number)) {
                    return false;
                }
                validValue &= isValidDisplayInches(((Number) characterisitcValue).doubleValue());
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

    public boolean isValidOS(String os) {
        boolean validValue;

        validValue = os.matches(OS_NAME1_REGEXP) || os.matches(OS_NAME2_REGEXP)
                     || os.matches(OS_NAME3_REGEXP) || os.matches(OS_NAME4_REGEXP);
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

    public boolean isValidCpu(int cpu) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(cpu, CPU_MIN, CPU_MAX);
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
}