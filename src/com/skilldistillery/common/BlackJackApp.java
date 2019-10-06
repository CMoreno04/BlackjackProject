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
	private boolean gtfo = true;

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

		getCardsToPLayers();

		do {
			String input = menu();
			switch (input) {

			case "hit":
				String res= hitOrStand(input);
				break;

			case "stand":
				stand();
				break;

			case "another hand":
				System.out.println("NEW HAND!");
				gtfo = false;
				break;

			case "quit":
				System.out.println("Goodbye!");
				System.exit(0);
			}

		} while (gtfo == true);
	}

	private void getCardsToPLayers() {
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.dealCard());
			dealer.getCard();
		}
		System.out.println("Cards Dealt With.");
		System.out.println("Player Has:\n" + player.getPlayerHand());
		System.out.println(player.getPlayerHandValue());
	}

	private String menu() {
		System.out.println("What would you like to do?");
		System.out.println("Hit");
		System.out.println("Stand");
		System.out.println("Another Hand");
		System.out.println("Quit");
		return kb.nextLine().toLowerCase();
	}

	private void hitOrStand(String input) {
		if (input.equalsIgnoreCase("hit")) {
			String result = hit();
			if (result.equalsIgnoreCase("bust")) {
				System.out.println("Bust, you lose.");
				gtfo = false;
			}

			else if (result.equalsIgnoreCase("blackjack")) {
				System.out.println("Blackjack, you win.");
				gtfo = false;
			}

			else if (result.equalsIgnoreCase("safe")) {
				System.out.println("You are safe.");
				System.out.println("Your hand is currently:\n" + player.getPlayerHand());
				System.out.println("\nWith a total value of:\n" + player.getPlayerHandValue() + "\n");
			}

		}

	}

	private String hit() {
		Card card = dealer.dealCard();
		player.addCard(card);
		System.out.println("\nYou drew " + card.toString());
		System.out.println(player.getPlayerHandValue());
		return black.isBlackjackOrBust(player.getPlayerHandValue());

	}

	private void stand() {
		dealer.hitOrStayDealer();
		System.out.println(dealer.getPlayerHand());
		black.winOrLose(player.getPlayerHandValue(), dealer.getPlayerHandValue());
		System.out.println("With: " + dealer.getPlayerHandValue());

	}
}
