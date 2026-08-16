/*
Khadijah U.
  Hangman game for the user to be able to get clues, basically a word guessing game
  */
package minigame;//create package
import java.util.*;//import array class

public class HangMan{

  Scanner input = new Scanner(System.in);
  //attributes
 public int attempts;//these are only the wrong attempts!
  private String hangman;//the actual hangman
  private static String words[]={"clues", "think", "sleep","basic", "break","spies","files", "laser"};//words for the hangman game
  private String word;
  private char newGuess;
  private String userWord="";
  private char guessWord[] = {'_', '_', '_', '_', '_'};//all words will be 5 letters and each correct guess will replace a dash in the respective place;
//  private ArrayList<String> guess = new ArrayList<String>();

  //constructors
  public HangMan(){
    word = words[(int)(Math.random()*words.length)];//generate a word for the game
    attempts = 6;//only 6 wrong attempts allowed that make up the head, body, both arms, and both legs of the hang man
    hangman = "__\n |\n";//the hangman hook
  }
  
  //getters
  public String getHangman(){
    return hangman;
  }
  public int getAttempts(){
    return attempts;
  }
  public String getGuessWord(){
    return new String(guessWord);//create a string to display how much of the word the user has guessed
  }
 
  //no getter for the actual word as it is not accessible or viewable until user fails or wins (The program will display the word only then)
  //no getter for the attemps as the hangman will show the attempts left

  //setters

  public void setGuess(char newGuess){/////////////main!
    if(attempts!=0){//only be able to set IF the user has attempts left
      
      /* //check if it has already been guessed
      for(String g: guess){
         if(g == newGuess){
            System.out.println("word already guessed");
          }
        }*/


          if(word.indexOf(newGuess)!=-1){//check if the char exists within the word
              //to make sure every instance gets replaced
              for(int j = 0;j<5;j++){
                if(word.charAt(j)==newGuess){
                guessWord[j] = newGuess;//place it where it exists
                }
             }
                }
          
          else if(word.indexOf(newGuess)==-1){
            attempts--;
            if(attempts == 5){//assigning the hangman based on attempts left
              hangman = "__\n |\n O";
                }
            else if(attempts == 4){
              hangman = "__\n |\n O\n |";
                }
            else if(attempts == 3){
              hangman = "__\n |\n O\n/|";
                }
            else if(attempts == 2){
              hangman = "__\n |\n O\n/|\\";
                }
            else if(attempts == 1){
              hangman = "__\n |\n O\n/|\\\n/";
                }
            else{
              hangman = "__\n |\n O\n/|\\\n/\\";
                }//end else
              }//end else
         }
         
       
      
     for(char c: guessWord){
        System.out.print(c);
      }
     
     
    if(attempts==-1){
      throw new IllegalArgumentException("No attempts left! Start new game");//throw exception if theres no attempts left
      }
     System.out.println("\n"+hangman);
      System.out.println("");//add line space
 
    }//end setter

  public String getWord(){
    return word;
  }

public boolean win(){//to check if the user won or not
   if(String.valueOf(guessWord).equalsIgnoreCase(word)){
      return true;
    }
    else{
      return false;
    }
}

  public boolean gameEnd(){//to check if the user has attempts left
    if(attempts==0){
      return true;
    }
    else {
      return false;
    }
  }
  
}//end class