/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.Comparator;

/**
 *
 * @author arthu
 */
public class User implements Comparable<User>{
    private String username;
    private String password;
    private byte[] salt;
    private String hashedPassword;
    
    //Getters and Setters 
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public byte[] getSalt(){
        return salt;
    }
    
    public void setSalt(byte[] salt){
        this.salt = salt;
    }
    
    public String getHashedPassword(){
        return hashedPassword;
    }
    
    public void setHashedPassword(String hashedPassword){
         this.hashedPassword = hashedPassword;
    }
    
    //print object as string
    @Override
    public String toString() {
        return "\n User: " + username + "\n\t Password: " + password + "\n\t HashedPassword: " + hashedPassword;
    }
    
    
    //this is a require override since we are implementing Comprable
     @Override
     public int compareTo(User u) {
         return this.getUsername().compareToIgnoreCase(u.getUsername());
     }
     
    //this is a custom sorting class
    public static class passwordComparator implements Comparator<User> {

        @Override
        public int compare(User u1, User u2) {
            return u1.getPassword().compareToIgnoreCase(u2.getPassword());
        }
    }
    
    //this is a another custom sorting class
    public static class passwordHashedComparator implements Comparator<User> {

        @Override
        public int compare(User u1, User u2) {
            return u1.getHashedPassword().compareToIgnoreCase(u2.getHashedPassword());
        }
    }
    
}
