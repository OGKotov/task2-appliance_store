/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.dao;

import com.epam.jwd35.kotov.task2.appliance_store.dao.impl.ApplianceReaderDAOImpl;
import com.epam.jwd35.kotov.task2.appliance_store.dao.impl.ApplianceWriterDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceReaderDAO applianceReaderDAO = new ApplianceReaderDAOImpl();
    private final ApplianceWriterDAO applianceWriterDAO = new ApplianceWriterDAOImpl();

    private DAOFactory() {}

    public ApplianceReaderDAO getApplianceReaderDAO() {
        return applianceReaderDAO;
    }

    public ApplianceWriterDAO getApplianceWriterDAO() {
        return applianceWriterDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}