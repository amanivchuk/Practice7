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
import ua.nure.manivchuk.SummaryTask3.entity.Effective;
import ua.nure.manivchuk.SummaryTask3.entity.Gun;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;
import ua.nure.manivchuk.SummaryTask3.entity.Ttc;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by nec on 14.12.17.
 */
public class DOMController {
    private String xmlFileName;

    //main container
    private Guns guns;

    public DOMController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Guns getGuns() {
        return guns;
    }

    public void parse(boolean validate)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("input.xml");
        Element element = document.getDocumentElement();
        System.out.println(getGuns(element));

        // obtain DOM parser
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        if (validate) {
            dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                // throw exception if XML document is NOT valid
                throw e;
            }
        });
        /*Document */document = db.parse(xmlFileName);
        Element root = document.getDocumentElement();

        getGuns(root);
    }

    private List<Gun> getGuns(Element element) {
        guns = new Guns();
        List<Gun> listGun = guns.getGuns();
        NodeList nodesGuns = element.getElementsByTagName(XML.GUN.value());
        for (int i = 0; i < nodesGuns.getLength(); i++) {
            Gun gun = getGun(nodesGuns.item(i));
            listGun.add(gun);
        }
        return listGun;
    }


    private Gun getGun(Node qNode) {
        Gun gun = new Gun();
        Element qElement = (Element) qNode;

        Node qtNode = qElement.getElementsByTagName(XML.MODEL.value()).item(0);
        gun.setModel(qtNode.getTextContent());

        // process handy text
        qtNode = qElement.getElementsByTagName(XML.HANDY.value()).item(0);
        gun.setHandy(qtNode.getTextContent());

        // process origin text
        qtNode = qElement.getElementsByTagName(XML.ORIGIN.value()).item(0);
        gun.setOrigin(qtNode.getTextContent());

        // process ttc
        Ttc ttc = getTtc(qElement);
        gun.setTtc(ttc);

        // process material text
        qtNode = qElement.getElementsByTagName(XML.MATERIAL.value()).item(0);
        gun.setMaterial(qtNode.getTextContent());

        return gun;
    }

    private Ttc getTtc(Element element) {
        Ttc ttc = new Ttc();

        Node alNode = element.getElementsByTagName(XML.RANGE.value()).item(0);
        ttc.setRange(alNode.getTextContent());

        Effective effective = getEffective(element);
        ttc.setEffective(effective);

        alNode = element.getElementsByTagName(XML.HOLDER.value()).item(0);
        ttc.setHolder(Boolean.parseBoolean(alNode.getTextContent()));

        alNode = element.getElementsByTagName(XML.OPTICS.value()).item(0);
        ttc.setOptics(Boolean.parseBoolean(alNode.getTextContent()));

        return ttc;
    }

    private Effective getEffective(Element element) {
        Effective effective = new Effective();

        Node effectiveNode = element.getElementsByTagName(XML.EFFECTIVE.value()).item(0);
        effective.setEffective(Integer.valueOf(effectiveNode.getTextContent()));

        return effective;
    }



  /*  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        // try to parse NOT valid XML document with validation on (failed)
        DOMController domContr = new DOMController(Constants.INVALID_XML_FILE);
        try {
            // parse with validation (failed)
            domContr.parse(true);
        } catch (SAXException ex) {
            System.err.println("====================================");
            System.err.println("XML not valid");
            System.err.println("Test object --> " + domContr.getGuns());
            System.err.println("====================================");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // try to parse NOT valid XML document with validation off (success)
        domContr.parse(false);

        // we have Test object at this point:
        System.out.println("====================================");
        System.out.print("Here is the test: \n" + domContr.getGuns());
        System.out.println("====================================");

        // save test in XML file
        Guns guns = domContr.getGuns();
        DOMController.saveToXML(guns, Constants.INVALID_XML_FILE + ".dom-result.xml");

    }*/
}