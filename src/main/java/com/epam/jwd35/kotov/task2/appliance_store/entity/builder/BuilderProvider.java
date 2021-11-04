/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.builder;

import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import java.util.HashMap;
import java.util.Map;

public class BuilderProvider {
    private final Map<String, ApplianceBuilder> repository = new HashMap<>();

    public BuilderProvider() {
        repository.put(CharacteristicName.Oven.class.getSimpleName(), new OvenBuilder());
        repository.put(CharacteristicName.Laptop.class.getSimpleName(), new LaptopBuilder());
        repository.put(CharacteristicName.Refrigerator.class.getSimpleName(), new RefrigeratorBuilder());
        repository.put(CharacteristicName.VaccuumCleaner.class.getSimpleName(), new VaccuumCleanerBuilder());
        repository.put(CharacteristicName.TabletPC.class.getSimpleName(), new TabletPCBuilder());
        repository.put(CharacteristicName.Speaker.class.getSimpleName(), new SpeakerBuilder());
    }

    public ApplianceBuilder getBuilder(ApplianceCharacteristic characteristicValueList) {
        String builderName;
        ApplianceBuilder builder;

        builderName = characteristicValueList.getApplinceTitle();
        builder = repository.get(builderName);
        return builder;
    }
}