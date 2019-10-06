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

	public int winOrLose(int player, int dealer) {
		int result = 0;
		if (player > dealer) {
			System.out.println("Dealer busts.You win this hand.\n");
			result = 1;
		}

		else if (dealer > player) {
			System.out.println("Dealer won this hand.\n");
			result = -1;
		}

		else if (player == dealer) {
			System.out.println("Tie.\n");
			result = 2;
		}
		return result;
	}

}
