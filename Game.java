import java.util.concurrent.TimeUnit;

public class Game {
    private Player person;
    private Player computer;

    private Deck deck;
    private Deck cardsOnTable;

    private Card patternCard;

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
            performRound(person, computer);
            performRound(computer, person);
            // personRound();
            // computerRound();

            if (computer.checkIfPlayerHasNoCards()) {
                performRound(person, computer);
                //personRound();
            }
        }
        performFinalCheck();
        displayWinnerName();
    }

    private void performRound(Player currentPlayer, Player opponent){
        clearScreen();
        displayGameTable();
        if (currentPlayer.getPlayerName() == "computer"){sleep(1);}
        currentPlayer.move(opponent, cardsOnTable, patternCard);
        checkIfnewPatternCardIsNeeded(person);
    }

    private void personRound(){
        clearScreen();
        displayGameTable();
        person.move(computer, cardsOnTable, patternCard);
        checkIfnewPatternCardIsNeeded(computer);
    }

    private void computerRound(){
        clearScreen();
        displayGameTable();
        sleep(1);
        computer.move(person, cardsOnTable, patternCard);
        checkIfnewPatternCardIsNeeded(person);
    }

    private void checkIfnewPatternCardIsNeeded(Player opponent){
        if (opponent.getIsChecked()) {
            newPatternCard();
            opponent.setIsChecked(false);
        }
    }

    private void performFinalCheck(){
        clearScreen();
        cardsOnTable.getLastCard().turnCard();
        displayGameTable();
    }
    
    private void displayWinnerName(){
        if (person.checkIfPlayerHasNoCards()) {
            System.out.println("PLAYER WINS");
        } else {
            System.out.println("COMPUTER WINS");
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void newPatternCard() {
        Card lastCard = person.getOtherCards().get(person.getOtherCards().size() - 1);
        patternCard = lastCard;
        person.getOtherCards().remove(lastCard);
    }

    public void setPatternCard() {
        patternCard = deck.getLastCard();
        deck.removeCardFromPile(patternCard);
    }

    public void displayGameTable() {
        computer.displayCardsInhand();
        System.out.println("\n");

        displayCardsOnTable();

        System.out.println("\n");
        person.displayCardsInhand();
    }

    public void displayCardsOnTable() {
        System.out.println(patternCard);

        if (checkifPileisEmpty()) {
            displayEmptyPile();
        } else {
            displayFullPile();
        }
        showSizeOfPile();
    }

    private boolean checkifPileisEmpty(){
        if (cardsOnTable.getSizeOfPile() == 0){
            return true;
        }
        else{return false;}
    }

    private void displayEmptyPile() {
        System.out.println("\n\n\n\n\n");
    }

    private void displayFullPile(){
        System.out.println(cardsOnTable.getLastCard());
    }

    public void showSizeOfPile() {
        System.out.println("Cards on pile " + cardsOnTable.getSizeOfPile());
    }

}