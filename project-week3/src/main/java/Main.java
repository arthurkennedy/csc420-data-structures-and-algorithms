
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthu
 */
        
public class Main {
    
    public static Map getBuckets(ArrayList<String> words, int index){
        
        //I chose this collection object because it will sort the keys in an accending order
        Map<Character, Queue<String>> buckets = new TreeMap<>();
        
        for (String value : words){
            
            //I chose a Queue because It is first in and first out.
            Queue<String> bucket;
            
            String cleanValue = value.replaceAll("\\s", "");
            char character = '*';
            
            if(index >= 0 && index < cleanValue.length()){
                character = cleanValue.charAt(index);
                character = Character.toLowerCase(character);
            }
            
            if(buckets.containsKey(character)){
                bucket = buckets.get(character);
                bucket.offer(value);
            }else {
                bucket = new LinkedList<>();
                bucket.offer(value);
            }
            
            buckets.put(character, bucket);
            
        }
        
        return buckets;
    }
    
    public static void main(String[] args){
        
        //Display your name and email address as the first output
        System.out.println("Arthur A. Kennedy - kennedya3@csp.edu");
        //display message indication that this is your own work
        System.out.println("I certicy that this is my own work");
        
        try {
            
            //Load of list of band and singles
            File textObj = new File("words.txt");
            Scanner textReader = new Scanner(textObj);
            
            //create an Array to hold chanllenges
            ArrayList<String> challenges = new ArrayList<>();
            
            while (textReader.hasNextLine()) {
                
                String data = textReader.nextLine();
                
                challenges.add(data);
            }
            textReader.close();
            
            for(int i = 19; i >= 0; i--){
                
                System.out.println("\nIterating on index: " + i);
                
                Map<Character, Queue<String>> buckets = getBuckets(challenges, i);
                
                ArrayList<String> newChallenges = new ArrayList<>();
                
                for (char key: buckets.keySet()){
                    Queue bucket = buckets.get(key);
                    Iterator<String> iterator = bucket.iterator();
                    
                    while (iterator.hasNext()) {
                        String element = iterator.next();
                        newChallenges.add(element);
                        
                        System.out.println("\t"+element);
                    }
                }
                
                challenges = newChallenges;
            }
        
        }catch (FileNotFoundException e){
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
