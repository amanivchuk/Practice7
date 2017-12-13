package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Lenovo on 12/12/2017.
 */
@XmlType(name = "Handy")
@XmlEnum
public enum Handy {

    @XmlEnumValue("One_handed")
    ONE_HANDED,

    @XmlEnumValue("Two_handed")
    TWO_HANDED;

    public final String value(){
        return name();
    }
    public static Handy fromValue(final String v){
        return valueOf(v);
    }
}
