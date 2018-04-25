import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> listOfCards;

    private static final int FIRST_CARD = 0;

    public Deck() {        
        listOfCards = new ArrayList<>();    
    }

    public void createCards(){
        for (int i = 0; i< 2; i++){
            for (Card.Color color: Card.Color.values()) {
                for (int rank = 1; rank < 14; rank++) {
                    listOfCards.add(new Card(rank, color, false));
                }
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

    public void addCardToPile(Card card) {
        listOfCards.add(card);
    }
    public void removeCardFromPile(Card card) {
        listOfCards.remove(card);
    }
    public Card getCard(int i) {
        return listOfCards.get(i);
    }
    public int getSizeOfPile() {
        return listOfCards.size();
    }
    public Card getFirstCard(){
        return getCard(FIRST_CARD);
    }
    public Card getLastCard(){
        return getCard(getSizeOfPile());
    }
    public boolean isCardValid(){
        if (getSizeOfPile() == 1) {
            return true;
        }
        return checkColorAndRank();
    }
    private boolean checkColorAndRank(){
        return (getFirstCard().getRank() == getLastCard().getRank() || getFirstCard().getColor().equals(getLastCard().getColor()));
    }

}