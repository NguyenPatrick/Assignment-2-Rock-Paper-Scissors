/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: October 2016
* This program generates game(s) of rock, paper, scissors with the cpu
*
****************************************************************************/

#include "stdafx.h"
#include <iostream>
#include <string>
#include <ctime>

using namespace std;

// global score variables
static int playerScore = 0;
static int cpuScore = 0;

// procedure to decide the result of the rock, paper, scissors game
void PlayGame(string cpuGuess, string playerGuess)
{
	// shows what both players chose
	cout << "Cpu Attack: " + cpuGuess + ", Player Attack: " + playerGuess << endl;
	// endl, ends the current line and jumps to the next

	// game results
	if (cpuGuess == playerGuess)
	{
		cout << "It's A Tie!" << endl;
	}
	else if (((cpuGuess == "S") && (playerGuess == "R")) 
		|| ((cpuGuess == "P") && (playerGuess == "S")) 
		||((cpuGuess == "R") && (playerGuess == "P")))
	{
		playerScore = playerScore + 1;
		cout << "Player Wins! Cpu Loses!" << endl;
	}
	else 
	{
		cpuScore = cpuScore + 1;
		cout << "Player Loses! Cpu Wins!" << endl;
	}
	cout << "Cpu Score: " << cpuScore << " Player Score: " << playerScore << endl;
}

// starting point
int main()
{
	// variables for game usage
	int cpuFinalPlay;
	string firstPlayerGuess;
	string firstCpuGuess;
	string terminateGame;

	// booleans for loops
	bool continueGame = true;
	bool failedInput = false;

	// loops the program until commanded to stop
	while (continueGame == true)
	{
		// makes sure user input is valid
		while (failedInput == false)
		{
			cout << "Rock Paper Scissors Game! Rock > Scissors, Scissors > Paper, Paper > Rock" << endl;
			cout << "Type 'R' for Rock, Type 'P' for Paper, Type 'S' for Scissors" << endl;
			cin >> firstPlayerGuess;

			// user can only choose from three choices (R, S or P)
			if ((firstPlayerGuess == "R") || (firstPlayerGuess == "S") || (firstPlayerGuess == "P"))
			{
				failedInput = true;
			}
			else
			{
				cout << "INVALID INPUT! TRY AGAIN!" << endl;
			}
		}

		// randomize cpu value
		// ensures there is no repeatition in random sequence
		// code retrieved from http://stackoverflow.com/questions/13445688/how-to-generate-a-random-number-in-c
		srand((unsigned)(time(0)));
	        cpuFinalPlay = (rand() % 3) + 1;

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
		cout << "Type 'END' to end the game, else type anything to continue." << endl;;
		cin >> terminateGame;

		if (terminateGame == "END")
		{
			continueGame = false;
		}
		failedInput = false;
	}
	return 0;	
}

