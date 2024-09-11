package BlackJack;

import java.util.Random;
import java.util.Scanner;

 class Blackjack {
    private Card[] deck;
    private int deckIndex;
    private Hand playerHand;
    private Hand dealerHand;

    public Blackjack() {
        deck = new Card[52];
        deckIndex = 0;
        playerHand = new Hand();
        dealerHand = new Hand();
        initializeDeck();
        shuffleDeck();
    }

    public void play() {
        playerHand.addCard(dealCard());
        dealerHand.addCard(dealCard());
        playerHand.addCard(dealCard());
        dealerHand.addCard(dealCard());

        while (true) {
            System.out.println("Player's Hand: " + playerHand);
            String action = getPlayerAction();
            if (action.equals("hit")) {
                playerHand.addCard(dealCard());
                if (playerHand.getValue() > 21) {
                    System.out.println("Player busts!");
                    return;
                }
            } else if (action.equals("stand")) {
                break;
            }
        }

        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(dealCard());
            if (dealerHand.getValue() > 21) {
                System.out.println("Dealer busts!");
                return;
            }
        }

        determineWinner();
    }

    private void determineWinner() {
        int playerValue = playerHand.getValue();
        int dealerValue = dealerHand.getValue();

        System.out.println("Player's Hand: " + playerHand);
        System.out.println("Dealer's Hand: " + dealerHand);

        if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private String getPlayerAction() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Choose an action (hit/stand): ");
            return scanner.nextLine();
        }
    }

    private void initializeDeck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(suit, rank);
            }
        }
    }

    private void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int j = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private Card dealCard() {
        return deck[deckIndex++];
    }
}