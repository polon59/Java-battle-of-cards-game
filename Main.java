import java.util.List;

public class Main{

    public static void main(String[] args) {
        // Game game = new Game();
        // game.startNewGame();
        Deck deck = new Deck();
        Player person = new Person(deck);
        Player computer = new Computer(deck);
        System.out.println(person.cardsInHand.toString());
        System.out.println(computer.cardsInHand.toString());

        List<Card> cards = deck.getListOfCards();
        System.out.println(cards.size());
        for (int i = 0; i<cards.size(); i++){
            System.out.println(cards.get(i).toString());
        }
    }
}