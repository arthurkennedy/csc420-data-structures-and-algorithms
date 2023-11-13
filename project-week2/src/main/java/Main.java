import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
        
import Band.Band;
import Sort.MergeSort;
import Search.*;

import java.util.ArrayList;


/**
 *
 * @author arthu
 */

public class Main {
    
    public static void main(String[] args){
        //Display your name and email address as the first output
        System.out.println("Arthur A. Kennedy - kennedya3@csp.edu");
        //display message indication that this is your own work
        System.out.println("I certicy that this is my own work");
        
        try{
            
            //Load of list of band and singles
            File textObj = new File("bandinfo.txt");
            Scanner textReader = new Scanner(textObj);
            
            // loading file data into a Collection object.
            
            //create an Set to hold bands
            ArrayList<Band> bandList = new ArrayList<>();
            while (textReader.hasNextLine()) {
                Band band = new Band();
                
                String data = textReader.nextLine();
                
                String[] bandInfo = data.split("\\|");
                
                String name = bandInfo[0];
                int singleCount = Integer.parseInt(bandInfo[1]);
                
                band.setName(name);
                band.setSingleCount(singleCount);
                
                bandList.add(band);
            }
            textReader.close();
            
             MergeSort mergeSort = new MergeSort(); //create new merge sort
             
             Search search = new Search(); //create new search
            
            //Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);
            
            int userInput = 0;
            while(userInput != 3){
                
                System.out.println("\n\nSearch by Band Name (1) or Single Count (2):");
                
                //Read user's input
                userInput = scanner.nextInt();
                
                if(userInput == 1){
                    
                    System.out.println("Enter Band Name you are looking for: ");
                    
                    //Search band by name
                    mergeSort.setSortBy("name");
                    mergeSort.Sort(bandList);
                    
                   
                    
                    Scanner textScanner = new Scanner(System.in);
                    String searchText = textScanner.nextLine();
                    
                    Band band = search.Binary(bandList, searchText.toLowerCase());
                    
                    if(band != null){
                        System.out.println("Bandname is: " + band.getName());
                        System.out.println("Band found is: " + band.toString());
                    }else {
                        System.out.println("OOPS.. Band not found!");
                    }
                    
                }else if(userInput == 2){
                    System.out.println("Enter the Set Time you are looking for: ");
                    
                     //Search band by name
                    mergeSort.setSortBy("singleCount");
                    mergeSort.Sort(bandList);
                    
                    Scanner countScanner = new Scanner(System.in);
                    int searchCount = countScanner.nextInt();
                    
                    Band band = search.Linear(bandList, searchCount);
                    
                    if(band != null){
                        System.out.println("Band with closest set time is: " + band.toString());
                    }else {
                        System.out.println("OOPS.. Band not found!");
                    }
                
                }else if(userInput == 3) {
                    System.out.println("Good Bye!");
                }else {
                    System.out.println("That was not a valid input (Enter 3 to exit)");
                }
                
            }
            
            
            
            
        }catch (FileNotFoundException e){
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
