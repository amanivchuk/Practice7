package ua.nure.manivchuk.SummaryTask3.sorter;

import ua.nure.manivchuk.SummaryTask3.entity.Gun;
import ua.nure.manivchuk.SummaryTask3.entity.Guns;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by nec on 14.12.17.
 */
public class Sorter {
    public static final Comparator<Gun> SORT_BY_MODEL = (o1, o2) -> o1.getModel().compareTo(o2.getModel());

    public static final Comparator<Gun> SORT_BY_ORIGIN = (o1, o2) -> o1.getOrigin().compareTo(o2.getOrigin());

    public static final Comparator<Gun> SORT_BY_EFFECTIVE = new Comparator<Gun>() {
        @Override
        public int compare(Gun o1, Gun o2) {
            int a = o1.getTtc().getEffective().getEffective();
            int b = o2.getTtc().getEffective().getEffective();
            int cmp = a > b ? +1 : a < b ? -1 : 0;

            return cmp;
        }
    };

    public static final Comparator<Gun> SORT_BY_MATERIAL = (o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial());


    public static final void sortByModel(Guns guns){
        Collections.sort(guns.getGuns(), SORT_BY_MODEL);
    }
    public static final void setSortByOrigin(Guns guns){
        Collections.sort(guns.getGuns(), SORT_BY_ORIGIN);
    }
    public static final void setSortByEffective(Guns guns){
        Collections.sort(guns.getGuns(), SORT_BY_EFFECTIVE);
    }
    public static final void setSortByMaterial(Guns guns){
        Collections.sort(guns.getGuns(), SORT_BY_MATERIAL);
    }
}
