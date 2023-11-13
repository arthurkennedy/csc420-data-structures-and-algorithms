/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import java.util.*;

import Band.Band;


/**
 *
 * @author arthu
 */
public class Search {
    
    public static Band Binary(ArrayList<Band> list, String target){
        int listSize = list.size();
        if(listSize > 1){
            
            int mid = listSize / 2;
            ArrayList<Band> newList;
            
            Band band = list.get(mid);
            String bandName = band.getName().toLowerCase();
            
            int compare = bandName.compareTo(target);
            
            if(compare < 0){
                newList = new ArrayList<>(list.subList(mid, listSize));
            }else if(compare > 0){
                newList = new ArrayList<>(list.subList(0, mid));
            }else {
                return band;
            } 
            
            return Binary(newList, target);
        }
        
        return null;
    }
    
    public Band Linear(ArrayList<Band> list, int target){
        Band last = list.get(0);
        int lastCount = 0;
        
        for (Band b : list) {
            
            int singleCount = b.getSingleCount();
            
            if(singleCount >= target){
                int lastNearTarget = Math.abs(target-lastCount);
                int currentNearTarget = Math.abs(target-singleCount);
                
                if(lastNearTarget < currentNearTarget){
                    return last;
                }else {
                    return b;
                }
                        
            }
            
            last = b;
            lastCount = singleCount;
        }
        
        return last;
    }
}
