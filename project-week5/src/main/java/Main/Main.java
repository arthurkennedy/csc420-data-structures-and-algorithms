/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import trees.AVLTree;
import processinfo.ProcessInfo;

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
        
        try {
            
            //Load of list of band and singles
            File textObj = new File("processList.txt");
            Scanner textReader = new Scanner(textObj);
               
            AVLTree<ProcessInfo> tree = new AVLTree<>();
            while (textReader.hasNextLine()) {
                
                String data = textReader.nextLine();
                
                String[] dataArray = data.split("\\|");
                
                String name = dataArray[0];
                int id = Integer.parseInt(dataArray[1]);
                int priority = Integer.parseInt(dataArray[2]);
                int runtime =  Integer.parseInt(dataArray[3]);
                
                ProcessInfo newInfo = new ProcessInfo(name, id, priority, runtime);
                
                tree.insert(newInfo);
                System.out.println(newInfo);
                
            }
            textReader.close();
            
            tree.inorder();
            
            System.out.println("\n");
            
            tree.levelorder();
            
            System.out.println("\n");
        
            
            int isDone = 0;
            
            while(isDone == 0){
                Iterator<ProcessInfo> iterator = tree.iterator();
                
                while(iterator.hasNext()){
                    ProcessInfo element = iterator.next();
                    int priority = element.getProcessPriority();

                    int execTime = 10;
                    for(int i = 0; i < 10; i++){
                        if(priority == i){
                            if(execTime >= 0){
                                
                                if(element.executeProcess(execTime)){
                                    isDone = 1;
                                    System.out.println(element.displayCompletedInfo());
                                    element.endProcess();
                                }else {
                                    isDone = 0;
                                }
                            }
                        }
                        execTime -= 1;
                    }
                }
            }
            
            Iterator<ProcessInfo> iterator = tree.iterator();
                
            while(iterator.hasNext()){
                ProcessInfo element = iterator.next();
                
                System.out.println("\n Process Name: " +element.getProcessName() + "\t Process Priority: " + element.getProcessPriority() + "\t Completion Time: " + element.getProcessElapsedTime());
            }
            
          
            
            
            
            
          
        
        }catch (FileNotFoundException e){
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
