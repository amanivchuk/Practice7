package ua.nure.manivchuk.SummaryTask3.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.manivchuk.SummaryTask3.constants.Constants;
import ua.nure.manivchuk.SummaryTask3.constants.XML;
import ua.nure.manivchuk.SummaryTask3.entity.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by nec on 14.12.17.
 */
public class SAXController extends DefaultHandler {
    private Guns guns;
    private Gun gun;
    private Ttc ttc;

    private String currentElement;
    private String fileName;

    public SAXController(String fileName) {
        this.fileName = fileName;
    }

    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        if (validate) {
            saxParserFactory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            saxParserFactory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(fileName, this);
    }

    public Guns getGuns() {
        return guns;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = localName;

        if (XML.GUNS.value().equals(currentElement)) {
            guns = new Guns();
            return;
        }
        if (XML.GUN.value().equals(currentElement)) {
            gun = new Gun();
            return;
        }
        if (XML.TTC.value().equals(currentElement)) {
            ttc = new Ttc();
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String element = new String(ch, start, length).trim();

        if (element.isEmpty()) {
            return;
        }

        if (XML.MODEL.value().equals(currentElement)) {
            gun.setModel(element);
            return;
        }
        if (XML.HANDY.value().equals(currentElement)) {
            gun.setHandy(element);
            return;
        }
        if (XML.ORIGIN.value().equals(currentElement)) {
            gun.setOrigin(element);
            return;
        }
        if (XML.RANGE.value().equals(currentElement)) {
            ttc.setRange(element);
            return;
        }
        if (XML.EFFECTIVE.value().equals(currentElement)) {
            Effective effective = new Effective();
            effective.setEffective(Integer.valueOf(element));
            ttc.setEffective(effective);
            return;
        }
        if (XML.HOLDER.value().equals(currentElement)) {
            ttc.setHolder(Boolean.parseBoolean(element));
            return;
        }
        if (XML.OPTICS.value().equals(currentElement)) {
            ttc.setOptics(Boolean.parseBoolean(element));
            return;
        }
        if (XML.MATERIAL.value().equals(currentElement)) {
            gun.setMaterial(element);
            return;
        }
    }

     @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (XML.GUN.value().equals(localName)) {
            guns.getGuns().add(gun);
            return;
        }

        if (XML.TTC.value().equals(localName)) {
            gun.setTtc(ttc);
            ttc = null;
            return;
        }
    }
}