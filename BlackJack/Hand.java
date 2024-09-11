package BlackJack;

class Hand {
    private Card[] cards;
    private int cardCount;

    public Hand() {
        cards = new Card[11]; //Una mano no puede tener más de 11 cartas
        cardCount = 0;
        }

    public void addCard(Card card) {
        if (cardCount < cards.length) {
            cards[cardCount] = card;
            cardCount++;
        }
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < cardCount; i++) {
            value += cards[i].getValue();

            if (cards[i].getValue() == 11) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }
}


