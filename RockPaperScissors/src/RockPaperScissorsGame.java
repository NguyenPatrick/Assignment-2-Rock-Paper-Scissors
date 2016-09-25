/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: September 16 2016
* This program is a dice game
*
****************************************************************************/
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
// score variables
static int playerScore = 0;
static int cpuScore = 0;
	  
	  
 // procedure to decide the result of the rock, paper, scissors game
 public static void PlayGame (String cpuGuess, String playerGuess)
 {
	  System.out.println("Cpu Attack: " + cpuGuess + ", Player Attack: " + playerGuess);
	  
	  if ((cpuGuess.equals("R") && playerGuess.equals("S")) || (cpuGuess.equals("S") && playerGuess.equals("P")) || cpuGuess.equals("P") && playerGuess.equals("R") )
	  {
		  cpuScore = cpuScore + 1;
		  System.out.println("Player Loses! Cpu Wins!");
	  }
	  else if ((cpuGuess.equals("S") && playerGuess.equals("R")) || (cpuGuess.equals("P") && playerGuess.equals("S")) || cpuGuess.equals("R") && playerGuess.equals("P") )
	  {
		  playerScore = playerScore + 1;
		  System.out.println("Player Wins! Cpu Loses!");
	  }
	  else if ((cpuGuess.equals("R") && playerGuess.equals("R")) || (cpuGuess.equals("S") && playerGuess.equals("S")) || cpuGuess.equals("P") && playerGuess.equals("P") )
	  {
		  System.out.println("It's A Tie!");
	  }
	  
      System.out.println("Cpu Score: " + cpuScore + ", Player Score: " + playerScore);  
 }
	 
	 
 public static void main(String[] args)
 {
  // imported components
  Scanner scan = new Scanner(System.in);
  Random generator = new Random();

  // game usage
  int cpuFinalPlay;  
  String firstPlayerGuess = "";
  String firstCpuGuess = "";
  String terminateGame = "";
  
  // booleans for  loops
  Boolean continueGame = true;
  Boolean failedInput = false;
  
  // loops the program until commanded to stop
  while (continueGame.equals(true))
  {
      // makes sure user input is valid
	  while(failedInput.equals(false))
	  {	  
        System.out.println("Rock Paper Scissors Game! Rock > Scissors, Scissors > Paper, Paper > Rock");
        System.out.println("Type 'R' for Rock, Type 'P' for Paper, Type 'S' for Scissors");
        firstPlayerGuess = scan.nextLine();
  
        // user can only choose from three choices (R, S or P)
        if (firstPlayerGuess.equals("R") || firstPlayerGuess.equals("S") || firstPlayerGuess.equals("P")) 
        {
	    failedInput = true;
        }
        else
        {
	    System.out.println("INVALID INPUT! TRY AGAIN!");
	     System.out.println("");
        }
  }

  // randomize cpu value
  cpuFinalPlay = generator.nextInt(3) + 1; 
  
  // convert's cpu's decision into a string
  if (cpuFinalPlay == 1) 
  {
	  firstCpuGuess = "R"; 
  }
   else if (cpuFinalPlay == 2) 
   {
	   firstCpuGuess = "P"; 
   }
   else if (cpuFinalPlay == 3) 
   {
	   firstCpuGuess = "S"; 
   }
		  
  // go to procedure
  PlayGame(firstCpuGuess, firstPlayerGuess);

  // to continue or end the game
  System.out.println("Type 'END' to end the game, else type anything else to continue.");
  terminateGame = scan.nextLine();
  System.out.println("");
  
  if(terminateGame.equals("END"))
  {
	  continueGame = false;
  }
  failedInput = false;
 }
 }
}


 
  
  


