package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;

public class Player {
	protected Hand hand;
	protected Dealer dealer;

	public Player() {
		hand = new BlackjackHand();
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public String getPlayerHand() {
		return hand.getHand();
	}

	public Hand getHand() {
		return hand;
	}
	
	public int getPlayerHandValue() {
		return getHand().getHandValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		return true;
	}

}
