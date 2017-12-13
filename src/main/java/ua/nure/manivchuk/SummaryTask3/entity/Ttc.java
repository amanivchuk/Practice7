package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.*;

/**
 * Created by Lenovo on 12/12/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ttc", propOrder = {})
public class Ttc {

    @XmlElement(name = "Range")
    @XmlSchemaType(name = "string")
    private Range range;

    @XmlElement(name = "Effective")
    @XmlSchemaType(name = "nonNegativeInteger")
    private int effective;

    @XmlSchemaType(name = "boolean")
    private boolean holder;    //  ???????

    @XmlSchemaType(name = "boolean")
    private boolean optics;

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public int getEffective() {
        return effective;
    }

    public void setEffective(int effective) {
        this.effective = effective;
    }

    public boolean isHolder() {
        return holder;
    }

    public void setHolder(boolean holder) {
        this.holder = holder;
    }

    public boolean isOptics() {
        return optics;
    }

    public void setOptics(boolean optics) {
        this.optics = optics;
    }

    @Override
    public String toString() {
        return "Ttc{" +
                "range=" + range +
                ", effective=" + effective +
                ", holder=" + holder +
                ", optics=" + optics +
                '}';
    }
}
