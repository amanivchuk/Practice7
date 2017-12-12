package ua.nure.manivchuk.SummaryTask3.constants;

/**
 * Holds application constants.
 * 
 * @author Hasan Yosin
 * 
 */
public final class Constants {

	/**
	 * Name of valid xml file.
	 */
	public static final String VALID_XML_FILE = "input.xml";
	/**
	 * Name of not valid xml file.
	 */
	public static final String INVALID_XML_FILE = "input-invalid.xml";

	/**
	 * Name of xsd file.
	 */
	public static final String XSD_FILE = "input.xsd";

	/**
	 * Validation condition.
	 */
	public static final String FEATURE_TURN_VALIDATION_ON = 
			"http://xml.org/sax/features/validation";
	/**
	 * Schema validation condition.
	 */
	public static final String FEATURE_TURN_SCHEMA_VALIDATION_ON = 
			"http://apache.org/xml/features/validation/schema";

	/**
	 * Private Constructor.
	 */
	protected Constants() {

	}
}