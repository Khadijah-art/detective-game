/*
Name: Rida F.
Date: June 7- 2026
Pupose:This Class Keeps track of the player's Score, and unlocked clues. THe scores increases when the player wins mini Games. It also determines whether player has enough points to unlock clues. */
package scoring;

public class Scoring{

  //Attributes
  private int score;
  private int cluesUnlocked;
  private int neededScore;
  private int nextClueScore;

  //Defualt Constructor(sets the starting score and clues)
  public Scoring(){
    score = 0;
    cluesUnlocked = 0;
  }
  //Getters(return the current score)
  public int getScore(){
    return score;
  }
  //Return how many clues are unlocked
  public int getCluesUnlocked(){
    return cluesUnlocked;
  }
  //Add 5 points when the player wins any game
  public void addMiniGameWin(){
    score +=  5;
  }
  //Add one unlocked clue
    public void unlockClue(){
    cluesUnlocked++;
  }
  public int getMaxClue(String type){
    if(type.equalsIgnoreCase("Beginner")){
      return 3;
    }else if(type.equalsIgnoreCase("Intermediate")){
      return 2;
    }else{
      return 1;
    }
  }
  public boolean hasClueLeft(String type){
    if(cluesUnlocked < getMaxClue(type)){
      return true;
    }else{
      return false;
    }
  }
  }