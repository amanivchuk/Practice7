package ua.nure.manivchuk.SummaryTask3.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author Hasan Yosin
 * 
 */
public enum XML {
	// elements names
	GUNS("Guns"), GUN("Gun"), MODEL("Model"), HANDY("Handy"), ORIGIN("Origin"),
	TTC("Ttc"), RANGE("Range"), EFFECTIVE("Effective"), HOLDER("Holder"), OPTICS("Optics") , MATERIAL("Material");

	private String value;

	XML(String value) {
		this.value = value;
	}

	public boolean equalsTo(String name){
		return value.equals(name);
	}

	public String value(){
		return value;
	}
}
