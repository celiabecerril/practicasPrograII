package BlackJack;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return 0;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}