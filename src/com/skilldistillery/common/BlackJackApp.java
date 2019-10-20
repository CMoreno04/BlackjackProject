package com.skilldistillery.common;

import java.util.Scanner;

import com.skilldistillery.blackjack.BlackjackHand;
import com.skilldistillery.blackjack.Dealer;
import com.skilldistillery.blackjack.Player;

public class BlackJackApp {
	private Scanner kb = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private BlackjackHand black = new BlackjackHand();
	private boolean getOut = true;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		while (true) {
			app.run();
		}

	}

	private void run() {

		System.out.println("********** New Hand **********\n");
		getCardsToPLayers();

		do {
			System.out.println("Deck Size: " + dealer.getDeck().checkSize());
			switch (menu()) {

			case "hit":
			case "1":
				hitOrStay(hit());
				break;

			case "stay":
			case "2":
				stay();
				player.getHand().clearHand();
				dealer.getHand().clearHand();
				getOut = false;
				break;

			case "another hand":
			case "3":
				player.getHand().clearHand();
				dealer.getHand().clearHand();
				getOut = false;
				break;

			case "quit":
			case "4":
				System.out.println("Goodbye!");
				System.exit(0);
			}

			if (dealer.getDeck().checkSize() <= 5) {
				System.out.println("\nAll out of cards! Goodbye!");
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
		System.out.println("\nWhat would you like to do?");
		System.out.println("1.Hit");
		System.out.println("2.Stay");
		System.out.println("3.Another Hand");
		System.out.println("4.Quit");
		return kb.nextLine().toLowerCase();
	}

	private void hitOrStay(String input) {
		if (input.equalsIgnoreCase("bust")) {
			System.out.println("Bust, you lose.\n");
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			getOut = false;
		}

		else if (input.equalsIgnoreCase("blackjack")) {
			System.out.println("Blackjack, you win.\n");
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			getOut = false;
		}

		else {
			getOut = true;
		}
	}

	private void determinateWinner() {
		black.winOrLose(player.getPlayerHandValue(), dealer.getPlayerHandValue());
		player.getHand().clearHand();
		dealer.getHand().clearHand();
		getOut = false;
	}

	private String hit() {

		player.addCard(dealer.dealCard());

		System.out.println("\nYou drew " + player.getSingleCard().toString());
		System.out.println("Dealer has: \n" + dealer.getSingleCard());
		System.out.println("\nPlayer Has:\n" + player.getPlayerHand());
		System.out.println("With a total value of: " + player.getPlayerHandValue() + "\n");
		return black.isBlackjackOrBust(player.getPlayerHandValue());

	}

	private void stay() {
		dealer.hitOrStayDealer();
		System.out.println("Dealer hand: \n" + dealer.getPlayerHand());
		System.out.println("Dealer hand value: " + dealer.getPlayerHandValue());
		determinateWinner();
	}
}
