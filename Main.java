public class Main{

    public static void main(String[] args) {
        // Game game = new Game();
        // game.startNewGame();
        Deck deck = new Deck();
        Player person = new Person(deck);
        Player computer = new Computer(deck);
        System.out.println(person.cardsInHand.toString());
        System.out.println(computer.cardsInHand.toString());
    }
}