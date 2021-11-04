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
import java.util.HashMap;
import java.util.Map;

public final class ValidatorProvider {
    private final Map<String, Validator> repository = new HashMap<>();

    public ValidatorProvider() {
        repository.put(CharacteristicName.Oven.class.getSimpleName(), new OvenValidator());
        repository.put(CharacteristicName.Laptop.class.getSimpleName(), new LaptopValidator());
        repository.put(CharacteristicName.Refrigerator.class.getSimpleName(), new RefrigeratorValidator());
        repository.put(CharacteristicName.VaccuumCleaner.class.getSimpleName(), new VaccuumCleanerValidator());
        repository.put(CharacteristicName.TabletPC.class.getSimpleName(), new TabletPCValidator());
        repository.put(CharacteristicName.Speaker.class.getSimpleName(), new SpeakersValidator());
    }

    public Validator getValidator (ApplianceCharacteristic characteristicValueList) {
        String validatorName;
        Validator validator;

        validatorName = characteristicValueList.getApplinceTitle();
        validator = repository.get(validatorName);
        return validator;
    }
}