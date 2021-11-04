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
import java.util.Map;

public abstract class Validator {

    public abstract boolean isValidData(ApplianceCharacteristic applianceCharacteristic);

    public boolean isValueBeetwenMaxMin (int value, int minValue, int maxValue) {
        boolean validValue;
        validValue = (value >= minValue && value <= maxValue);
        return validValue;
    }

    public boolean isValueBeetwenMaxMin (double value, double minValue, double maxValue) {
        boolean validValue;
        validValue = (Double.compare((value), minValue) >= 0
                     && Double.compare(value, maxValue) <= 0);
        return validValue;
    }

    public boolean isEmptyCharacteristicValueList(ApplianceCharacteristic applianceCharacteristic) {
        Map<String, Object> valueList;

        valueList = applianceCharacteristic.getValueList();
        return (valueList.isEmpty()) ? false : true;
    }
}