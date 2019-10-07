package com.skilldistillery.common;

import java.util.Scanner;

import com.skilldistillery.blackjack.BlackjackHand;
import com.skilldistillery.blackjack.Dealer;
import com.skilldistillery.blackjack.Player;

public class BlackJackApp {
	private Scanner kb = new Scanner(System.in);
	private Dealer dealer;
	private Player player;
	private BlackjackHand black;
	private boolean getOut = true;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		while (true) {
			app.run();
		}

	}

	private void run() {
		dealer = new Dealer();
		player = new Player();
		black = new BlackjackHand();

		System.out.println("New Hand.\n");
		getCardsToPLayers();

		do {

			String input = menu();
			switch (input) {

			case "hit":
			case "1":
				hitOrStay(input);
				break;

			case "stay":
			case "2":
				stay();
				System.out.println(dealer.getPlayerHand());
				System.out.println("Dealer hand value: " + dealer.getPlayerHandValue());
				determinateWinner();

				break;

			case "another hand":
			case "3":
				getOut = false;
				break;

			case "quit":
			case "4":
				System.out.println("Goodbye!");
				System.exit(0);
			}

		} while (getOut == true);
	}

	private void getCardsToPLayers() {
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.dealCard());
			dealer.getCard();
		}
		System.out.print("Dealer has: \n" + dealer.getSingleCard());
		System.out.println("\nPlayer Has:\n" + player.getPlayerHand());
		System.out.println("With a total value of: " + player.getPlayerHandValue() + "\n");
		hitOrStay(black.isBlackjackOrBust(player.getPlayerHandValue()));

	}

	private String menu() {
		System.out.println("What would you like to do?");
		System.out.println("1.Hit");
		System.out.println("2.Stay");
		System.out.println("3.Another Hand");
		System.out.println("4.Quit");
		return kb.nextLine().toLowerCase();
	}

	private void hitOrStay(String input) {
		if (input.equalsIgnoreCase("hit")) {
			String result = hit();
			if (result.equalsIgnoreCase("bust")) {
				System.out.println("Bust, you lose.\n");
			}

			else if (result.equalsIgnoreCase("blackjack")) {
				System.out.println("Blackjack, you win.\n");
			}

			else if (result.equalsIgnoreCase("safe")) {
				System.out.print("Dealer has: \n" + dealer.getSingleCard());
				System.out.println("\nPlayer Has:\n" + player.getPlayerHand());
				System.out.println("With a total value of: " + player.getPlayerHandValue() + "\n");
			}

		}

	}

	private void determinateWinner() {
		black.winOrLose(player.getPlayerHandValue(), dealer.getPlayerHandValue());
		getOut = false;
	}

	private String hit() {
		Card card = dealer.dealCard();
		player.addCard(card);
		System.out.println("\nYou drew " + card.toString());
		return black.isBlackjackOrBust(player.getPlayerHandValue());

	}

	private void stay() {
		System.out.println("The dealer has " + dealer.getSingleCard().toString() + "\n");
		dealer.hitOrStayDealer();

	}
}
