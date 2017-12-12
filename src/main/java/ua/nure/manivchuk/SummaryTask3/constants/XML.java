package ua.nure.manivchuk.SummaryTask3.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author Hasan Yosin
 * 
 */
public enum XML {
	/**
	 * Element.
	 */
	GUNS("guns"),
	/**
	 * Element.
	 */
	GUN("gun"),
	/**
	 * Element.
	 */
	MODEL("Model"),
	/**
	 * Element.
	 */
	HANDY("Handy"),
	/**
	 * Element.
	 */
	ORIGIN("Origin"),
	/**
	 * Element.
	 */
	TTC("Ttc"),
	/**
	 * Element.
	 */
	RANGE("Range"),
	/**
	 * Element.
	 */
	EFFECTIVE("Effective"),
	/**
	 * Element.
	 */
	HOLDER("holder"),
	/**
	 * Element.
	 */
	OPTICS("optics"),
	/**
	 * Element.
	 */
	MATERIAL("Material");

	private String value;

	/**
	 * Constructor.
	 * 
	 * @param value2
	 *            value
	 */
	XML(final String value2) {
		this.value = value2;
	}

	/**
	 * Determines if a name is equal to the string value wrapped by this enum
	 * element.<br/>
	 * If a SAX/StAX parser make all names of elements and attributes interned
	 * you can use
	 * 
	 * <pre>
	 * return value == name;
	 * </pre>
	 * 
	 * instead
	 * 
	 * <pre>
	 * return value.equals(name);
	 * </pre>
	 * 
	 * @param name
	 *            string to compare with value.
	 * @return value.equals(name)
	 */
	public boolean equalsTo(final String name) {
		return value.equals(name);
	}

	/**
	 * Get value.
	 * 
	 * @return String
	 */
	public final String value() {
		return value;
	}
}
