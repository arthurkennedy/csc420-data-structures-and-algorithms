/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.ArrayList;

import Band.Band;

/**
 *
 * @author arthu
 */
public class MergeSort {
    
    private String by = "name";
    
    //setter and getter 
    public void setSortBy(String by){
        this.by = by;
    }
    
    private String getSortBy(){
        return this.by;
    }
    
    private Boolean isLeftToRight(Band left, Band right){
        if(this.getSortBy() == "name"){
            String leftName = left.getName();
            String rightName = right.getName();
            
            if(leftName.compareTo(rightName) <= 0){
                return true;
            }else {
                return false;
            }
        }else {
            int leftSingleCount = left.getSingleCount();
            int rightSingleCount = right.getSingleCount();
            
            if(leftSingleCount <= rightSingleCount){
                return true;
            }else {
                return false;
            }
        }
    }
    
    private void Merge(ArrayList<Band> list, ArrayList<Band> left, ArrayList<Band> right){
        int i = 0, j = 0, k = 0;

        // Compare elements from left and right and merge them in sorted order
        while (i < left.size() && j < right.size()) {
            
            Band leftBand = left.get(i);
            Band rightBand = right.get(j);
            
            if(isLeftToRight(leftBand, rightBand)){
                list.set(k++, left.get(i++));
            }else {
                list.set(k++, right.get(j++));
            }
           
        }

        // Copy remaining elements of left and right to the merged array
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
    
    public void Sort(ArrayList<Band> list){
        int listSize = list.size();
        if(listSize > 1){
            int mid = (listSize / 2);
            ArrayList<Band> left = new ArrayList<>(list.subList(0, mid));
            ArrayList<Band> right = new ArrayList<>(list.subList(mid, listSize));
            
            Sort(left);
            Sort(right);
            
            Merge(list, left, right);
        } 
    }
    
}
