/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.main;

import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import java.util.Set;

public class PrintApplianceInfo {

    public static void printMassagerForSearch(Set<Appliance> applianceSet) {
        if (!applianceSet.isEmpty()) {
            System.out.println("Found appliances that meet the request criteria:");
            for (Appliance appliance : applianceSet) {
                System.out.println(appliance);
            }
            System.out.println();
        } else {
            System.out.println("No appliance found that matches the request criteria.");
            System.out.println();
        }
    }

    public static void printExceptionMassagerForSearch(RuntimeException e) {
        String massager;

        massager = e.getMessage();
        if (massager.equals("Data is incorrectly.")) {
            System.out.println("Search data is entered incorrectly.");
            System.out.println();
        } else {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static void printMassagerForAdding(Appliance appliance) {
        System.out.println("Applieance: " + appliance);
        System.out.println("added to base.");
        System.out.println();
    }

    public static void printExceptionMassagerForAdding(Appliance appliance,
                                                       RuntimeException e) {
        String massager;

        massager = e.getMessage();
        if (massager.equals("Data is incorrectly.")) {
            System.out.println("Applieance: " + appliance);
            System.out.println("Data for adding is entered incorrectly.");
            System.out.println();
        } else {
            e.printStackTrace();
            System.out.println();
        }
    }
}