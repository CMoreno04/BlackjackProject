package com.skilldistillery.common;

public enum Suit {
	HEARTS("Heart"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	private String name;

	private Suit(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
