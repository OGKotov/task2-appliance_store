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
import com.epam.jwd35.kotov.task2.appliance_store.entity.Speaker;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;

public class SpeakerConverter implements ApplianceConverter {

    @Override
    public ApplianceCharacteristic convertToApplianceCharacteristic(Appliance appliance) {
        Speaker speaker;
        ApplianceCharacteristic applianceCharacteristic;

        if (appliance instanceof Speaker) {
            speaker = (Speaker) appliance;
        } else {
            throw new RuntimeException("Converter is not selected correctly");
        }
        applianceCharacteristic = createApplianceCharacteristic(speaker);
        return applianceCharacteristic;
    }

    private ApplianceCharacteristic createApplianceCharacteristic(Speaker speaker) {
        ApplianceCharacteristic applianceCharacteristic;

        applianceCharacteristic = new ApplianceCharacteristic(CharacteristicName.Speaker.
                class.getSimpleName());
        if (speaker.getName() == null) {
            return applianceCharacteristic;
        }
        applianceCharacteristic.add(CharacteristicName.Speaker.NAME.getValue(),
                speaker.getName());
        applianceCharacteristic.add(CharacteristicName.Speaker.MODEL.getValue(),
                speaker.getModel());
        applianceCharacteristic.add(CharacteristicName.Speaker.POWER_CONSUMPTION.getValue(),
                speaker.getPowerConsumption());
        applianceCharacteristic.add(CharacteristicName.Speaker.NUMBER_OF_SPEAKERS.getValue(),
                speaker.getNumberOfSpeakers());
        applianceCharacteristic.add(CharacteristicName.Speaker.FREQUENCY_RANGE.getValue(),
                speaker.getFrequencyRange());
        applianceCharacteristic.add(CharacteristicName.Speaker.CORD_LENGTH.getValue(),
                speaker.getCordLength());
        return applianceCharacteristic;
    }
}