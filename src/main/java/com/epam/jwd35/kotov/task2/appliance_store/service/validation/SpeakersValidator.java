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

public class SpeakersValidator extends Validator{
    public static final int POWER_CONSUMPTION_MIN = 5;
    public static final int POWER_CONSUMPTION_MAX = 4000;
    public static final int NUMBER_OF_SPEAKERS_MIN = 1;
    public static final int NUMBER_OF_SPEAKERS_MAX = 7;
    public static final String FREQUENCY_RANGE_REGEXP = "(\\d{1,4})(-)(\\d{1,5})";
    public static final String FREQUENCY_RANGE_DELIMITER_REGEXP = "(-)";
    public static final int LOWER_FREQUENCY_MIN = 2;
    public static final int LOWER_FREQUENCY_MAX = 7500;
    public static final int UPPER_FREQUENCY_MIN = 80;
    public static final int UPPER_FREQUENCY_MAX = 50000;
    public static final int CORD_LENGTH_MIN = 1;
    public static final int CORD_LENGTH_MAX = 10;


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

            if(applianceCharacteristic.equals(CharacteristicName.Speaker.NAME.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.Speaker.MODEL.getValue())) {
                validValue &= true;
            } else if (applianceCharacteristic.equals(CharacteristicName.Speaker.POWER_CONSUMPTION.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidPowerConsumption((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.Speaker.NUMBER_OF_SPEAKERS.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidNumberOfSpeakers((Integer) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.Speaker.FREQUENCY_RANGE.getValue())) {
                if (!(characterisitcValue instanceof String)) {
                    return false;
                }
                validValue &= isValidFrequencyRange((String) characterisitcValue);
            } else if (applianceCharacteristic.equals(CharacteristicName.Speaker.CORD_LENGTH.getValue())) {
                if (!(characterisitcValue instanceof Integer)) {
                    return false;
                }
                validValue &= isValidCordLength((Integer) characterisitcValue);
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

    public boolean isValidNumberOfSpeakers(int numberOfSpeakers) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(numberOfSpeakers, NUMBER_OF_SPEAKERS_MIN,
                NUMBER_OF_SPEAKERS_MAX);
        return validValue;
    }

    public boolean isValidFrequencyRange(String frequencyRange) {
        boolean validValue;
        String [] frequency;
        int lowerFrequency;
        int upperFrequency;

        frequency = frequencyRange.trim().split(FREQUENCY_RANGE_DELIMITER_REGEXP);
        if (frequencyRange.matches(FREQUENCY_RANGE_REGEXP)) {
            validValue = true;
            lowerFrequency = Integer.valueOf(frequency[0]);
            upperFrequency = Integer.valueOf(frequency[1]);
        } else {
            return false;
        }

        if (lowerFrequency >= upperFrequency) {
            return false;
        }

        validValue &= isValueBeetwenMaxMin(lowerFrequency, LOWER_FREQUENCY_MIN,
                LOWER_FREQUENCY_MAX);
        validValue &= isValueBeetwenMaxMin(upperFrequency, UPPER_FREQUENCY_MIN,
                UPPER_FREQUENCY_MAX);
        return validValue;
    }

    public boolean isValidCordLength(int cordLength) {
        boolean validValue;

        validValue = isValueBeetwenMaxMin(cordLength, CORD_LENGTH_MIN,
                CORD_LENGTH_MAX);
        return validValue;
    }
}