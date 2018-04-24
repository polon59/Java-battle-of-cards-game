import java.util.List;
import java.util.Random;

public class Computer extends Player {
    Random generator = new Random();

    public Computer(Deck deck) {
        drawCards(deck);
    }

    public Card pickCard() {
        int cardIndex = generator.nextInt(cardsInHand.size());
        return cardsInHand.get(cardIndex);    
    }

        
        
}



