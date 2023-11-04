import PasswordHasher.PasswordHasher;
import User.User;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        
        //declare passwordhasher
        PasswordHasher hasher = new PasswordHasher();

        //Display your name and email address as the first output
        System.out.println("Arthur A. Kennedy - kennedya3@csp.edu");
        //display message indication that this is your own work
        System.out.println("This is my own work");

        try {
            //Load of list of username and passwords
            File textObj = new File("unencryptedPasswords.txt");
            Scanner textReader = new Scanner(textObj);
            
            // loading file data into a Collection object.
            
            //create an ArrayList to hold our users
            ArrayList<User> myUsers = new ArrayList<>();
            while (textReader.hasNextLine()) {
                User user = new User();
                
                String data = textReader.nextLine();
                
                String[] userInfo = data.split("\\|");
                
                String username = userInfo[0];
                String password = userInfo[1];
                
                //generate password salt
                byte[] salt = hasher.makeSalt(password.length());
                
                //generate hashedPassword
                String hashedPassword = hasher.makeHashedPassword(password, salt);
                
                //add to user
                user.setUsername(username);
                user.setPassword(password);
                user.setSalt(salt);
                user.setHashedPassword(hashedPassword);
                
                myUsers.add(user);
            }
            textReader.close();
            
            //display sorted users
            System.out.println("Display Sorted Users");
            
            Collections.sort(myUsers);
            
            System.out.println("--------------------------");
            for (User u : myUsers) {
                System.out.println(u.toString());
            }
            System.out.println("--------------------------");
            
            //display sorted passwords
            System.out.println("Display Sorted Passwords");
            
            Collections.sort(myUsers, new User.passwordComparator());
            System.out.println("--------------------------");
            for (User u : myUsers) {
                System.out.println(u.toString());
            }
            System.out.println("--------------------------");
            
            
            //display sorted Hashed Passwords
            System.out.println("Display Sorted Hashed Passwords");
            
            Collections.sort(myUsers, new User.passwordHashedComparator());
            System.out.println("--------------------------");
            for (User u : myUsers) {
                System.out.println(u.toString());
            }
            System.out.println("--------------------------");
            
            
            
            
            
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
       

    }
}
