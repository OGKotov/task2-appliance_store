/*
 * Java Web Development
 * JWD 35
 * Oleg Kotov
 * Task2
 * Appliance Store
 * From 15-10-2021 to 202-10-2021
 */
package com.epam.jwd35.kotov.task2.appliance_store.dao.impl;

import com.epam.jwd35.kotov.task2.appliance_store.dao.ApplianceWriterDAO;
import com.epam.jwd35.kotov.task2.appliance_store.dao.ResourceData;
import com.epam.jwd35.kotov.task2.appliance_store.entity.Appliance;
import com.epam.jwd35.kotov.task2.appliance_store.entity.converter.ApplianceConverter;
import com.epam.jwd35.kotov.task2.appliance_store.entity.converter.ConverterManager;
import com.epam.jwd35.kotov.task2.appliance_store.entity.characteristic.ApplianceCharacteristic;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class ApplianceWriterDAOImpl implements ApplianceWriterDAO {

    public ApplianceWriterDAOImpl(){}

    public Document createDocument() throws RuntimeException {
        Document document = null;
        DocumentBuilder documentBuilder;
        DocumentBuilderFactory factory;

        factory = DocumentBuilderFactory.newInstance();

        try (FileInputStream fis = new FileInputStream(ResourceData.APPLIANCE_DB_FILE_NAME)) {
            documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(fis);
            removeWhitespaces(document);

        } catch (ParserConfigurationException e) {
            new RuntimeException(e);
        } catch (IOException e) {
            new RuntimeException(e);
        } catch (SAXException e) {
            new RuntimeException(e);
        } catch (XPathExpressionException e) {
            new RuntimeException(e);
        }
        return document;
    }

    @Override
    public Appliance addApplianceToXML(Appliance appliance)
            throws RuntimeException {
        ApplianceConverter applianceConverter;
        ApplianceCharacteristic applianceCharacteristic;
        Element applianceElement;
        Element applianceGroupeElement;
        Document document;

        document = createDocument();
        applianceConverter = ConverterManager.selectConverter(appliance);
        applianceCharacteristic = applianceConverter.convertToApplianceCharacteristic(appliance);
        applianceElement = createApplianceElement(document, applianceCharacteristic);
        applianceGroupeElement = goToAppliianceGroup(document, applianceCharacteristic);
        addApplianceToGroupe(applianceGroupeElement, applianceElement);
        writeXml(document);
        return appliance;
    }

    public Document removeWhitespaces (Document document) throws XPathExpressionException {
        String xPathStr;

        xPathStr = "//text()[normalize-space()='']";
        document.normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.evaluate(xPathStr,
                document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            node.getParentNode().removeChild(node);
        }
        return document;
    }

    private Element addApplianceToGroupe(Element applianceGroupeElement, Element appleanceElement) {
        applianceGroupeElement.appendChild(appleanceElement);
        return applianceGroupeElement;
    }

    public Element goToAppliianceGroup(Document document,
                                       ApplianceCharacteristic applianceCharacteristic) {
        final int groupIndex;
        Element root;
        Element applianceGroupFromXML;
        NodeList applianceGroupFromXMLNodeList;
        String groupTitle;

        groupIndex = 0;
        groupTitle = convertToPlural(applianceCharacteristic.getApplinceTitle().toLowerCase());
        root = document.getDocumentElement();
        applianceGroupFromXMLNodeList = root.getElementsByTagName(groupTitle);
        applianceGroupFromXML = (Element) applianceGroupFromXMLNodeList.item(groupIndex);
        return applianceGroupFromXML;
    }

    public static String convertToPlural(String noun) {
        String pluralNoun;
        String endingES = "es";
        String endingS = "s";

        if (noun.endsWith("s") || noun.endsWith("x") || noun.endsWith("z")
            || noun.endsWith("ch") || noun.endsWith("sh")) {
            pluralNoun = noun + endingES;
        } else {
            pluralNoun = noun + endingS;
        }
        return pluralNoun;
    }

    public Element createApplianceElement(Document document,
                                          ApplianceCharacteristic applianceCharacteristic) {
        String applianceTitle;
        String characteristicTitle;
        Object characterisitcValue;
        String characterisitcValueString;
        Map<String, Object> characterisitcSet;
        Element applianceElement;
        Element characteristicTitleElement;
        Text characterisitcValueElement;

        applianceTitle = applianceCharacteristic.getApplinceTitle();
        applianceElement = document.createElement(applianceTitle.toLowerCase());
        characterisitcSet = applianceCharacteristic.getValueList();
        for (Map.Entry entry : characterisitcSet.entrySet()) {
            characteristicTitle = (String) entry.getKey();
            characterisitcValue = entry.getValue();
            characterisitcValueString = convertCharacterisitcValueToString(characterisitcValue);
            characteristicTitleElement = document.createElement(characteristicTitle);
            characterisitcValueElement = document.createTextNode(characterisitcValueString);
            characteristicTitleElement.appendChild(characterisitcValueElement);
            applianceElement.appendChild(characteristicTitleElement);
        }
        return applianceElement;
    }

    public static String convertCharacterisitcValueToString(Object characterisitcValue) {
        String characterisitcValueString;

        characterisitcValueString = "";
        if (characterisitcValue instanceof Integer) {
            int value;
            value = (Integer) characterisitcValue;
            characterisitcValueString = Integer.toString(value);
            return characterisitcValueString;
        }

        if (characterisitcValue instanceof Number) {
            double value;

            value = ((Number) characterisitcValue).doubleValue();
            characterisitcValueString = Double.toString(value);
            return characterisitcValueString;
        }

        if (characterisitcValue instanceof String) {
            characterisitcValueString = (String) characterisitcValue;
            return characterisitcValueString;
        }
        return characterisitcValueString;
    }

    private void writeXml(Document document) throws RuntimeException {
        Transformer transformer;
        DOMSource src;

        try (FileOutputStream fos = new FileOutputStream(ResourceData.APPLIANCE_DB_FILE_NAME)) {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            src = new DOMSource(document);
            StreamResult streamResult = new StreamResult(fos);
            transformer.transform(src, streamResult);
        } catch (TransformerException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}