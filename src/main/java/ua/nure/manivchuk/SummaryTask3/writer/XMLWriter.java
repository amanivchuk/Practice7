package ua.nure.manivchuk.SummaryTask3.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.nure.manivchuk.SummaryTask3.constants.XML;
import ua.nure.manivchuk.SummaryTask3.entity.Gun;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;

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

/**
 * Created by nec on 14.12.17.
 */
public class XMLWriter {
    //////////////////////////////////////////////////////
    // Static util methods
    // //////////////////////////////////////////////////////

    public static Document getDocument(Guns guns) throws ParserConfigurationException {
        // obtain DOM parser
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Element tElement = document.createElement(XML.GUNS.value());
        document.appendChild(tElement);
        // add guns elements
        for (Gun gun : guns.getGuns()) {
            // add question
            Element qElement = document.createElement(XML.GUN.value());
            tElement.appendChild(qElement);

            // add model text
            Element qtElement = document.createElement(XML.MODEL.value());
            qtElement.setTextContent(gun.getModel());
            qElement.appendChild(qtElement);

            // add origin text
            qtElement = document.createElement(XML.HANDY.value());
            qtElement.setTextContent(gun.getHandy());
            qElement.appendChild(qtElement);


            // add origin text
            qtElement = document.createElement(XML.ORIGIN.value());
            qtElement.setTextContent(gun.getOrigin());
            qElement.appendChild(qtElement);

            // add ttc
            Element ttc = document.createElement(XML.TTC.value());

            Element rangeElement = document.createElement(XML.RANGE.value());
            rangeElement.setTextContent(gun.getTtc().getRange());
            ttc.appendChild(rangeElement);

            // add Effective to Ttc
            Element effectiveElement = document.createElement(XML.EFFECTIVE.value());
            effectiveElement.setTextContent(String.valueOf(gun.getTtc().getEffective()));
            ttc.appendChild(effectiveElement);

            Element holderElement = document.createElement(XML.HOLDER.value());
            holderElement.setTextContent(String.valueOf(gun.getTtc().isHolder()));
            ttc.appendChild(holderElement);

            Element opticsElement = document.createElement(XML.OPTICS.value());
            opticsElement.setTextContent(String.valueOf(gun.getTtc().isOptics()));
            ttc.appendChild(opticsElement);

            qElement.appendChild(ttc);

            // add material text
            qtElement = document.createElement(XML.MATERIAL.value());
            qtElement.setTextContent(gun.getMaterial());
            qElement.appendChild(qtElement);
        }
        return document;
    }

    public static void saveToXML(Guns guns, String xmlFileName) throws ParserConfigurationException, TransformerException {
        saveToXML(getDocument(guns), xmlFileName);
    }

    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {
        StreamResult result = new StreamResult(new File(xmlFileName));
        // set up transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        // run transformation
        t.transform(new DOMSource(document), result);
    }
}
