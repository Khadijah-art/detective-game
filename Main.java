/*
Detective investigation files
Khadijah U. / Alesha H. / Rida F.
  */

//importing libraries and packages
        // 3 versions of story 1 easy medum etc 
//import storyline.Story;
//import game.Minigame;
import clues.Clues;
import scoring.Scoring;



import minigame.*; 
import java.util.*; 
import story.*; 
import profile.*; 
import java.io.*;

public class Main { 
  public static void main(String[] args) { 

      //                             **********Khadijahs part ******
    //attributes 
  Scanner input = new Scanner(System.in); 
  Story1 s; 
  Profile p = new Profile(); 
  Scoring scoring = new Scoring();
  Clues clues = new Clues(p);
    
  //variables 
  String line;//for file reader 
  boolean test = false; 
  int choice,count = 0; 
  boolean ans = false; 
  String userCulprit;
  int storyRand;
  boolean unlockedClues;
       String difficulty = "";
    Riddles m1;


///////////profile test
    System.out.println("\t--------------------WELCOME TO DETECTIVE INVESTIGATION FILES! --------------------\n\nTry out the Detective type quiz to find out what kind of detective you are!\n");
     p.test(); //the profile test
      System.out.println(p); // profile status and score
      test = true; //confirmation that the profile test is done, if its false, the user cannot play a story
    clues = new Clues(p);
        if(p.getType().equalsIgnoreCase("Beginner")){
          difficulty ="Easy";
        }
        else if (p.getType().equalsIgnoreCase("Intermediate")){
          difficulty ="Medium";
        }
        else{
          difficulty = "Hard";
        }

   ////////////////////////MINIGAME CLASS
      m1 = new Riddles(difficulty,scoring);

    //printing the menu
  do{
    unlockedClues = false;
    System.out.println("\n________________________________________________________________________________________________________________________________________________________________\n\t\tWelcome to Detective Investigation Files!\n________________________________________________________________________________________________________________________________________________________________\n\n[1] View detective status\n[2] Investigate new file\n[3] Exit"); 
    
    do{ 
      try{ 
      System.out.print("(#): "); 
      choice = input.nextInt(); 
           } 
      catch(InputMismatchException e)
        { System.out.println("Invalid input!"); 
          input.next(); 
          choice = 4; 
        } 
    }while(choice>3 || choice<1); //make sure user chooses a valid menu option
    
    
    if(choice ==1){ //user can only do a profile test if they havent already done one
          System.out.println(p); // profile status and score
    } 


      //if user tries to access story after doing the profile test
    else if(choice==2){
      //randomizer for stories 
      storyRand = (int)(3*Math.random())+1;
        
        if(storyRand ==1){ 
        s = new Story1(p); //instantiate story
        
      //story intro 
      System.out.println("________________________________________________________________________________________________________________________________________________________________"); 
      System.out.println(Story1.info());//display the information like name, evidence, location 
      System.out.println("________________________________________________________________________________________________________________________________________________________________"); 

      //pause
      try
      {Thread.sleep(2000);}//add a pause between story and info so user can read the info
      catch(InterruptedException e){
        System.out.println("System couldn't pause");
      }
      
      //display story 
     Story1.storyDisplay(); //print the whole story

       //pause
     /* try
      {Thread.sleep(5000);}//another pause to give time for user to read the story
      catch(InterruptedException e){
        System.out.println("System couldn't pause");
      }*/           ////////////////commenting out the sleep method to stop it from pausing during demonstration
     
      //display questions based on difficulty 
      System.out.println("________________________________________________________________________________________________________________________________________________________________"); 
      do{ //questions displayed based on profile details
        if(count == 2) 
        {ans = false;}//only the final question can be right or wrong, reset ans value 

        //all questions are the same but have a different criteria based on their profile status
        if(p.getType().equals("Advanced")){ //
          s.questionsHard(); 
          } 
        else if(p.getType().equals("Intermediate")){ 
          s.questionsMedium(); 
          } 
        else{ s.questionsEasy(); 
            } 
        
        if(count ==2) {//when user gets to the final question
          ans = s.setAns(); //check if the final answer is correct
          
          if(ans == true){ //if the answer is correct, print a congratulations message
          System.out.println("\nGood job, Detective! Alesha did infact have her chromebook but it was deep in the abyss of her bag"); } 
          else{ //if ans is incorrect, user has to play a minigame to get a clue
            if(ans == false){
              boolean solved = false;
              while(solved == false && scoring.hasClueLeft(p.getType())){
        System.out.println("\nYou must win the mini Game to unlock a clue!");
    if(miniGames(storyRand,m1)){
      scoring.addMiniGameWin();//Add 5 points
      scoring.unlockClue();//Count one clue unlocked
      System.out.println("\nMiniGame Won");
      System.out.println("Current Score: "+ scoring.getScore());
      System.out.println("Profile Type: "+p.getType());//test line to check difficulty
      clues.displayClue(storyRand);//SHow story 2 clue
        System.out.println("\n\tTry Solving Again!");
        System.out.print("\nWho do you think is the culprit: ");
      userCulprit = input.next();
      s.reAns(userCulprit);
      if(s.setAns()){
        System.out.println("Good Job Detective");
        solved = true;
      }else{
          System.out.println("\nStill Incorrect");
        }
          }
        }
        if(solved == false){
          System.out.println("\n Case Unsolved!");
        }
      }
      }  
            
                /*if(ans == false && p.getType().equals("Beginner"))
                {
                  System.out.print("\n\nUnfortunately that was wrong");//give beginner an extra try here
                  unlockedClues =false;
                   while(unlockedClues == false && scoring.hasClueLeft(p.getType())){
                      System.out.println("\nYou must win the mini Game to unlock a clue!");
                miniGames(storyRand,m1);
                     
                  if(miniGames(storyRand,m1)){
                    scoring.addMiniGameWin();//Add 5 points
                    scoring.unlockClue();//Count one clue unlocked
                    System.out.println("\nMiniGame Won");
                    System.out.println("Current Score: "+ scoring.getScore());
                    System.out.println("Profile Type: "+p.getType());//test line to check difficulty
                    clues.displayClue(storyRand);//SHow story 1 clue
                      System.out.print("\nWho do you think is the culprit? ");//give beginner an extra try here
      userCulprit = input.next();
              s.reAns(userCulprit);
               ans = s.setAns(); //check if the final answer is correct
                  }
      
          }
        }*/
               
          }
          
              //check if the user got their answer right
            /*  if(ans == true){ //if user gets it right
                System.out.println("\nGood job, Detective! Alesha did infact have her chromebook but it was deep in the abyss of her bag"); } 
              else{//if user doesnt get it right
                System.out.println("\nUnfortunately you didn't win, start a new game!");
                }*/
            
        count++;//ensure the questions methods loop until the last question
      
      }while(count !=4); 
      
      System.out.println("________________________________________________________________________________________________________________________________________________________________"); 
    System.out.println("Thank you for playing " + s.TITLE + "!");//end message for story 1
        
  
        
          
        }
        
        else if(storyRand ==2){// rida
        //Create story2 object
        Story2 story = new Story2();
        boolean won;
        String answer, suspectName;
        boolean solved;
        //dispaly the story Information
        story.displayStory();
        try{
          Thread.sleep(2000);
        }catch(InterruptedException e){System.out.println("PAUSING ERROR");}
        //Key Information for user to know before solving the case
        System.out.println("______________________________________________________________");
        System.out.println("\t\tKEY INFORMATION TO SOLVE THE CASE");
        System.out.println("______________________________________________________________");
        System.out.println("\n[--------------------------------]");
        story.displaySuspects();
        System.out.println("\n[--------------------------------]");
        story.displayLocations();
        System.out.println("\n[--------------------------------]");
        story.displayMethods();
        //Allows the player to choose a suspect pov
        System.out.print("\nWould you like to read a suspect's POV before Solving the case(Yes/No): ");
        answer = input.next();
        //WHile loop for invalid inputs(if it's not yes or no)
        while(!answer.equalsIgnoreCase("yes")&& !answer.equalsIgnoreCase("no")){
          System.out.print("Invalid Input: Enter Again Here(Yes/No): ");
          answer = input.next();
        }
        
        if(answer.equalsIgnoreCase("yes")){
          System.out.print("\nWhose POV would you like to read\n1. Mia\n2. Alex\n3. Jordan\nEnter the suspectName: ");
          suspectName = input.next();
          story.displayPOV(suspectName);//GIving the suspect's name to the method to see, what's the pov of suspect
        }else{
          System.out.println("\nNo POV SELECTED!");//If user say no for suspect
        }
        
      System.out.println("\n\tSOLVE THE CASE!!!"); 
        //First try to solve the case
      System.out.print("Who is the Culprit: ");
      String suspect = input.next();

      System.out.print("Where did it Happen: ");
      String location = input.next();

      System.out.print("How was it done?: ");
      String method = input.next();
      //Checks if User Solved the case
      if(story.solveCase(suspect,location,method)){
        story.displayCaseSolved();
      }else{
        story.displayCaseFailed();
        solved = false;
        while(solved == false && scoring.hasClueLeft(p.getType())){
        System.out.println("\nYou must win the mini Game to unlock a clue!");
    if(miniGames(storyRand,m1)){
      scoring.addMiniGameWin();//Add 5 points
      scoring.unlockClue();//Count one clue unlocked
      System.out.println("\nMiniGame Won");
      System.out.println("Current Score: "+ scoring.getScore());
      System.out.println("Profile Type: "+p.getType());//test line to check difficulty
      clues.displayClue(storyRand);//SHow story 2 clue
        System.out.println("\n\tTry Solving Again!");
        System.out.print("\nWho is the Culprit: ");
      suspect = input.next();

      System.out.print("Where did it Happen: ");
      location = input.next();

      System.out.print("How was it done?: ");
      method = input.next();
        //Check final answer again
        if(story.solveCase(suspect,location,method)){
          story.displayCaseSolved();
          solved = true;
        }else{
          System.out.println("\nStill Incorrect.");
        }
          }
        }
        if(solved == false){
          System.out.println("\n Case Unsolved!");
        }
      }
      }  


      else if(storyRand==3){// alesha 
        //ALESHA - STORY 3
        
      boolean solve =false;
        
      System.out.println("\t\t\tWELCOME!!\n");
      //add diff levels verisons of story 

             /* String difficulty = "";
                if(p.getType().equalsIgnoreCase("Beginner")){
                  difficulty ="Easy";
                }
                else if (p.getType().equalsIgnoreCase("Intermediate")){
                  difficulty ="Medium";
                }
                else{
                  difficulty = "Hard";
                }
                System.out.println("Detective type: " + p.getType());
                System.out.println("Story difficulty " + difficulty);
        
           ////////////////////////MINIGAME CLASS
              Riddles m1 = new Riddles(difficulty,scoring);*/
                // while(choice<1 || choice>3){
             // System.out.println("Choose a difficulty level for mini game(#1-3): \n1.Easy\n2.Medium\n3.Hard");
              //choice = input.nextInt();

      ////////////////////////STORY CLASS added a parameter to access diffuclty level
      Story3 case3 = new Story3();
      ////////////////////////CLUES CLASS
      Clues c1 = new Clues(p);

      boolean escape = false;//mini game
      case3.displayStory();
      case3.display(difficulty); //less repetition 
           
      while (!solve && m1.getStarsRemaining() > 0) {
        
        //ASK WHO THE SUSPECT IS
        System.out.print("\nWho do you think is the possible culprit ?\n1.Security guard\n2.Designer\n3. Staff Event Organizer\n\nEnter #1-3: ");
        int suspectName = input.nextInt(); 

        
          if(suspectName==2){//could have made the code better by using another varibale and seting it to getculprit and thenc checking if guess was correct but to many errors 
          System.out.println("\n--------------------CASE SOLVED!!-----------------\nThe designer took the crown for a private photoshoot and had planned on returning it before the exhibition started.");
          solve = true;//when solved to avaoid loop
        }
            

            
        else{////wrong suspect start a=by asking tif they want clues
          System.out.print("\nWrong suspect!");
          escape = false; //restart 

           //ASK IF USER WANTS A CLUE
        System.out.print(" Do you want a clue? (Yes/No): ");
        String clueOption = input.next();
        input.nextLine();

          
        if(clueOption.equalsIgnoreCase("Yes")){
          boolean won = miniGames(storyRand,m1); // method 
          //keep playing min gmae till get ans 

          System.out.println("Final score: " + scoring.getScore());

          
      }
          
        //show after ans then diplay stars  UPDATE 
        System.out.print("\n\nSTAR UPDATE NOW--->");
        m1.starDisplay(); //display remianing stars
        }

        //no clue 
        /*else{
          System.out.print("No clues used\n\n\n");
        }*/
    //}//while
      }
      if(m1.getStarsRemaining()==0 && !solve){
        System.out.println("Game over! You ran out of stars.....The Case remains Unresolved");
      }

      //final points
      System.out.println("Final score: " + scoring.getScore());
}


}//end

    
    
  }while(choice!=3); 

    //after user exits
  System.out.println("Thank you for playing!"); 
}//end main




//minigames method
public static boolean miniGames(int storyRand, Riddles m1){//boolean return that goes toward score class, if true, the score goes up by 5
  int choice = 0;
    Scanner input = new Scanner(System.in);
  System.out.println("\n\t---------- MINIGAMES FOR CLUES ----------\n1. Hangman\n2. Riddles\n3. Math\n4. Exit");
    //attributes and variables
  char a;
  HangMan h = new HangMan();
do{
  try
  {System.out.print("(#): ");
    choice = input.nextInt();}
  catch(InputMismatchException e){
    System.out.println("invalid input");
    input.next();
    choice = 5;
  }
  
}while(choice<1 || choice>4);

  ////////////hangman
  if(choice ==1){
     System.out.print("\n\t| HANGMAN |\n\nStart by guessing the first letter: ");
            a = input.next().charAt(0);
            h.setGuess(a); //minigame setter
            do{
            System.out.print("Guess another letter: ");
            a = input.next().charAt(0);
            h.setGuess(a);
              }while(h.gameEnd()==false && h.win()==false);//the minigame ends if the user runs out of wrong attempts OR wins the game

            ///change h.win() to score/clue class boolean then display clue
            if(h.win() == true){ //if user wins the game, display clue then last question again
             //call clue class
              return true;
            }
      }//end if for choice 1




    
    
  else if (choice ==2){
    //Riddle Game 
    boolean escape = false;
    while(!escape && m1.getStarsRemaining()>0){
            
            // Display stars before game
            System.out.print("\nCurrent Stars: ");
            m1.starDisplay();

            // Set mini game choice only option rn
            m1.setMiniChoice("Riddle");
            System.out.println("\nMINI GAME: Solve this riddle to unlock your clue!");
            System.out.println("RIDDLE: " + m1.getCurrentQ());

            // User enters riddle  answer
            System.out.print("Your answer: ");
            String userAns = input.next();//use nextline 

            //checl ans
            escape = m1.checkAns(userAns); //call to method from mingme class
           return escape;
            
          }//while
    return false;




    
    
  }

    
  else if (choice == 3){//MathMini Game
    int ans;
    MathMini math = new MathMini();
    //Get the question from MathMini class
    //Recieve answer from user and checks it back from the MathMini Class
    for(int i = 0; i<3; i++){
      System.out.println(math.getQuestions(i) +" ");
      ans = input.nextInt();
      math.checkAnswer(ans,i);
    }
    System.out.println("Correct answers: "+ math.getCorrectCount() + "/3");
    return math.hasWon();
  }  
  else{  //Invalid choice
    System.out.println("Invalid Mini Game Choice!");
  }
  
return false;
  
}//end minigame method
  
/*public static boolean unlockNextClue(Riddles m1, int storyRand){
  Scoring scoring = new Scoring();
   Profile p = new Profile(); 
  Clues clue = new Clues(p);
  boolean won = miniGames(storyRand,m1);
  if(won == true){
    scoring.addMiniGameWin();
     System.out.println("\n\t----You won the MiniGame!----");
            System.out.println("\nScore: "+ scoring.getScore());
            //Checks if the score is enough to unlock clue
            if(scoring.canUnlockClue(p.getType())){
              scoring.unlockClue();
              System.out.println("\n---You Unlocked a clue---");
              return true;
            }
  }else{
              System.out.println("\n\t-----You lost the mini Game. No points Added!----");
  }
    return false;
  }//playMiniGameAndCheckClue Method ends here*/
  
  
}//end class