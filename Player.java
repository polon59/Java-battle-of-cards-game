import java.util.ArrayList;
import java.util.List;

// abstract class for class Player
public abstract class Player{
    protected List<Card> cardsInHand;

public abstract Card pickCard();

public List<Card> drawCards(List<Card> list) {
    cardsInHand = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        cardsInHand.add(list.get(i));
        list.remove(i);
    }
    return cardsInHand;
}



}