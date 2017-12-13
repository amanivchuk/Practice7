package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 12/12/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"gun"})
@XmlRootElement(name = "guns")
public class Guns {
    @XmlElement(required = true)
    private List<Gun> guns;

    public Guns() {
        this.guns = new ArrayList<Gun>();
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public final void addGun(final Gun newGun){
        guns.add(newGun);
    }
}
