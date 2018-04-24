import java.util.List;
import java.util.Scanner;

public class Person extends Player{
    Scanner reader = new Scanner(System.in);

    public Person(Deck deck) {
        drawCards(deck);
    }

    public Card pickCard(){
        int cardIndex = reader.nextInt();
        return cardsInHand.get(cardIndex);
    }
    

    


}