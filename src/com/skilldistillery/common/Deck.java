package com.skilldistillery.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deckCards;

	public Deck() {
		deckCards = new ArrayList<Card>();
		
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deckCards.add(new Card(s, r));
			}
		}

	}

	public int checkSize() {
		return deckCards.size();
	}

	public Card dealCard() {
		return deckCards.remove(0);
	}

	public void shuffleDeck() {
		Collections.shuffle(deckCards);
	}
	
	
}
