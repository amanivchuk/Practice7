package ua.nure.manivchuk.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nec on 14.12.17.
 */
public class Guns {
    private List<Gun> gunList;

    public List<Gun> getGuns(){
        if(gunList == null){
            gunList = new ArrayList<Gun>();
        }
        return gunList;
    }

    @Override
    public String toString(){
        if(gunList == null || gunList.size() == 0){
            return "No guns";
        }
        StringBuilder result = new StringBuilder();
        for(Gun g : gunList){
            result.append(g).append('\n');
        }
        return result.toString();
    }
}
