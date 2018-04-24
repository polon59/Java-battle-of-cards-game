import java.util.List;
import java.util.Random;

public class Computer extends Player {
    Random generator = new Random();

    public Computer(Deck deck) {
        drawCards(deck);
        for (int i =0; i< super.cardsInHand.size(); i++){
            super.cardsInHand.get(i).turnCard();
        }
    }

    public int pickCard(){
        int cardIndex = generator.nextInt(super.cardsInHand.size());
        return cardIndex;
    }

        
        
}



