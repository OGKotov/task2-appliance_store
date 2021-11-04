/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.main;

import com.epam.jwd35.kotov.task2.appliance_store.entity.*;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.CharacteristicName;
import com.epam.jwd35.kotov.task2.appliance_store.service.ApplianceService;
import com.epam.jwd35.kotov.task2.appliance_store.service.ServiceFactory;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Appliance appliance;
        ServiceFactory serviceFactory;
        ApplianceService applianceService;
        Set<Appliance> applianceList;

        serviceFactory = ServiceFactory.getInstance();
        applianceService = serviceFactory.getApplianceService();

        ApplianceCharacteristic laptopCharacteristic = new ApplianceCharacteristic(Laptop.class.getSimpleName());
        laptopCharacteristic.add(CharacteristicName.Laptop.BATTERY_CAPACITY.getValue(), 7500);
        laptopCharacteristic.add(CharacteristicName.Laptop.OS.getValue(), "Linux");
        laptopCharacteristic.add(CharacteristicName.Laptop.MEMORY_RAM.getValue(), 16);
        try {
            applianceList = applianceService.findSearchAppliance(laptopCharacteristic);
            PrintApplianceInfo.printMassagerForSearch(applianceList);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForSearch(e);
        }

        ApplianceCharacteristic ovenCharacteristic = new ApplianceCharacteristic(CharacteristicName.Oven.class.getSimpleName());
        ovenCharacteristic.add(CharacteristicName.Oven.CAPACITY.getValue(), 58);
        ovenCharacteristic.add(CharacteristicName.Oven.WEIGHT.getValue(), 25);
        ovenCharacteristic.add(CharacteristicName.Oven.WIDTH.getValue(), 59.8);
         try {
            applianceList = applianceService.findSearchAppliance(ovenCharacteristic);
            PrintApplianceInfo.printMassagerForSearch(applianceList);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForSearch(e);
        }

        ApplianceCharacteristic speackerCharacteristic = new ApplianceCharacteristic(CharacteristicName.Speaker.class.getSimpleName());
        speackerCharacteristic.add(CharacteristicName.Speaker.CORD_LENGTH.getValue(), 4);
        speackerCharacteristic.add(CharacteristicName.Speaker.NUMBER_OF_SPEAKERS.getValue(), 4);
        speackerCharacteristic.add(CharacteristicName.Speaker.FREQUENCY_RANGE.getValue(), "75-20000");
        try {
            applianceList = applianceService.findSearchAppliance(speackerCharacteristic);
            PrintApplianceInfo.printMassagerForSearch(applianceList);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForSearch(e);
        }

        ApplianceCharacteristic tabletPCCharacteristic = new ApplianceCharacteristic(TabletPC.class.getSimpleName());
        tabletPCCharacteristic.add(CharacteristicName.TabletPC.BATTERY_CAPACITY.getValue(), 1);
        tabletPCCharacteristic.add(CharacteristicName.TabletPC.DISPLAY_INCHES.getValue(), 11);
        tabletPCCharacteristic.add(CharacteristicName.TabletPC.COLOR.getValue(), "Black");
        try {
            applianceList = applianceService.findSearchAppliance(tabletPCCharacteristic);
            PrintApplianceInfo.printMassagerForSearch(applianceList);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForSearch(e);
        }

        ApplianceCharacteristic vaccuumCleanerCharacteristic = new ApplianceCharacteristic(CharacteristicName.VaccuumCleaner.class.getSimpleName());
        vaccuumCleanerCharacteristic.add(CharacteristicName.VaccuumCleaner.VACCUUM_POWER.getValue(), 200);
        vaccuumCleanerCharacteristic.add(CharacteristicName.VaccuumCleaner.FILTER_TYPE.getValue(), "C");
        vaccuumCleanerCharacteristic.add(CharacteristicName.VaccuumCleaner.POWER_CONSUMPTION.getValue(), 999);
        try {
            applianceList = applianceService.findSearchAppliance(vaccuumCleanerCharacteristic);
            PrintApplianceInfo.printMassagerForSearch(applianceList);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForSearch(e);
        }


        Laptop laptop = new Laptop("Asus", "RE45", 100, "Dos", 8,
                1000, 2000, 15);
        try {
            appliance = applianceService.addAppliance(laptop);
            PrintApplianceInfo.printMassagerForAdding(appliance);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForAdding(laptop, e);
        }

        Speaker speaker = new Speaker("JBL", "R34", 30, 2, "50-20000", 5);
        try {
            appliance = applianceService.addAppliance(speaker);
            PrintApplianceInfo.printMassagerForAdding(appliance);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForAdding(speaker, e);
        }

        Oven oven = new Oven("Samsung", "R36", 1000, 20, 50, 45, 60, 60);
        try {
            appliance = applianceService.addAppliance(oven);
            PrintApplianceInfo.printMassagerForAdding(appliance);
        } catch (RuntimeException e) {
            PrintApplianceInfo.printExceptionMassagerForAdding(oven, e);
        }
    }
}