package com.bridgelabz.gamblingproblem;

import java.util.HashMap;
import java.util.Map.Entry;

public class GamblerSimulator {
	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_HALF = 0.5f;

	public static int stake = STAKE;
	static HashMap<Integer, Integer> wonDays = new HashMap<>();
	static HashMap<Integer, Integer> loseDays = new HashMap<>();

	public static void winOrLose() {
		int winLose = (int) ((Math.random() * 10) % 2);
		if (winLose == 1) {
			System.out.println("Gambler won bet.");
			stake = stake + BET;
		} else {
			System.out.println("Gambler lost bet.");
			stake = stake - BET;
		}
		System.out.println("Stake :" + stake);
	}

	public static int resignGame(int day) {
		int losingAmount = (int) Math.round(STAKE * STAKE_HALF);
		int winningAmount = (int) Math.round(STAKE + (STAKE * STAKE_HALF));
		boolean flag = true;
		while (flag) {
			winOrLose();
			if (stake == losingAmount) {
				loseDays.put(day, stake);
				flag = false;
			}
			if (stake == winningAmount) {
				wonDays.put(day, stake);
				flag = false;
			}
		}
		for (Entry<Integer, Integer> m : wonDays.entrySet()) {
			System.out.println("Won on Day :"+m.getKey() + " == Final Amount : " + m.getValue());
		}
		for (Entry<Integer, Integer> m1 : loseDays.entrySet()) {
			System.out.println("Lost on Day :"+m1.getKey() + " == Final Amount : " + m1.getValue());
		}
		return stake;

	}

	public static void main(String[] args) {
		resignGame(1);
	}
}
