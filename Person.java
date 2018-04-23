import java.util.List;

public class Person extends Player{

    public Person(Deck deck) {
        super.cardsInHand = drawCards(deck.getListOfCards());
    }
    public Card pickCard(){
        return null;
    }


}