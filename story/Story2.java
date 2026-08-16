/*
Name: Rida F
Date: June 7- 2026
Pupose:This Class Contains story2, "The missing Necklace", It displays the story, suspects, location, methods, and it also checks whether the user answers are correct or not */
package story;
import java.io.*;

public class Story2{

  //Constants
  private static final String TITLE = "The Missing Necklace";//Title
  //Correct answers for the case
  private static final String CULPRIT = "Alex";//suspect
  private static final String LOCATION = "Library";//Location
  private static final String METHOD = "Theft";//Method
  //Attributes(Arrays stores possible answers)
  private String [] suspect;
  private String [] location;
  private String [] method;
  public String line;
  public String paragraph;
  public String suspectName;

  //Default Constructor(sets the suspect, location, method)
  public Story2(){
    suspect = new String[]{"Mia", "Alex", "Jordan"};
    location = new String[]{ "Library","Gym","Cafeteria"};
    method =  new String []{"Hidden", "Theft","Trap"};
    paragraph = "";
  }
  //Reads and displays story2 from text file
  public void displayStory(){
    System.out.println(" \t ____________________________");
    System.out.println(" \t|                           |");
    System.out.println("\t|Case: "+ TITLE+" |");
   System.out.println(" \t|___________________________|\n");
  try{
        Thread.sleep(2000);
      }catch(InterruptedException e){System.out.println("Pausing Error");}
      
    try{
    FileReader fr = new FileReader("s2.txt");
    BufferedReader br = new BufferedReader(fr);
    line = br.readLine();
    while(line!= null){
      if(line.equals("")){//checks if the line is empty (end of the paragrapgh)
        System.out.println(paragraph);
      try{
        Thread.sleep(8000);//Wait for 8 seconds before showing next grapgh
      }catch(InterruptedException e){
        System.out.println("System Couldn't Pause");
      }
      paragraph = "";//clear the paragraph for next section
    }
    else{
      paragraph += line+"\n";//Keep adding lines to the paragrapghs
    }
    line = br.readLine();//Read next line from file
  }
      System.out.println(paragraph); //print last paragraph
  }catch(IOException e){
      System.out.println("Error Reading From File");
  }
  }
  //Displaying all 3 suspects
  public void displaySuspects(){
    System.out.println("\n Suspects:");
    for(String s: suspect){
      System.out.println("- "+ s);
      try{
        Thread.sleep(1000);//Wait 1 second before showing next suspect
      }catch(InterruptedException e){System.out.println("Pause Error");}
    }
  }
    //Displaying all 3 locations
  public void displayLocations() {
    System.out.println("\nLocations: ");
    for(String l:location){
      System.out.println("- "+ l);
      try{
        Thread.sleep(1000);//Wait 1 second before showing next location
      }catch(InterruptedException e){System.out.println("Pause Error");}
    }
  }
    //Displaying all Methods
  public void displayMethods(){
    System.out.println("\nMethods: ");
    for(String m: method){
      System.out.println("- " + m);
      try{
        Thread.sleep(1000);//Wait 1 second before showing next Method
      }catch(InterruptedException e){System.out.println("Pause Error");}
    }
  }
  //Check if the user answers are correct and returns true or false
  public boolean solveCase(String suspect, String location, String method){
   if(suspect.equalsIgnoreCase(CULPRIT) && location.equalsIgnoreCase(LOCATION) && method.equalsIgnoreCase(METHOD)){
     return true;
   }else{
     return false;
   }
  }
  //Displays the point of view for one suspect
  public void displayPOV(String suspectName){
    //Mia's pov
    if(suspectName.equalsIgnoreCase("Mia")){
      System.out.println("- I was helping organize books near the back shelves.\n- I noticed people moving in and out of the library, but I did not touch the display case.");
    }
      //Jordan's Pov
    else if(suspectName.equalsIgnoreCase("Jordan")){
      System.out.println("- I was working near the display case and helping near visitors\n- The case looked normal earlier, but the later everyone started saying the necklace was gone.");
    }
      //Alex's pov
    else if(suspectName.equalsIgnoreCase("Alex")){
      System.out.println("- I was helping prepare for the anniversery event.\n- I only passed the display Case one time");
      
    }else{
      System.out.println("INVALID SUSPECT");//If suspectName doesn't match alex,mia, jordan
      
    }
  }
//Display message if the case is solved
  public void displayCaseSolved(){
    System.out.println("\n Case Solved!");
    System.out.println("You Successfully found the thief and recovered the necklace.");
  }
  //Display message if the case is unsolved
  public void displayCaseFailed(){
    System.out.println("\nWRONG ANSWER!!!");
  }
}