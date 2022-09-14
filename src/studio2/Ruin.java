package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		
	int startAmount;
	double winChance;
	int winLimit;
	int totalSimulation;
	int roundCount = 0;
	int days = 1;
	int numLosses =0;
	int numWins =0;
	double ruinRate = 0; 
	
	System.out.println("What is your starting amount? ");
	startAmount = in.nextInt();
	System.out.println("What is your probability of a win? ");
	winChance = in.nextDouble();
	System.out.println("How much money until you have had a successful day? ");
	winLimit = in.nextInt();
	System.out.println("How many days do you want to simulate? ");
	totalSimulation = in.nextInt();
	
	int dailyAmount = startAmount;
	
	// Calculating Ruin Rate 
	
	double a = 0;
	a = (1 - winChance) / winChance;
	
	if (winChance == .50)
	{
		ruinRate = 1 - (startAmount / winLimit);
	}
	else
	{
		ruinRate = ((Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a,  winLimit)));
	}
	
	while (days <= totalSimulation)
	{
		while (startAmount < winLimit && startAmount > 0)
		{
			double random = Math.random();
			roundCount++;
			boolean win = winChance>=random;
			if (win)
			{
				startAmount++;
			}
			else
			{
				startAmount--;
			}
		}	
		if (startAmount == winLimit)
		{
			System.out.println("Simulation " + days + ": " + roundCount  + " WIN");
			numWins ++;		
		}
		else if (startAmount == 0)
		{
			System.out.println("Simulation " + days + ": " + roundCount + " LOSE");	
			numLosses ++;
		}
		days ++;
		roundCount = 0;
		startAmount = dailyAmount;
	}
	
	System.out.println("Losses: " + numLosses + " Wins: " + numWins + " Simulations: " + totalSimulation);
	System.out.println("Ruin rate from simulation" + (double)(numLosses / numWins) + " Expected ruin rate: " + ruinRate);
	

	}
	

}
