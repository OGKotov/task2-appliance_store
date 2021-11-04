/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.builder;

import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Speaker;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.Map;

public class SpeakerBuilder implements ApplianceBuilder {
    private String name;
    private String model;
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public SpeakerBuilder() {
    }

    public SpeakerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SpeakerBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public SpeakerBuilder setPowerConsumption(String powerConsumption) {
        this.powerConsumption = Integer.parseInt(powerConsumption);
        return this;
    }

    public SpeakerBuilder setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = Integer.parseInt(numberOfSpeakers);
        return this;
    }

    public SpeakerBuilder setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
        return this;
    }

    public SpeakerBuilder setCordLength(String cordLength) {
        this.cordLength = Integer.parseInt(cordLength);
        return this;
    }

    @Override
    public Appliance build(Map<String, String> characteristicMap) {
        String name;
        String model;
        String powerConsumption;
        String numberOfSpeakers;
        String frequencyRange;
        String cordLength;

        name = characteristicMap.get(CharacteristicName.Speaker.NAME.getValue());
        model = characteristicMap.get(CharacteristicName.Speaker.MODEL.getValue());
        powerConsumption= characteristicMap.get(CharacteristicName.Speaker.POWER_CONSUMPTION.
                getValue());
        numberOfSpeakers = characteristicMap.get(CharacteristicName.Speaker.NUMBER_OF_SPEAKERS.
                getValue());
        frequencyRange = characteristicMap.get(CharacteristicName.Speaker.FREQUENCY_RANGE.
                getValue());
        cordLength = characteristicMap.get(CharacteristicName.Speaker.CORD_LENGTH.getValue());

        setName(name).setModel(model).setPowerConsumption(powerConsumption).
                setNumberOfSpeakers(numberOfSpeakers).setFrequencyRange(frequencyRange).
                setCordLength(cordLength);

        Appliance appliance = new Speaker(this.name, this.model, this.powerConsumption,
                this.numberOfSpeakers, this.frequencyRange, this.cordLength);
        return appliance;
    }
}