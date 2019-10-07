package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Deck;

public class Dealer extends Player {
	private Deck cards;

	public Dealer() {
		cards = new Deck();
		cards.shuffleDeck();
	}

	public void getCard() {
		super.addCard(cards.dealCard());
	}

	public Card dealCard() {
		return cards.dealCard();
	}

	public void cleanTable() {
		hand.clearHand();
	}

	public void hitOrStayDealer() {
		if (hand.getHandValue() >= 17 && hand.getHandValue() <= 21) {
			System.out.println("Dealer Stays\n");
		}

		else if (hand.getHandValue() < 17) {
			System.out.println("\nDealer Draws.\n");
			getCard();
		}
	}

}
