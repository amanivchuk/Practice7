package ua.nure.manivchuk.SummaryTask3.entity;

/**
 * Created by nec on 14.12.17.
 */
public class Ttc {
    private String range;
    private Effective effective;
    private boolean holder;
    private boolean optics;

    public Ttc() {
    }

    public Ttc(String range,Effective effective, boolean holder, boolean optics) {
        this.range = range;
        this.effective = effective;
        this.holder = holder;
        this.optics = optics;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Effective getEffective() {
        return effective;
    }

    public void setEffective(Effective effective) {
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
