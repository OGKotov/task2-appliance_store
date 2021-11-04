/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic;

public final class CharacteristicName {

    public static enum Oven{
        NAME("name"),
        MODEL("model"),
        POWER_CONSUMPTION("power_consumption"),
        WEIGHT("weight"),
        CAPACITY("capacity"),
        DEPTH("depth"),
        HEIGHT("height"),
        WIDTH("width");

        private final String value;

        private Oven(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }
    }

    public static enum Laptop{
        NAME("name"),
        MODEL("model"),
        BATTERY_CAPACITY("battery_capacity"),
        OS("os"),
        MEMORY_RAM("memory_ram"),
        STORAGE_MEMORY("storage_memory"),
        CPU("cpu"),
        DISPLAY_INCHES("display_inches");

        private final String value;

        private Laptop(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum Refrigerator{
        NAME("name"),
        MODEL("model"),
        POWER_CONSUMPTION("power_consumption"),
        WEIGHT("weight"),
        FREEZER_CAPACITY("freezer_capacity"),
        OVERALL_CAPACITY("overall_capacity"),
        HEIGHT("height"),
        WIDTH("width");

        private final String value;

        private Refrigerator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum VaccuumCleaner {
        NAME("name"),
        MODEL("model"),
        POWER_CONSUMPTION("power_consumption"),
        VACCUUM_POWER("vaccuum_power"),
        FILTER_TYPE("filter_type"),
        MOTOR_SPEED_REGULATION("motor_speed_regulation"),
        CLEANING_WIDTH("cleaning_width");

        private final String value;

        private VaccuumCleaner(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum TabletPC{
        NAME("name"),
        MODEL("model"),
        BATTERY_CAPACITY("battery_capacity"),
        DISPLAY_INCHES("display_inches"),
        MEMORY_RAM("memory_ram"),
        STORAGE_MEMORY("storage_memory"),
        COLOR("color");

        private final String value;

        private TabletPC(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum Speaker {
        NAME("name"),
        MODEL("model"),
        POWER_CONSUMPTION("power_consumption"),
        NUMBER_OF_SPEAKERS("number_of_speakers"),
        FREQUENCY_RANGE("frequency_range"),
        CORD_LENGTH("cord_length");

        private final String value;

        private Speaker(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private CharacteristicName() {}
}