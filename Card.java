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
        String cardString = "Suit" + suit + "Rank" + rank;
        return cardString;
    }
}