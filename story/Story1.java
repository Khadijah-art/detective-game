/*
Khadijah U.
  Story1 class prints a story with its questions and story text file
  */
package story;
import profile.*;
import java.util.*;//import array class
import java.io.*;


public class Story1{
  Scanner input = new Scanner(System.in);
  //attributes
  private String choice;
  private int[] numChoice = new int[2];
  private boolean close = false;
  private int i, num;
  private Profile p;//user gets different choices based on their detective profile
  private static String line;//file reader
  private static final String LOCATION ="School";
  private static final String CULPRIT ="alesha";
  public static final String TITLE = "CASE NO.1 - Where did the chromebook go???";
  private static String[] suspects = {"alesha", "student1", "janitor", "teacher", "student2", "tungtungsahur"};
  private String[] userSus = new String [3];//user input of 3 people they suspect
  private static final String EVIDENCE = "totally spies sticker from the chromebook fell off and found under Aleshas shoe";
  private static int count=0; //this displays the questions, every question is displayed once
  private String[] answer = new String[3];
  private String userCulprit;
  //constructors
  public Story1(){
    p = new Profile();
    choice = p.getType();
    i=0;
  }
  
  public Story1(Profile p1){//constructor with pre-existing profile
    if(!p1.equals(null)){
    p = p1;
      choice = p.getType();
    }
    else{
      p = new Profile();
      choice = p.getType();
    }
    i=0;
  }
  //getter
  public Profile getProfile(){
    return p;
  }

  public static String getEvidence(){
    return EVIDENCE;
  }
  
  //setter
  public void setProfile(Profile p1){
    if(!p1.equals(null)){//make sure it isnt null
    p = p1;
      choice = p.getType();
    }
    else{//otherwise throw exception
      throw new IllegalArgumentException("Invalid profile");
    }
  }

  
  public void setAnswer(){///assign additional information answers based on the stories characters
    for(int i = 0;i<userSus.length;i++){
      answer [i] = "nothing"; //default value to nothing, if user chooses a side character
      for(int j = 0;j<suspects.length;j++){
          if(userSus[i].equalsIgnoreCase(suspects[j])){
              if(suspects[j].equalsIgnoreCase("teacher")){
                answer[i] = "I remember her submitting an assignment from home yesterday, but didnt see her work on her chromebook today";
              }
              else if(suspects[j].equalsIgnoreCase("student1") || suspects[j].equals("student2") ){
                answer[i] = "I haven't seen her user her chromebook today";
              }
              else if(suspects[j].equalsIgnoreCase("janitor")){
                answer[i] = "The chromebook I saw earlier had some 67 stickers on it";
              }
              else if(suspects[j].equalsIgnoreCase("alesha")){
                answer[i] = "I was using it last night but didnt take it out of my bag all day today";
              }
              else if(suspects[j].equalsIgnoreCase("tungtungsahur")){//extra character just for jokes
                answer[i] = "tung tung tung tung tung sahur🪵 6767676767";
              }
          }
         
      }
  }
  }

    ////////////////ADVANCED DETECTIVES QUESTIONS
 public void questionsHard(){
    if(count == 0){
      System.out.println("Characters:\n1. Alesha\n2. Teacher\n3. Janitor\n4. Student1\n5. Student2\n6. Librarian\n7. Secretary\n8. tungtungsahur\n\nWhich 3 people do u suspect(only 1 chance to get the right suspect list, think wisely):");
        for(int i=0;i<3;i++){
          do{
        System.out.print((i+1) + ": ");

        userSus[i] = input.next();
          }while(! (userSus[i].equalsIgnoreCase("Janitor") || userSus[i].equalsIgnoreCase("teacher") || userSus[i].equalsIgnoreCase("student1") || userSus[i].equalsIgnoreCase("alesha") || userSus[i].equalsIgnoreCase("student2") || userSus[i].equalsIgnoreCase("secretary") || userSus[i].equalsIgnoreCase("librarian") || userSus[i].equalsIgnoreCase("tungtungsahur")));
        }
    }
    else if(count == 1){
          setAnswer();
      
       System.out.println("\nYou may ask a suspect for more details");
      num=1;
      for(String s: userSus){
        System.out.println(num +". " + s);
        num++;
      }
      //reset num so we can use it for another thing
      
      do{
      System.out.print("\nwho would you like to ask(#): ");
      try{
        numChoice[i] = input.nextInt();
        num = numChoice[i];
      }
      catch(InputMismatchException e){
        System.out.println("Invalid input");
        input.next();//flush
        num = 5;
      }
      }while((num>3 || num <1));
      System.out.println(userSus[num-1] +" has said: " + answer[num-1]);
      
      }
    
    else if(count == 2){
      System.out.print("\nWho do you think is the culprit? ");
      userCulprit = input.next();
        }
      
    else if (count ==3){
      System.out.println("...none of this is real...Big Brother is watching...Maybe I am too...heh...");
    }
    count++;
  }

  ////////////INTERMEDIATE DETECTIVES QUESTIONS
   public void questionsMedium(){
    if(count == 0){
      do{
     System.out.println("Characters:\n1. Alesha\n2. Teacher\n3. Janitor\n4. Student1\n5. Student2\n6. Librarian\n7. Secretary\n8. tungtungsahur\n\nWhich 3 people do u suspect:");
        for(int i=0;i<3;i++){
          do{
        System.out.print((i+1) + ": ");
        
        userSus[i] = input.next();
          }while(! (userSus[i].equalsIgnoreCase("Janitor") || userSus[i].equalsIgnoreCase("teacher") || userSus[i].equalsIgnoreCase("student1") || userSus[i].equalsIgnoreCase("alesha") || userSus[i].equalsIgnoreCase("student2") || userSus[i].equalsIgnoreCase("secretary") || userSus[i].equalsIgnoreCase("librarian") || userSus[i].equalsIgnoreCase("tungtungsahur")));
          
           if (userSus[i].equalsIgnoreCase(CULPRIT)){
          close = true;
        }
        }
     
        if(close!=true){
          System.out.println("Hint: You're not so close, try a different suspect list..");
        }
      }while(close!=true);
    }
    else if(count == 1){
     setAnswer();
      
       System.out.println("\nYou may ask 2 of the suspects for more details");
      num=1;
      for(String s: userSus){
        System.out.println(num +". " + s);
        num++;
      }
      //reset num so we can use it for another thing
      
        for(int i =0;i<2;i++){
      do{
      System.out.print("\nwho would you like to ask(#): ");
      try{
        numChoice[i] = input.nextInt();
        num = numChoice[i];
      }
      catch(InputMismatchException e){
        System.out.println("Invalid input");
        input.next();//flush
        num = 5;
      }
      }while((num>3 || num <1) || numChoice[0] == numChoice[1]);
      System.out.println(userSus[num-1] +" has said: " + answer[num-1]);
      }
    }
    else if(count == 2){
       System.out.print("\n\nWho do you think is the culprit? ");
      userCulprit = input.next();
    }
     count++;
     
  }

  public void reAns(String ans){
    userCulprit = ans;
  }
  
  public boolean setAns(){
    if(userCulprit.equalsIgnoreCase(CULPRIT)){
        return true;
      }
    else 
      return false;
  }


  ///////////BEGINNER DETECTIVES QUESTIONS
   public void questionsEasy(){
    if(count == 0){
     do{
     System.out.println("Characters:\n1. Alesha\n2. Teacher\n3. Janitor\n4. Student1\n5. Student2\n6. Librarian\n7. Secretary\n8. tungtungsahur\n\nWhich 3 people do u suspect:");
        for(int i=0;i<3;i++){
          do{
        System.out.print((i+1) + ": ");
      
        userSus[i] = input.next();
          }while(! (userSus[i].equalsIgnoreCase("Janitor") || userSus[i].equalsIgnoreCase("teacher")|| userSus[i].equalsIgnoreCase("student1") || userSus[i].equalsIgnoreCase("alesha") || userSus[i].equalsIgnoreCase("student2") || userSus[i].equalsIgnoreCase("secretary") || userSus[i].equalsIgnoreCase("librarian") || userSus[i].equalsIgnoreCase("tungtungsahur"))); //convert to a number list if theres time
           if (userSus[i].equalsIgnoreCase(CULPRIT)){
          close = true;
            }
        }
        if(close!=true){
          System.out.println("Hint: You're not so close, try a different suspect list..");
        }
      }while(close!=true);
    }
    else if(count == 1){
      setAnswer();
      
       System.out.println("\nYou may ask 2 of the suspects for more details");
      num=1;
      for(String s: userSus){
        System.out.println(num +". " + s);
        num++;
      }
      //reset num so we can use it for another thing
      
        for(int i =0;i<2;i++){
      do{
      System.out.print("\nwho would you like to ask(#): ");
      try{
        numChoice[i] = input.nextInt();
        num = numChoice[i];
      }
      catch(InputMismatchException e){
        System.out.println("Invalid input");
        input.next();//flush
        num = 5;
      }
      }while((num>3 || num <1) || numChoice[0] == numChoice[1]);
      System.out.println(userSus[num-1] +" has said: " + answer[num-1]);
      }
    }
    else if(count == 2){
      System.out.print("\n\nWho do you think is the culprit? ");
      userCulprit = input.next();
    }
     count++;
     
  }

  //display the story
  public static void storyDisplay(){
     try{ 
      FileReader fr = new FileReader("s1.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line!=null){
        System.out.println(line);
       /*try
        {
          Thread.sleep(3500);
        }//add a pause between each line
        catch(InterruptedException e){
          System.out.println("System failed to pause");
        }*/
        line = br.readLine();
      }
     }
      catch(IOException e){
        System.out.println("Error reading file");
      }
  }

  ////story information
  public static String info(){ return ("\t\t"+TITLE + "\n\nEvidence:" + EVIDENCE + "\nLocation: " + LOCATION);}//print story
  
  
  

}