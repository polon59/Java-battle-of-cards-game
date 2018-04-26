import java.util.concurrent.TimeUnit;

public class Game {
    Player person;
    Player computer;

    Deck deck;
    Deck cardsOnTable;

    Card patternCard;
    Card cardOnTop;

    public Game() {
        deck = new Deck();
        deck.createCards();
        person = new Person(deck);
        computer = new Computer(deck);
        cardsOnTable = new Deck();

    }

    public void runGame() {

        setPatternCard();

        while (person.getCardsInHand().size() > 0 && computer.getCardsInHand().size() > 0) {
            displayGameTable();
            person.move(computer, cardsOnTable, patternCard);
    
            displayGameTable();
            computer.move(person, cardsOnTable, patternCard);
        }

        if (person.getCardsInHand().size() == 0) {
            System.out.println("PLAYER WINS");
        } else {
            System.out.println("COMPUTER WINS");
        }

    }

    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        ;
    }

    public void setPatternCard() {
        patternCard = deck.getLastCard();
        //deck.remove card from deck (int index = 0)
    }

    public void displayCardsOnTable() {
        String blankCard = "_______\n|     |\n|     |\n| PILE|\n|     |\n|_____|";
        System.out.println(patternCard);

        if (cardsOnTable.getSizeOfPile() == 0) {
            System.out.println(blankCard);
        } else {
            System.out.println(cardsOnTable.getFirstCard());
        }
        System.out.println("Cards on pile " + cardsOnTable.getSizeOfPile());
    }

    public void displayGameTable() {
        computer.displayCardsInhand();
        System.out.println("\n \n");

        displayCardsOnTable();

        System.out.println("\n \n");
        person.displayCardsInhand();
    }
}