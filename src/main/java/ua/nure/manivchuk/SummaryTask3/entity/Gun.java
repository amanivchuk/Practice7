package ua.nure.manivchuk.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Lenovo on 12/12/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gun", propOrder = {"model", "handys", "origin", "ttc", "material"})
public class Gun {

    @XmlElement(name = "Model", required = true)
    private String model;

    @XmlElement(name = "Handys", required = true)
    private Handys handys;

    @XmlElement(name = "Origin", required = true)
    private String origin;

    @XmlElement(name = "Ttc", required = true)
    private Ttc ttc;

    @XmlElement(name = "Material", required = true)
    private String material;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Handys getHandys() {
        return handys;
    }

    public void setHandys(Handys handys) {
        this.handys = handys;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Ttc getTtc() {
        return ttc;
    }

    public void setTtc(Ttc ttc) {
        this.ttc = ttc;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Gun{" +
                "model='" + model + '\'' +
                ", handy=" + handys +
                ", origin='" + origin + '\'' +
                ", ttc=" + ttc +
                ", material='" + material + '\'' +
                '}';
    }
}
