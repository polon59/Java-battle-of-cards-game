public class Card {
    int rank;
    int suit;
    boolean faceDown;

    public Card(int rank, int suit, boolean faceDown) {
        this.rank = rank;
        this.suit = suit;
        this.faceDown = faceDown;
    }
    
    public String toString() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        String cardString;
        String cardASCII;

        if (suit == 1 || suit == 2){
            cardString = ANSI_RED + "Suit" + suit + "Rank" + rank + ANSI_RESET;
        }
        else{
            cardString = ANSI_BLACK + "Suit" + suit + "Rank" + rank + ANSI_RESET;
        }

        return cardString;
    }
}