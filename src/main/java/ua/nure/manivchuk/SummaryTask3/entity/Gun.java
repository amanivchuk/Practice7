package ua.nure.manivchuk.SummaryTask3.entity;

/**
 * Created by nec on 14.12.17.
 */
public class Gun {
    private String model;
    private String handy;
    private String origin;
    private Ttc ttc;
    private String material;

    public Gun() {
    }

    public Gun(String model, String handy, String origin,Ttc ttc, String material) {
        this.model = model;
        this.handy = handy;
        this.origin = origin;
        this.ttc = ttc;
        this.material = material;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHandy() {
        return handy;
    }

    public void setHandy(String handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Ttc getTtc() {
        return ttc;
    }

    public void setTtc(Ttc ttc) {
        this.ttc = ttc;
    }

    @Override
    public String toString(){
        StringBuilder result= new StringBuilder();
        result.append(model).append('\n').
                append(handy).append('\n').
                append(origin).append('\n').
                append(ttc).append('\n').
                append(material).append('\n');

        return result.toString();
    }
}
