package profile;
/*
Khadijah U.
  Profile class to give user a specific detective type through a mini quiz at the start of the game, this type determines the difficulty level of the users story options
  */


  import java.util.*;
import java.io.*;

public class Profile{

Scanner input = new Scanner(System.in);
  //attributes
  private int score;
  private String type;//the users profile
  private static String[] types = {"Advanced", "Intermediate", "Beginner"};//possible profiles
  private int ans;

  //constructor
  public Profile(){
    score = 0;
    type = types[2];
  }

  public Profile(int s){//assign type based on score
   score = s;
     if(score>=3){
      type = types[0];
    }
    else if(score==2){
      type = types[1];
    }
    else{
      type = types[2];
    }
  }
  
  //getter
  public static String[] getTypes(){
      return types;
  }

  public String getType(){
    return type;//return users type
  }

  public int getScore(){
    return score;
  }
  

public void test(){//the actual test

  //////question 1
  System.out.println("Question 1: 67 was suspected to have murdered 9 at around 7:56pm. Who is telling the truth:\n1. 789 claims to have seen 67 leave at 7pm\n2. 93 claims to have seen 67 and 9 hanging out until the time of murder\n3. 67 claims to not have been with 9 all day\n4. 567 claims to have been with 67 and 9 until 7:30");
  do{
  try{
    System.out.print("(#): ");
  ans = input.nextInt();
  }
  catch(InputMismatchException e){
    System.out.println("Incorrect input");
    input.next();
    ans = 5;
  }
}while(ans>4 || ans<1);
  if(ans == 3){
    score++;
  }

  //////question 2
  System.out.println("\nQuestion 2: A book was stolen around 1:45 by a person wearing a black jacket on cctv. That day about 3 people (person 1, person 2 and person 3) were seen wearing a black jacket in the library\n1. Person 1 - claims to have left at 1:30\n2. Person 2 - Claims to witness person 3 stealing it\n3. Librarian - Claims they were in the main office for just 5 minutes\n4. Person 3 - Claims to not be wearing a black jacket");
   do{
  try{
    System.out.print("(#): ");
  ans = input.nextInt();
  }
  catch(InputMismatchException e){
    System.out.println("Incorrect input");
    input.next();
    ans = 5;
  }
}while(ans>4 || ans<1);
    if(ans == 4){
    score++;
  }

  //////question 3
  System.out.println("\nQuestion 3: cctv footage showed tung wearing a bright purple hoodie, but people around him claim otherwise. Who is telling the truth\n1. Person A - claims to see tung wearing a red hoodie\n2. Person B - claims to see tung wearing a blue hoodie\n3. Person C - claims to have seen tung wearing a yellow hoodie\n4. Neither");
   do{
  try{
    System.out.print("(#): ");
  ans = input.nextInt();
  }
  catch(InputMismatchException e){
    System.out.println("Incorrect input");
    input.next();
    ans = 5;
  }
}while(ans>4 || ans<1);
    if(ans == 4){
    score++;
  }

  ////question 4
  System.out.println("\nQuestion 4: What is big, has legs but doesnt move\n1. Table\n2. Mammals \n3. The mess on my table\n4. Me");
   do{
  try{
    System.out.print("(#): ");
  ans = input.nextInt();
  }
  catch(InputMismatchException e){
    System.out.println("Incorrect input");
    input.next();
    ans = 5;
  }
}while(ans>4 || ans<1);
    if(ans == 1){
    score++;
  }

  //assign type based on score
 if(score==4){
      type = types[0];
    }
    else if(score==3 || score ==2){
      type = types[1];
    }
    else{
      type = types[2];
    }
}



  
  public String toString(){//print the users status and score
    return ("\n\t|| Score: " + score+"/4 " + "You are a " + type + " detective! ||");
  }
  
}//end class