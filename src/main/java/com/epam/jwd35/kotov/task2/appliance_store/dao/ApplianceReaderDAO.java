/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.dao;

import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import java.util.Set;

public interface ApplianceReaderDAO {
    Set<Appliance> findGoalApplaince(ApplianceCharacteristic characteristicValueList)
            throws RuntimeException;
}
