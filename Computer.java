import java.util.List;

public class Computer extends Player {

    public Computer(Deck deck) {
        super.cardsInHand = drawCards(deck.getListOfCards());
    }

    public Card pickCard() {
        return null;
    }

        
        
}



