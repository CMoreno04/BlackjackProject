package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;

public class BlackjackHand extends Hand {
	Dealer dealer;

	public int getHandValue() {
		int value = 0;

		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public String isBlackjackOrBust(int num) {
		String result = "";
		if (num == 21) {
			result = "blackjack";
		} else if (num > 21) {
			result = "bust";
		} else {
			result = "safe";
		}
		return result;
	}

	public void winOrLose(int player, int dealer) {
		if (player > dealer && player <= 21) {
			System.out.println("You win this hand.\n");
		}

		else if (dealer > player && dealer <= 21) {
			if (dealer == 21) {
				System.out.println("Blackjack! Dealer won this hand.\n");
			}
			else if (dealer <= 21) {
				System.out.println("Dealer won this hand.\n");
			}
		}

		else if (dealer > 21) {
			System.out.println("Dealer Bust, you win!");
		}
		else if (player > 21) {
			System.out.println("Player Bust, dealer wins!");
		}
	}

}
