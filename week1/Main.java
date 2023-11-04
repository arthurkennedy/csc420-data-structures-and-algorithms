import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {

        //Display your name and email address as the first output
        System.out.println("Arthur A. Kennedy - kennedya3@csp.edu");
        //display message indication that this is your own work
        System.out.println("This is my own work");

        try {
            File textObj = new File("C:\\Users\\arthu\\Data Structures and Algorithms\\csc420-data-structures-and-algorithms\\week1\\data.txt");
            Scanner textReader = new Scanner(textObj);

            while (textReader.hasNextLine()) {
                String data = textReader.nextLine();
                System.out.println(data);
            }

            textReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
       

    }
}
