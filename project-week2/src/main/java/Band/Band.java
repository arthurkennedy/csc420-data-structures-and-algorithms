/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Band;

/**
 *
 * @author arthu
 */
public class Band {
    private String name;
    private int singleCount;
    
    //setter and getter 
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setSingleCount(int count){
        this.singleCount = count;
    }
    public int getSingleCount(){
        return singleCount;
    }
    
     //print object as string
    @Override
    public String toString() {
        return this.name + " had " + this.singleCount + " singles";
    }
}
