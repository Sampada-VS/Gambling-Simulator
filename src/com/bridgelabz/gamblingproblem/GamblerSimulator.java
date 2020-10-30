package com.bridgelabz.gamblingproblem;

public class GamblerSimulator {
	public static final int STAKE=100;
	public static final int BET=1;
	public static int stake=STAKE;
	
	public static void winOrLose() {
		int winLose=(int)((Math.random()*10)%2);
		if (winLose == 1) {
			System.out.println("Gambler won bet.");
			stake=stake+1;
		}
		else {
			System.out.println("Gambler lost bet.");
			stake=stake-1;	
		}
		System.out.println("Stake :"+stake);
	}
	public static void main(String[] args) {
		winOrLose();
	}
}
