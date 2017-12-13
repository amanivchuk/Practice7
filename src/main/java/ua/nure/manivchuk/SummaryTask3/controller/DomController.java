package ua.nure.manivchuk.SummaryTask3.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.manivchuk.SummaryTask3.constants.Constants;
import ua.nure.manivchuk.SummaryTask3.constants.XML;
import ua.nure.manivchuk.SummaryTask3.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Lenovo on 12/12/2017.
 */
public class DomController {
    private String xmlFileName;

    private Guns guns;

    public DomController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public final void parse(final boolean validate) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        if(validate){
            dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
            dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
        }
        DocumentBuilder db = dbf.newDocumentBuilder();

        db.setErrorHandler(new DefaultHandler(){
            @Override
            public void error(final SAXParseException e) throws SAXException{
                throw e;
            }
        });

        Document document = db.parse(xmlFileName);
        Element root = document.getDocumentElement();
        guns = new Guns();
        NodeList gunsNodes = root.getElementsByTagName(XML.GUN.value());
        for(int j = 0; j < gunsNodes.getLength(); j++){
            Gun gun = getGun(gunsNodes.item(j));
            guns.addGun(gun);
        }
    }

    private Gun getGun(final Node qNode) {
        Gun gun = new Gun();
        Element qElement = (Element) qNode;
        Node qtNode = qElement.getElementsByTagName(XML.MODEL.value()).item(0);
        gun.setModel(qtNode.getTextContent());
        qtNode = qElement.getElementsByTagName(XML.HANDY.value()).item(0);
        gun.setHandy(Handy.valueOf(qtNode.getTextContent()));
        qtNode = qElement.getElementsByTagName(XML.ORIGIN.value()).item(0);
        gun.setOrigin(qtNode.getTextContent());

        gun.setTtc(getTtc(qElement.getElementsByTagName(XML.TTC.value()).item(0)));

        qtNode = qElement.getElementsByTagName(XML.MATERIAL.value()).item(0);
        gun.setMaterial(qtNode.getTextContent()));

        return gun;
    }

    private Ttc getTtc(final Node qNode) {
        Ttc ttc = new Ttc();
        Element qElement = (Element) qNode;

        Node qtNode = qElement.getElementsByTagName(XML.RANGE.value()).item(0);
        ttc.setRange(Range.valueOf(qtNode.getTextContent()));
        qtNode = qElement.getElementsByTagName(XML.EFFECTIVE.value()).item(0);
        ttc.setEffective(new Integer(qtNode.getTextContent()));

        qtNode = qElement.getElementsByTagName(XML.HOLDER.value()).item(0);
        ttc.setHolder(Boolean.valueOf(qtNode.getTextContent()));
        qtNode = qElement.getElementsByTagName(XML.OPTICS.value()).item(0);
        ttc.setOptics(Boolean.valueOf(qtNode.getTextContent()));

        return ttc;
    }

    public static Document getDocument(final Guns guns) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Element tElement = document.createElement(XML.GUNS.value());
        document.appendChild(tElement);

        for(Gun gun : guns.getGuns()){
            Element dElement = document.createElement(XML.GUN.value());
            tElement.appendChild(dElement);

            Element nElement = document.createElement(XML.MODEL.value());
            nElement.setTextContent(gun.getModel());
            dElement.appendChild(nElement);

            Element oElement = document.createElement(XML.HANDY.value());
            oElement.setTextContent(String.valueOf(gun.getHandy()));
            dElement.appendChild(oElement);

            Element pElement = document.createElement(XML.ORIGIN.value());
            pElement.setTextContent(String.valueOf(gun.getOrigin()));
            dElement.appendChild(pElement);

            Element typesElement = document.createElement(XML.TTC.value());
            dElement.appendChild(typesElement);

//            Element range = document.createElement(XML.RANGE.value());

            Element ecElement = document.createElement(XML.EFFECTIVE
                    .value());
            ecElement.setTextContent(String.valueOf(gun.getTypes().));
            typesElement.appendChild(ecElement);

        }
    }
}