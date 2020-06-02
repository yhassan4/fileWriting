import java.io.*;
import java.util.Scanner;
public class WritingExampleApp{
 public static void main(String[] args){
  boolean moreData = true;
  try{
    while (moreData) {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a first name: ");
      String fn = "First name: " + in.nextLine();
      System.out.print("Enter a last name: ");
      String ln = "Last name: " + in.nextLine();
      System.out.print("Enter an age: ");
      int age = in.nextInt();
      File file = new File("names.csv");
      boolean created = file.createNewFile();

      if(created){
        System.out.println(file.getName() + " created");
      }

      WritingExample we = new WritingExample(file);
      we.writeToFile(fn, ln, age);

      Scanner inp = new Scanner(System.in);
      System.out.print("Would you like to add more date? \nEnter yes or no: ");
      String yesOrNo = inp.nextLine();
      if (yesOrNo.equalsIgnoreCase("no")) {
        moreData = false;
      }
    }


  }
  catch(IOException ioe){
    System.out.println("Error with the file");
  }
 }
}
