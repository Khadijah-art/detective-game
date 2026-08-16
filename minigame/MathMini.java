/*
Name: Rida F,
Date: June 7- 2026
Pupose: THis Class created the Math Mini Game. The player answers three math questions. If at least two answers are correct, The players wins mini game.*/
package minigame;

public class MathMini{
  
  //Attributes
  private String [] questions;//Stores math questions
  private int [] answers;//Stores question's answers
  private int correctCount;//Counts the correct answers player got

  //Default Constructors(sets the questions and answers)
  public MathMini(){
    questions = new String[]{"A detective found 30 prints, 12 were fake, How many real? ", "Solve: (6 X 5) - 8", "A thief stole $200, spent $75, Remainging?"};
      answers = new int[]{18,22,125};
    correctCount = 0;
  }
  //Return one question
    public String getQuestions(int index){
    return questions[index];
  }
  //CHeck if the user's answer is correct
    public void checkAnswer(int userAnswer, int index){
    if(userAnswer == answers[index]){
      correctCount ++;
    }
  }
  // Getters(Return how many answers were correct)
  public int getCorrectCount(){
    return correctCount;
  }
  //Player wins if they got atleast two answers correct. 
    public boolean hasWon(){
      if(correctCount >=2){
        return true;
      }else{
        return false;
      }
    }
}