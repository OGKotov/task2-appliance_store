/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.converter;

import com.epam.jwd35.kotov.task2.appliance_store.entity.*;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;

public class ConverterManager {

    public static ApplianceConverter selectConverter(Appliance appliance) throws
            RuntimeException {
        ApplianceConverter applianceConverter = null;

        if (appliance instanceof Laptop) {
            return new LaptopConverter();
        }
        if (appliance instanceof Oven) {
            return new OvenConverter();
        }
        if (appliance instanceof Refrigerator) {
            return new RefrigeratorConverter();
        }
        if (appliance instanceof Speaker) {
            return new SpeakerConverter();
        }
        if (appliance instanceof TabletPC) {
            return new TabletPCConverter();
        }
        if (appliance instanceof VaccuumCleaner) {
            return new VaccuumCleanerConverter();
        }

        if (applianceConverter == null) {
            throw new RuntimeException("Converter is not selected correctly");
        }
        return applianceConverter;
    }
}