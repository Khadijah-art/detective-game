//Alesha H.
package minigame;
import scoring.Scoring;
public class Riddles{


  //Attributes
  private String miniChoice; // mini game chosen
  //private int score;
  private int starsRemaining;
  private boolean cluesUnlocked; 
  
  private String [] riddles; //store multiple riddles
  private String [] answers;
  
  private int currentQ;// track which riddles
  private Scoring scoring; //connect scores class
  

  //Default constrctor

  public Riddles(String difficulty, Scoring scoring){
    this.scoring = scoring;
    miniChoice = "_";
   // score = 0;
    riddles = new String [5]; 
    answers = new String [5];

//3 stars for 1 clues


    
    if(difficulty.equalsIgnoreCase("Easy")){ 
      starsRemaining = 6; //stars in box 
        //diff riddles each time
      riddles[0] ="I speak without a mouth and hear without ears. What am I";
      riddles[1] = "What has keys but can't open locks?";
      riddles[2] = "What has hands but cannot clap?";
      riddles[3] = "The more you take, the more you leave behind. What are they?";
      riddles[4] = "What runs but never walks?";
      //riddle ans
      answers[0] = "echo" ;
      answers[1] = "piano";
      answers[2] = "clock";
      answers[3] = "footsteps";
      answers[4] = "water";
    }
    else if (difficulty.equalsIgnoreCase("medium")){//medium stars 
      starsRemaining = 4; //stars in box less stars given meaning less guesses given 
      riddles[0] = "I have cities but no houses, mountains but no trees, and water but no fish.";
      riddles[1] = "What can travel around the world while staying in the same corner?";
      riddles[2] = "What gets wetter the more it dries?";
      riddles[3] = "What belongs to you but is used more by others?";
      riddles[4] = "What comes once in a minute, twice in a moment, but never in a thousand years?";

      answers[0] = "map" ;
      answers[1] = "stamp";
      answers[2] = "towel";
      answers[3] = "name";
      answers[4] = "water";
    }
    else{//hard
      starsRemaining = 3; //stars in box 1 
       riddles[0] = "I am always in front of you but can never be seen.";
        riddles[1] = "The person who makes it doesn't need it. The person who buys it doesn't use it.The person who uses it doesn't know it.";
      riddles[2] = "What disappears the moment you say its name?";
      riddles[3] = "The more you have of me, the less you see. What am I?";
      riddles[4] = "A man who was outside in the rain without an umbrella didn't get a single hair on his head wet. Why?";
      
      answers[0] = "future" ;
      answers[1] = "coffin";
      answers[2] = "silence";
      answers[3] = "darkness";
      answers[4] = "bald";
    }
 
    cluesUnlocked = false;
    currentQ = 0;
  }



  //GETTERS
  public String getMiniChoice(){ // whicever of he gma user chooses
    return miniChoice;
  }
  
  //public int getScore(){
   // return score;
  //}
  public int getStarsRemaining(){
    return starsRemaining;
  }
  public boolean getCluesUnlocked(){
    return cluesUnlocked;
  }
  public String getCurrentQ() { //dont go out of bound
        if (currentQ >= riddles.length) {
            currentQ = 0;
        }

        return riddles[currentQ];
  }
  
    
  


  //SETTERS
  public void setMiniChoice(String miniChoice){ //no use for now
    this.miniChoice = miniChoice;
  }
 // public void setScore(int score){
  //  this.score = score;
 // }
  public void setStarsRemaining(int starsRemaining){
    this.starsRemaining = starsRemaining ;
  }
  public void setCluesUnlocked(boolean cluesUnlocked){
    this.cluesUnlocked = cluesUnlocked;
  }
  /* public void setCurrentQ() {
      this.currentQ = currentQ;
   }

*/



  
  public void starpoints(){// have stars rmove and scores added and give out clue in main 
    if(starsRemaining>0){
      starsRemaining--;
      //convert star to a score class
      scoring.addMiniGameWin();
     // scoring.rewardPlayer(difficulty);
      System.out.println(" ★ Star used! +5 score added ");
      //score += 5; // 1 guess 5 pts and  1 star less and 1 clue given 
      cluesUnlocked = true;
      }
    else{
      System.out.println("No stars left!");
    }
    }

  //display stars and update 
  public void starDisplay(){
     System.out.print("[");
    for(int i=0; i< starsRemaining; i++){
      System.out.print("*");
    }
    System.out.print("]");
  }

  //check ans
  public boolean checkAns(String userAns){
    if(userAns.equalsIgnoreCase(answers[currentQ])){
      System.out.println("\n\n!!!!!!!Correct! You escaped the mini game!!! HERES YOUR CLUE: ");
      starpoints();

      //next riddle
      currentQ++;
      // Reset if beyond array
        if (currentQ >= riddles.length) {
            currentQ = 0;
        }
      return true;
    }

      //wrong ans
      else{
        System.out.println("Wrong answer! Still stuck in the mini game.");
        cluesUnlocked = false;
        // Move to next riddle
        currentQ++;
        if (currentQ >= riddles.length) {
            currentQ = 0;
        }
        return false;
  }
  }
  
  public String toString(){
    return "Total Score: " + scoring.getScore() + "Stars Remaining: " + starsRemaining;
  }

}//class