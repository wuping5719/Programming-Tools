package com.nick.love.myra;

import java.util.List;

public class ICardGroupImpl implements ICardGroup {

	private List<ICard> cards;

    public ICardGroupImpl(List<ICard> cards) {
		this.cards = cards;
	}
	
	@Override
	public List<ICard> sort() {
		this.cards.sort((a, b) -> a.getNumber().compareToIgnoreCase(
				b.getNumber()));
		return this.getCards();
	}

	@Override
	public List<ICard> getCards() {
		return this.cards;
	}
}
