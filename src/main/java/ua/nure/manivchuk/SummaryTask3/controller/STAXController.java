package ua.nure.manivchuk.SummaryTask3.controller;

import ua.nure.manivchuk.SummaryTask3.constants.XML;
import ua.nure.manivchuk.SummaryTask3.entity.Effective;
import ua.nure.manivchuk.SummaryTask3.entity.Gun;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;
import ua.nure.manivchuk.SummaryTask3.entity.Ttc;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by nec on 14.12.17.
 */
public class STAXController {
    private Guns guns;
    private String fileName;

    public STAXController(String fileName) {
        this.fileName = fileName;
    }

    public Guns getGuns() {
        return guns;
    }

    public void parse() throws XMLStreamException {
        Gun gun = null;
        Ttc ttc = null;

        String currentElement = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

        XMLEventReader reader = factory.createXMLEventReader(new StreamSource("input.xml"));
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
                continue;
            }

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();

                if (XML.GUNS.value().equals(currentElement)) {
                    guns = new Guns();
                    continue;
                }
                if (XML.GUN.value().equals(currentElement)) {
                    gun = new Gun();
                    continue;
                }
                if (XML.TTC.value().equals(currentElement)) {
                    if (ttc == null) {
                        ttc = new Ttc();
                        continue;
                    }
                }
            }

            if (event.isCharacters()) {
                Characters characters = event.asCharacters();

                if (XML.MODEL.value().equals(currentElement)) {
                    gun.setModel(characters.getData());
                }
                if (XML.HANDY.value().equals(currentElement)) {
                    gun.setHandy(characters.getData());
                }
                if (XML.ORIGIN.value().equals(currentElement)) {
                    gun.setOrigin(characters.getData());
                }
                if (XML.RANGE.value().equals(currentElement)) {
                    ttc.setRange(characters.getData());
                }
                if (XML.EFFECTIVE.value().equals(currentElement)) {
                    Effective effective = new Effective();
                    effective.setEffective(Integer.valueOf(characters.getData()));
                    ttc.setEffective(effective);
                }
                if (XML.HOLDER.value().equals(currentElement)) {
                    ttc.setHolder(Boolean.parseBoolean(characters.getData()));
                }
                if (XML.OPTICS.value().equals(currentElement)) {
                    ttc.setOptics(Boolean.parseBoolean(characters.getData()));
                }
                if (XML.MATERIAL.value().equals(currentElement)) {
                    gun.setMaterial(characters.getData());
                }
            }
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                String localName = endElement.getName().getLocalPart();

                if (XML.GUN.value().equals(localName)) {
                    guns.getGuns().add(gun);
                }

                if (XML.TTC.value().equals(localName)) {
                    gun.setTtc(ttc);
                    ttc = null;
                }
            }
        }
    }
}
