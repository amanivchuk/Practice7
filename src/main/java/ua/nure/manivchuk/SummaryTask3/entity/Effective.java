package ua.nure.manivchuk.SummaryTask3.entity;

/**
 * Created by nec on 14.12.17.
 */
public class Effective {
    private Integer effective;

    public Effective() {
    }

    public Effective(Integer effective) {
        this.effective = effective;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    @Override
    public String toString() {
        return effective.toString();
    }
}
