// RockPaperScissorsBonus.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

// score variables
static int playerScore = 0;
static int cpuScore = 0;

// procedure to decide the result of the rock, paper, scissors game
void PlayGame(string cpuGuess, string playerGuess)
{
	cout << "Cpu Attack: " + cpuGuess + ", Player Attack: " + playerGuess;
	cout << endl;

	if (cpuGuess == playerGuess)
	{
		cout << "It's A Tie!";
		cout << endl;
	}
	else if (((cpuGuess == "S") && (playerGuess == "R")) || ((cpuGuess == "P") && (playerGuess == "S")) ||((cpuGuess == "R") && (playerGuess == "P")))
	{
		playerScore = playerScore + 1;
		cout << "Player Wins! Cpu Loses!";
		cout << endl;
	}
	else 
	{
		cpuScore = cpuScore + 1;
		cout << "Player Loses! Cpu Wins!";
		cout << endl;
	}
	cout << "Cpu Score: " << cpuScore << " Player Score: " << playerScore;
	cout << endl;
}

int main()
{
	// game usage
	int cpuFinalPlay;
	string firstPlayerGuess;
	string firstCpuGuess;
	string terminateGame;

	// booleans for  loops
	bool continueGame = true;
	bool failedInput = false;

	// loops the program until commanded to stop
	while (continueGame == true)
	{
		// makes sure user input is valid
		while (failedInput == false)
		{
			cout << "Rock Paper Scissors Game! Rock > Scissors, Scissors > Paper, Paper > Rock";
			cout << endl;
			cout << "Type 'R' for Rock, Type 'P' for Paper, Type 'S' for Scissors";
			cout << endl;
			cin >> firstPlayerGuess;

			// user can only choose from three choices (R, S or P)
			if ((firstPlayerGuess == "R") || (firstPlayerGuess == "S") || (firstPlayerGuess == "P"))
			{
				failedInput = true;
			}
			else
			{
				cout << "INVALID INPUT! TRY AGAIN!";
				cout << endl;
			}
		}

		// randomize cpu value
		cpuFinalPlay = rand() % 3 + 1;

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
		cout << "Type 'END' to end the game, else type anything to continue.";
		cin >> terminateGame;
		cout << endl;

		if (terminateGame == "END")
		{
			continueGame = false;
		}
		failedInput = false;
	}

	return 0;	
}

