package com.bridgelabz.gamblingproblem;

import java.util.HashMap;
import java.util.Map.Entry;

public class GamblerSimulator {
	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_HALF = 0.5f;

	public static int stake,totalAmount;
	static HashMap<Integer, Integer> wonDays = new HashMap<>();
	static HashMap<Integer, Integer> loseDays = new HashMap<>();

	public static void winOrLose() {
		int winLose = (int) ((Math.random() * 10) % 2);
		if (winLose == 1) {
			stake = stake + BET;
		} else {
			stake = stake - BET;
		}
	}

	public static int resignGame(int day) {
		stake=STAKE;
		int losingAmount = (int) Math.round(STAKE * STAKE_HALF);
		int winningAmount = (int) Math.round(STAKE + (STAKE * STAKE_HALF));
		boolean flag = true;
		while (flag) {
			winOrLose();
			if (stake == losingAmount) {
				loseDays.put(day, stake);
				System.out.println("On Day :"+day+ " == Final Amount : " + loseDays.get(day));
				flag = false;
			}
			if (stake == winningAmount) {
				wonDays.put(day, stake);
				System.out.println("On Day :"+day+ " == Final Amount : " + wonDays.get(day));
				flag = false;
			}
		}
		return stake;
	}

	public static void totalAmountForMonth() {
		int totalDays=20;
		int day=1;
		int amountPerDay=0;
		while (day<=totalDays) {
			amountPerDay=resignGame(day);
			totalAmount=totalAmount+amountPerDay;
			day++;
		}
		System.out.println("Total amount gambler get is : "+totalAmount );
	}
	public static void main(String[] args) {
		totalAmountForMonth();
		System.out.println("Gambler won on "+wonDays.size()+" days in month. ");
		System.out.println("Gambler lost on "+loseDays.size()+" days in month. ");

	}
}
