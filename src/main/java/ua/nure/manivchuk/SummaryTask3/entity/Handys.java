package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nec on 13.12.17.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Handys", propOrder = {"handy"})
public class Handys {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private List<Handy> handy;

    public Handys() {
        handy = new ArrayList<Handy>();
    }

    public final List<Handy> getHandy(){
        return this.handy;
    }

    public final void addHandy(final  Handy newHandy){
        handy.add(newHandy);
    }
}
