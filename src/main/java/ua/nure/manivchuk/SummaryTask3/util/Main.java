package ua.nure.manivchuk.SummaryTask3.util;


import ua.nure.manivchuk.SummaryTask3.controller.DOMController;
import ua.nure.manivchuk.SummaryTask3.controller.SAXController;
import ua.nure.manivchuk.SummaryTask3.controller.STAXController;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;
import ua.nure.manivchuk.SummaryTask3.sorter.Sorter;
import ua.nure.manivchuk.SummaryTask3.writer.XMLWriter;

/**
 * Entry point for st3 example (simple version).
 * @author D.Kolesnikov
 *
 */
public class Main {
	public static void usage() {
		System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
		System.out.println("java ua.nure.your_last_name.SummaryTask3.Main xmlFileName");
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			usage();
			return;
		}
		
		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);
		
		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////
		
		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Guns test = domController.getGuns();

		// sort (case 1)
		Sorter.sortByModel(test);
		
		// save
		String outputXmlFile = "output.dom.xml";
		XMLWriter.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////
		
		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		Guns saxTest = saxController.getGuns();
		
		// sort  (case 2)
		Sorter.setSortByEffective(saxTest);
		
		// save
		outputXmlFile = "output.sax.xml";
		
		// other way: 
		XMLWriter.saveToXML(saxTest, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////
		
		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		Guns staxTest = staxController.getGuns();
		
		// sort  (case 3)
		Sorter.setSortByOrigin(staxTest);
		
		// save
		outputXmlFile = "output.stax.xml";
		XMLWriter.saveToXML(staxTest, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}

}