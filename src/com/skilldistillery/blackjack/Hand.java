package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.common.Card;

public abstract class Hand {
	List<Card> cards = new ArrayList<>();

	public Hand() {
 
	}

	public void addCard(Card card) {
		cards.add(card);

	}

	public void clearHand() {
		cards.removeAll(cards);
	}

	public abstract int getHandValue();

	public String getHand() {
		String hand = "";
		for (Card card : cards) {
			hand += card.toString();
		}
		return hand;
	}
}
