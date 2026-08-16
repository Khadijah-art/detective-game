//Alesha H.
package story;
import java.util.*;
import java.io.*;
public class Story3{
  Scanner input = new Scanner (System.in);


  //Attibutes
  public static final String TITLE = "CASE NO.3 - Missing crown";
  public static final String LOCATION = "Versailles Mueseum";
  public static final String CRIME = "The display case was untouched and locked. Security logs show a 45-second blackout window where internal motion sensors were disabled. Footprints near the emergency exit suggest someone exited through restricted staff corridors";
  
  private static final String CULPRIT = "Security guard"; 
  private static final String [] suspects = {"Security guard", "Designer", "Staff event organizer"};

  private static final String EVIDENCE = "Pink glitter found near the display case";
  private static String line;
  
  


  //default constructor
  public Story3(){
  }


  //gettters
  public String getTitle(){
    return TITLE;
  }
   public String getCulprit(){
    return CULPRIT;
  }
  public String getCrime(){
    return CRIME;
  }
  public String [] getSuspects(){
    return suspects;
  }
  public String getEvidence(){
    return EVIDENCE;
  }
  
  
  public void displayStory(){
    
    try{
      FileReader fr = new FileReader ("s3.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      
      while(line!=null){
        System.out.println(line);
        
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){
          System.out.println("Error timer");
        }
    line = br.readLine();
  }
      br.close();
}catch(IOException e){
  System.out.println("Error while reading file");
}
}



public void display(String difficulty){
  
 //Display info  -- can make a display method for it in story class
      System.out.println("\n\n***********CASE: " + TITLE + "***********");
      System.out.println("CRIME SCENE: " + CRIME);
      System.out.println("EVIDENCE found: " + EVIDENCE + "\n---------------------------------------------------------------------------------");
  
     if(difficulty.equalsIgnoreCase("Easy")){
      //easy have suspects etc
      System.out.println("\nSUSPECT LIST:\n All of them had access to the exhibition");
      System.out.println("1. " + suspects[0] + " - Controlled security systems during blackout");
        System.out.println("2. " + suspects[1] + " - Organized the event and was last seen near the exhibit area");
        System.out.println("3. " + suspects[2] + " - Had staff clearance to restricted zones");
    }

       
else if(difficulty.equalsIgnoreCase("Medium")){
      //medium - no cles for suspect
  System.out.print("\nPeople connected to the case: ");
}

  else{
  //hard dont give any suspect or clue - less info
  System.out.println("Three individuals were in the museum during the blackout.\nOne controlled the security systems\n.One was the final visitor before closing.\nOne had access to staff-only areas.");
  }
  }


}//class