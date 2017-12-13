package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Lenovo on 12/12/2017.
 */
@XmlType(name = "Range")
@XmlEnum
public enum Range {
    SHORT,
    MIDDLE,
    HIGH;

    public final String value(){
        return name();
    }
    public static Range fromValue(final String v){
        return valueOf(v);
    }
}
