/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.service.validation;

import static com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName.Refrigerator;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import java.util.Map;

public class RefrigeratorValidator extends Validator{
    public static final int POWER_CONSUMPTION_MIN = 20;
    public static final int POWER_CONSUMPTION_MAX = 500;
    public static final double WEIGH_MIN =4;
    public static final double WEIGH_MAX = 200;
    public static final String WEIGHT_REGEXP = "(\\d{2})(\\.?)(\\d?)";
    public static final int FREEZER_CAPACITY_MIN = 3;
    public static final int FREEZER_CAPACITY_MAX = 600;
    public static final int OVERALL_CAPACITY_MIN = 20;
    public static final int OVERALL_CAPACITY_MAX = 600;
    public static final double HEIGHT_MIN = 30;
    public static final double HEIGHT_MAX = 221;
    public static final double WIDTH_MIN = 25;
    public static final double WIDTH_MAX = 204;
    public static final String DIMENSIONS_REGEXP = "(\\d{2})(\\.?)(\\d?)";

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

            if(applianceCharacteristic.equals(Refrigerator.NAME.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(Refrigerator.MODEL.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(Refrigerator.POWER_CONSUMPTION.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidPowerConsumption((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Refrigerator.WEIGHT.getValue())) {
                if (!(characterisitcValue instanceof Number)) {
                    return false;
                }
                validValue &= isValidWeight(((Number) characterisitcValue).doubleValue());
            } else if (applianceCharacteristic.equals(Refrigerator.FREEZER_CAPACITY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidFreezerCapacity((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Refrigerator.OVERALL_CAPACITY.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidOverallCapacity((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(Refrigerator.HEIGHT.getValue())) {
                if (!(characterisitcValue instanceof Number)) {
                    return false;
                }
                validValue &= isValidHeight(((Number) characterisitcValue).doubleValue());
            } else if (applianceCharacteristic.equals(Refrigerator.WIDTH.getValue())) {
                if (!(characterisitcValue instanceof Number)) {
                    return false;
                }
                validValue &= isValidWidth(((Number) characterisitcValue).doubleValue());
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

    public boolean isValidWeight(double weight) {
        boolean validValue;
        String weightStr;

        weightStr = Double.toString(weight);
        validValue = isValueBeetwenMaxMin(weight, WEIGH_MIN, WEIGH_MAX)
                && weightStr.matches(WEIGHT_REGEXP);
        return validValue;
    }

    public boolean isValidFreezerCapacity(int freezerCapacity) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(freezerCapacity, FREEZER_CAPACITY_MIN,
                FREEZER_CAPACITY_MAX);
        return validValue;
    }

    public boolean isValidOverallCapacity(int overallCapacity) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(overallCapacity, OVERALL_CAPACITY_MIN,
                OVERALL_CAPACITY_MAX);
        return validValue;
    }

    public boolean isValidHeight(double height) {
        boolean validValue;
        String heightStr;

        heightStr = Double.toString(height);
        validValue = isValueBeetwenMaxMin(height, HEIGHT_MIN, HEIGHT_MAX)
                && heightStr.matches(DIMENSIONS_REGEXP);
        return validValue;
    }

    public boolean isValidWidth(double width) {
        boolean validValue;
        String widthtStr;

        widthtStr = Double.toString(width);
        validValue = isValueBeetwenMaxMin(width, WIDTH_MIN, WIDTH_MAX)
                && widthtStr.matches(DIMENSIONS_REGEXP);
        return validValue;
    }
}