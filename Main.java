public class Main{

    public static void main(String[] args) {
        // Game game = new Game();
        // game.startNewGame();
        Deck deck = new Deck();
        for(Card card : deck.getListOfCards()) {
            System.out.println(card.toString());
        }
    }
}