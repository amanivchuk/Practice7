package ua.nure.manivchuk.SummaryTask3.entity;

/**
 * Created by nec on 14.12.17.
 */
public enum Range {
    SHORT("SHORT"),
    MIDDLE("MIDDLE"),
    HIGH("HIGH");

    private String value;

    Range(String value) {
        this.value = value;
    }
    public boolean equalsTo(String name){
        return value.equals(name);
    }

    public String getValue(){
        return value;
    }
}
