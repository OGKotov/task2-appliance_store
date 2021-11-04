/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.service.impl;

import com.epam.jwd35.kotov.task2.appliance_store.dao.ApplianceReaderDAO;
import com.epam.jwd35.kotov.task2.appliance_store.dao.ApplianceWriterDAO;
import com.epam.jwd35.kotov.task2.appliance_store.dao.DAOFactory;
import com.epam.jwd35.kotov.task2.appliance_store.service.validation.Validator;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.converter.ApplianceConverter;
import com.epam.jwd35.kotov.task2.appliance_store.entity.converter.ConverterManager;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import com.epam.jwd35.kotov.task2.appliance_store.service.ApplianceService;
import com.epam.jwd35.kotov.task2.appliance_store.service.validation.ValidatorProvider;
import java.util.Set;

public class ApplianceServiceImpl implements ApplianceService {
    DAOFactory daoFactory;
    ValidatorProvider validatorProvider;

    public ApplianceServiceImpl() {
        daoFactory = DAOFactory.getInstance();
        validatorProvider = new ValidatorProvider();
    }

    @Override
    public Set<Appliance> findSearchAppliance(ApplianceCharacteristic applianceCharacteristic)
            throws RuntimeException {
        ApplianceReaderDAO applianceReaderDAO;
        Validator validator;
        Set<Appliance> applianceSet;

        validator = validatorProvider.getValidator(applianceCharacteristic);
        applianceReaderDAO = daoFactory.getApplianceReaderDAO();

        if (validator.isValidData(applianceCharacteristic)) {
            applianceSet = applianceReaderDAO.findGoalApplaince(applianceCharacteristic);
        } else {
            throw new RuntimeException("Data is incorrectly.");
        }
        return applianceSet;
    }

    @Override
    public Appliance addAppliance(Appliance appliance) throws RuntimeException {
        ApplianceWriterDAO applianceWriterDAO;
        ApplianceConverter applianceConverter;
        Validator validator;
        ApplianceCharacteristic applianceCharacteristic;
        applianceConverter = ConverterManager.selectConverter(appliance);
        applianceCharacteristic = applianceConverter.convertToApplianceCharacteristic(appliance);
        validator = validatorProvider.getValidator(applianceCharacteristic);
        applianceWriterDAO = daoFactory.getApplianceWriterDAO();

        if (validator.isValidData(applianceCharacteristic)) {
            try {
                appliance = applianceWriterDAO.addApplianceToXML(appliance);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Data is incorrectly.");
        }
        return appliance;
    }
}