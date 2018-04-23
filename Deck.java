import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> listOfCards;

    public Deck() {
        listOfCards = new ArrayList<>();
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                listOfCards.add(new Card(rank, suit, true));
            }
        }
        shuffle();
    }

    public List<Card> getListOfCards(){ 
        return listOfCards;
    }

    public void shuffle() {
        Collections.shuffle(listOfCards);
    }

    
}