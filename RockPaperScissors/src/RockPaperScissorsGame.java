/*
* Created by: Patrick Nguyen
* Created on: September 16 2016
* This program is a dice game
*/

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

	
 public static void main(String[] args)
 {
  Scanner scan = new Scanner(System.in);
  Random generator = new Random();
  
  // variables
  int cpuGuess; 
  String playerGuess = "Test";

  String cpuFinalPlay = "test";
  int playerScore = 0;
  int cpuScore = 0;
  String terminateGame;
  Boolean continueGame = true;
  Boolean failedInput = false;
  
  
  while (continueGame.equals(true))
  {
	  while(failedInput.equals(false)){
		  
  System.out.println("Rock Paper Scissors Game! Rock > Scissors, Scissors > Paper, Paper > Rock");
  System.out.println("Type 'R' for Rock, Type 'P' for Paper, Type 'S' for Scissors");
  playerGuess = scan.nextLine();
  
  if (playerGuess.equals("R") || playerGuess.equals("S") || playerGuess.equals("P")) 
  {
	  failedInput = true;
  }
  else
  {
	  System.out.println("INVALID INPUT! TRY AGAIN!");
	  System.out.println("");
  }
}
   
  
  cpuGuess = generator.nextInt(3) + 1; 
  
  // cpu's rock paper scissors decision
  if (cpuGuess == 1) 
  {
	  cpuFinalPlay = "R"; 
  }
   else if (cpuGuess == 2) 
   {
	   cpuFinalPlay = "P"; 
   }
   else if (cpuGuess == 3) 
   {
	   cpuFinalPlay = "S"; 
   }
		  
		  
  System.out.println("Cpu Attack: " + cpuFinalPlay + ", Player Attack: " + playerGuess);
  
  if ((cpuFinalPlay.equals("R") && playerGuess.equals("S")) || (cpuFinalPlay.equals("S") && playerGuess.equals("P")) || cpuFinalPlay.equals("P") && playerGuess.equals("R") )
  {
	  cpuScore = cpuScore + 1;
	  System.out.println("Player Loses! Cpu Wins!");
  }
  else if ((cpuFinalPlay.equals("S") && playerGuess.equals("R")) || (cpuFinalPlay.equals("P") && playerGuess.equals("S")) || cpuFinalPlay.equals("R") && playerGuess.equals("P") )
  {
	  playerScore = playerScore + 1;
	  System.out.println("Player Wins! Cpu Loses!");
  }
  else if ((cpuFinalPlay.equals("R") && playerGuess.equals("R")) || (cpuFinalPlay.equals("S") && playerGuess.equals("S")) || cpuFinalPlay.equals("P") && playerGuess.equals("P") )
  {
	  System.out.println("It's A Tie!");
  }
  
  
  System.out.println("Cpu Score: " + cpuScore + ", Player Score: " + playerScore);  
  System.out.println("Type 'END' to end the game, else type anything to continue.");
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


 
  
  


