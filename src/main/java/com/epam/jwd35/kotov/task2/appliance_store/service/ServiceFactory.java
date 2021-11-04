/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.service;

import com.epam.jwd35.kotov.task2.appliance_store.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {}

    public ApplianceService getApplianceService() {

        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}