/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.dao.impl;

import com.epam.jwd35.kotov.task2.appliance_store.dao.ApplianceReaderDAO;
import com.epam.jwd35.kotov.task2.appliance_store.dao.ResourceData;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.builder.ApplianceBuilder;
import com.epam.jwd35.kotov.task2.appliance_store.entity.builder.BuilderProvider;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ApplianceReaderDAOImpl implements ApplianceReaderDAO {

    public ApplianceReaderDAOImpl() {}

    public Document createDocument() throws RuntimeException {
        Document document = null;
        DocumentBuilder documentBuilder;
        DocumentBuilderFactory factory;

        factory = DocumentBuilderFactory.newInstance();

        try (FileInputStream fis = new FileInputStream(ResourceData.APPLIANCE_DB_FILE_NAME)) {
            documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(fis);
        } catch (ParserConfigurationException e) {
            new RuntimeException(e);
        } catch (IOException e) {
            new RuntimeException(e);
        } catch (SAXException e) {
            new RuntimeException(e);
        }
        return document;
    }

    @Override
    public Set<Appliance> findGoalApplaince(ApplianceCharacteristic applianceCharacteristic)
            throws RuntimeException{
        Element root;
        Set <Appliance> goalAppliances;
        Appliance goalAppliance;
        NodeList goalApplinceNodeList;
        Element gollApplianceElement;
        String applianceTitle;
        String applinceTitleForXML;
        Document document;

        goalAppliances = new HashSet<>();
        applianceTitle = applianceCharacteristic.getApplinceTitle();
        applinceTitleForXML = applianceTitle.toLowerCase();
        document = createDocument();
        root = document.getDocumentElement();
        goalApplinceNodeList = root.getElementsByTagName(applinceTitleForXML);
        for (int i = 0; i < goalApplinceNodeList.getLength(); i++) {
            gollApplianceElement = (Element) goalApplinceNodeList.item(i);
            if (isGoalAppliance(applianceCharacteristic, gollApplianceElement)) {
                goalAppliance = buildGoalApplince(applianceCharacteristic, gollApplianceElement);
                goalAppliances.add(goalAppliance);
            }
        }
        return goalAppliances;
    }

    private Appliance buildGoalApplince(ApplianceCharacteristic applianceCharacteristic, Element goalApplianceElement){
        Appliance goalApplince;
        Map<String, String> characteristicListFromXML;
        ApplianceBuilder applianceBuilder;
        BuilderProvider builderProvider;

        characteristicListFromXML = buildCharacteristicListFromXML(goalApplianceElement);
        builderProvider = new BuilderProvider();
        applianceBuilder = builderProvider.getBuilder(applianceCharacteristic);
        goalApplince = applianceBuilder.build(characteristicListFromXML);
        return goalApplince;
    }

    private Map<String, String> buildCharacteristicListFromXML(Element gollApplianceElement) {
        NodeList nodeListCharacteristic;
        Node nodeCharacteristic;
        Map<String, String> characteristicListFromXML;
        String elementName;
        String characteristicValue;

        characteristicListFromXML = new HashMap<>();
        nodeListCharacteristic = gollApplianceElement.getChildNodes();
        for (int i = 0; i < nodeListCharacteristic.getLength(); i++) {
            nodeCharacteristic = nodeListCharacteristic.item(i);
            if (nodeCharacteristic.getNodeType() == Node.ELEMENT_NODE) {
                elementName = nodeCharacteristic.getNodeName();
                characteristicValue = nodeCharacteristic.getTextContent();
                characteristicListFromXML.put(elementName, characteristicValue);
            }
        }
        return characteristicListFromXML;
    }

    private boolean isGoalAppliance(ApplianceCharacteristic applianceCharacteristic, Element gollApplianceElement) {
        String characteristicValueFromXML;
        String characteristicTitle;
        Object characterisitcValue;
        Map<String, Object> characterisitcSet;

        characterisitcSet = applianceCharacteristic.getValueList();
        if (characterisitcSet.isEmpty()) {
            return false;
        }
        for (Map.Entry entry : characterisitcSet.entrySet()) {
            characteristicTitle = (String) entry.getKey();
            characterisitcValue = entry.getValue();
            characteristicValueFromXML = getElementTextContent(gollApplianceElement,
                    characteristicTitle);
            if (!(checkEqualityValue(characterisitcValue, characteristicValueFromXML))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEqualityValue(Object characterisitcValue, String characteristicValueFromXML) {
        if (characterisitcValue instanceof Integer) {
            int value;
            int nodeValue;
            value = (Integer) characterisitcValue;
            nodeValue = Integer.valueOf(characteristicValueFromXML);
            if (value == nodeValue) {
                return true;
            }
        }

        if (characterisitcValue instanceof Number) {
            double value;
            double nodeValue;
            value = ((Number) characterisitcValue).doubleValue();
            nodeValue = Double.valueOf(characteristicValueFromXML);
            if (Double.compare(value, nodeValue) == 0) {
                return true;
            }
        }

        if (characterisitcValue instanceof String) {
            String value;
            value = (String) characterisitcValue;
            if (value.equals(characteristicValueFromXML)) {
                return true;
            }
        }
        return false;
    }

    private static String getElementTextContent(Element element, String elementName) {
        int indexElement;
        NodeList nodeList;
        Node node;
        String text;

        indexElement = 0;
        nodeList = element.getElementsByTagName(elementName);
        node = nodeList.item(indexElement);
        text = node.getTextContent();
        return text;
    }
}