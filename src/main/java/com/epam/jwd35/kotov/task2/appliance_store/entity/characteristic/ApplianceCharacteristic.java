/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApplianceCharacteristic {
    private String applinceTitle;
    private Map<String, Object> valueList = new LinkedHashMap<>();

    public ApplianceCharacteristic(String groupSearchName) {
        this.applinceTitle = groupSearchName;
    }

    public String getApplinceTitle() {
        return applinceTitle;
    }

    public Map<String, Object> getValueList() {
        return valueList;
    }

    public void add(String characterisitcName, Object characteristicValue) {
        valueList.put(characterisitcName, characteristicValue);
    }
}