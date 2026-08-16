//Alesha H.
package clues;
import profile.Profile;
public class Clues{

//connect to my story 

  
  //Attrubutes
  private String [] s3EasyClues;
  private String [] s3MediumClues;
  private String [] s3HardClues;
  
  private String [] s2EasyClues;
  private String [] s2MediumClues;
  private String [] s2HardClues;
  
  private String [] s1EasyClues;
  private String [] s1HardClues;
  private String [] s1MediumClues;
  //actual clues that will be used by whatever profile is
  private String[] clue1;
  private String[] clue2;
  private String[] clue3;//clues for each story
  private int currentClueS1;
  private int currentClueS2;
  private int currentClueS3;
  
//clues are assigned based on profile
  public Clues(Profile p){
    //instantiate arrays
    s3EasyClues = new String [3];
    s3MediumClues = new String [2];
    s3HardClues = new String [1];
    
    s2EasyClues = new String [3];
    s2MediumClues = new String [2];
    s2HardClues = new String [1];
    
    s1EasyClues = new String[3];
    s1MediumClues = new String[2];
    s1HardClues = new String[1];
    currentClueS1 = 0 ;
    currentClueS2 = 0;
    currentClueS3 = 0;

    ///assign clues to the arrays
    //different clues would be given

    
    //EASY
    // 3 easy clues for story 3 - alesha
    s3EasyClues[0] = "|||The alarm was disabled before the blackout.|||";
    s3EasyClues[1] = "|||Only one suspect knew the museum’s security override code.|||";
    s3EasyClues[2] = "|||Security camera footage was manually erased.|||";
    
  
    //Easy Clues for Story 2(AKA Rida's)
    s2EasyClues[0] = "A witness reported seeing one suspect near the library shortly before the necklace disappered.";
    s2EasyClues[1] = "The display case showed no signs of demage, suggested the thief knew how to open it.";
    s2EasyClues[2] = "One Suspect's explanation of thier whereabouts did not completely match another witness statement.";

    //easy clues for story 1 - Khadijah
    s1EasyClues[0] = "Alesha hadn't taken her chromebook out in room 3217";
    s1EasyClues[1] = "Aleshas chromebook had stickers of totally spies while the chromebook the janitor had seen had 67 stickers";
    s1EasyClues[2] = "Did Alesha check her bag thoroughly?";
    
    //MEDIUM
    
    // 2 medium clues for story 3 - alesha 
    s3MediumClues[0] = "|||Someone had access to the control room.|||";
    s3MediumClues[1] = "|||The footage disappeared after the theft.|||";

    
    //Medium Clues for Story 2(AKA Rida's)
    s2MediumClues[0] = "The necklace disappered while several people were moving between different areas of the school.";
    s2MediumClues[1] = "Someone fimiliar with the event preparations has access to locations other student could not easily enter.";

     //medium clues for story 1 - Khadijah
    s1MediumClues[0] = "Alesha hadn't taken her chromebook out in room 3217";
    s1MediumClues[1] = "Aleshas chromebook had stickers of totally spies while the chromebook the janitor had seen had 67 stickers";

    //HARD
    //1 Hard clue for stroy 3 - alesha
    s3HardClues[0] = "|||Camera footage disappeared after power returned.|||";
    
    
    // Advacne clues for Story 2(AKA Rida's)
    s2HardClues[0] = "The thief apperad to know where people were least likely to notice suspicious Activity.";

    //Advanced clues for storu 1 - Khadijah
    s1HardClues[0] = "Emphasis on Alesha not having taken her chromebook out all day";
    
    if(p.getType().equals("Beginner")){
      clue1 = s1EasyClues;
      clue2= s2EasyClues;
      clue3=s3EasyClues;
    }
    if(p.getType().equals("Advanced")){
      clue1 = s1HardClues;
      clue2= s2HardClues;
      clue3=s3HardClues;
    }
    if(p.getType().equals("Intermediate")){
      clue1 = s1MediumClues;
      clue2= s2MediumClues;
      clue3=s3MediumClues;
    }
      
  }
 

  public void displayClue(int story){
    if(story == 1)
   { 
     if(currentClueS1 < clue1.length){ //Only show clues if there are clues remaining check by counter for everytime player wins riddle
      System.out.println("\nCLUE UNCLOCKED: " + clue1[currentClueS1]);
      currentClueS1++;
      }
    else{
      System.out.println("No clues left");
    }
   }
    else if(story ==2){
      if(currentClueS2 < clue2.length){ //Only show clues if there are clues remaining check by counter for everytime player wins riddle
      System.out.println("\nCLUE UNCLOCKED: " + clue2[currentClueS2]);
      currentClueS2++;
      }
    else{
      System.out.println("No clues left");
    }
    }
    else{
      if(currentClueS3 < clue3.length){ //Only show clues if there are clues remaining check by counter for everytime player wins riddle
      System.out.println("\nCLUE UNCLOCKED: " + clue3[currentClueS3]);
      currentClueS3++;
      }
    else{
      System.out.println("No clues left");
    }
    }
  }
 //chexk if score is given to user after mini game for each diffuiculty level 
}