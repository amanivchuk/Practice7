package ua.nure.manivchuk.SummaryTask3.entity;

/**
 * Created by nec on 14.12.17.
 */
public enum  Handy {
    ONE_HANDED("One_handed"), TWO_HANDED("Two_handed");

    private String value;

    Handy(String value) {
        this.value = value;
    }
    public boolean equalsTo(String name){
        return value.equals(name);
    }

    public String value(){
        return value;
    }
}
