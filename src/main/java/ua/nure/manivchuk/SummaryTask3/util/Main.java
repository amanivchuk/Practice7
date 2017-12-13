package ua.nure.manivchuk.SummaryTask3.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


import org.xml.sax.SAXException;
import ua.nure.manivchuk.SummaryTask3.controller.DomController;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;


/**
 * Entry point for SummaryTask3.
 * 
 * @author Hasan Yosin
 * 
 */
public class Main {
	/**
	 * Usage.
	 */
	public static void usage() {
		System.out.println("Usage:\njava -jar ST3.jar xmlFileName");
		System.out.println("java ua.nure.manivchuk.SummaryTask3.Main xmlFileName");
	}

	/**
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(final String[] args) {
		if (args.length != 1) {
			usage();
			return;
		}

		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		// //////////////////////////////////////////////////////
		// DOM
		// //////////////////////////////////////////////////////

		// get
		DomController domController = new DomController(xmlFileName);
		try {
			domController.parse(true);
			Guns devices = domController.getGuns();

			// sort (case 1)
//			Sorter.sortDevicesByName(devices);

			// save
			String outputXmlFile = "output.dom.xml";
			DomController.saveToXML(devices, outputXmlFile);
/*

			// //////////////////////////////////////////////////////
			// SAX
			// //////////////////////////////////////////////////////

			// get
			System.out.println("Output ==> " + outputXmlFile);
			SAXController saxController = new SAXController(xmlFileName);
			saxController.parse(true);
			devices = saxController.getDevices();

			// sort (case 2)
			Sorter.sortDevicesByOrigin(devices);

			// save
			outputXmlFile = "output.sax.xml";

			// other way:
			DOMController.saveToXML(devices, outputXmlFile);
			System.out.println("Output ==> " + outputXmlFile);

			// //////////////////////////////////////////////////////
			// StAX
			// //////////////////////////////////////////////////////

			// get
			STAXController staxController = new STAXController(xmlFileName);
			staxController.parse();

			devices = staxController.getDevices();

			// sort (case 3)
			Sorter.sortDevicesByPrice(devices);

			// save
			outputXmlFile = "output.stax.xml";
			DOMController.saveToXML(devices, outputXmlFile);
			System.out.println("Output ==> " + outputXmlFile);
*/

		} catch (ParserConfigurationException e) {
			System.err.println(e.getMessage());
		} catch (SAXException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Constructor.
	 */
	protected Main() {

	}

}