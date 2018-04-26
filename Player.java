import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

// abstract class for class Player
public abstract class Player {
    Scanner reader = new Scanner(System.in);

    public static boolean isLastComputerCard;

    protected List<Card> cardsInHand;
    protected int numOfPutCards;
    protected int startHandSize;
    private List<Card> list;

    public abstract int pickCard(Deck deck, Card patternCard);

    public abstract int chooseOption(Deck deck, Card patternCard, Player opponent);

    public abstract void addCardsFromPile(Deck pileOnTable);

    public void move(Player opponent, Deck deck, Card patternCard) {

        int option = chooseOption(deck, patternCard, opponent);
        isLastComputerCard = false;
        if (option == 1) {
            placeCardOnTop(deck, patternCard);
            this.numOfPutCards ++;
        } else if(option == 2) {
            check(deck, opponent, patternCard);
        }
        else if(option == 3){
            takeAdditionalCard();
            isLastComputerCard = true;
        }
    }



    public void placeCardOnTop(Deck deck, Card patternCard) {
        int index = pickCard(deck, patternCard);
        Card chosenCard = getCardsInHand().get(index);
        chosenCard.setFaceDown(true);
        deck.addCardToPile(chosenCard);
        cardsInHand.remove(index);
    }

    //ADDITIONAL FUNCTION
    public void takeAdditionalCard(){
        Card card = this.list.get(list.size()-1);
        card.setFaceDown(false);
        this.cardsInHand.add(card);
        list.remove(list.size()-1);
    }

    
    public void drawCards(Deck deck) {
        List<Card> list = deck.getListOfCards();
        this.cardsInHand = new ArrayList<>();
        cardsInHand = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cardsInHand.add(list.get(i));
            list.remove(i);
        }
        this.list = list;
    }

    public void check(Deck pileOnTable, Player opponent, Card patternCard) {
        if (pileOnTable.getSizeOfPile() == 0) {
            System.out.println("Can't check your opponent's move, there hasn't been");
            return;
        } else {
            if (pileOnTable.isCardValid(patternCard)) {
                if (this.cardsInHand.size() + pileOnTable.getSizeOfPile() < 18) {
                    this.addCardsFromPile(pileOnTable);
                    pileOnTable.clearPile();
                }
            } else {
                opponent.addCardsFromPile(pileOnTable);
                pileOnTable.clearPile();
            }
            resetValues(opponent);
        }
    }


    public List<Card> getCardsInHand() {
        return this.cardsInHand;
    }
    public void sortCards(){
        Collections.sort(cardsInHand, new Comparator<Card>() {
            public int compare(Card card1, Card card2) {
                return card1.getRank().compareTo(card2.getRank());
            }
        });
    }

    private void resetValues(Player opponent) {
        opponent.numOfPutCards = 0;
        this.numOfPutCards = 0;
        opponent.startHandSize = opponent.cardsInHand.size();
        this.startHandSize = this.cardsInHand.size();
    }

    public void displayCardsInhand() {
        int allLines = 7; 
        
        displayCardIndexes();

        for (int currentLineNumber = 0; currentLineNumber < allLines; currentLineNumber++) {

            for (int i = 0; i < cardsInHand.size(); i++) {
                if (cardsInHand.get(i).getFaceDown()) {
                    displayLineInColor(i, currentLineNumber, "BLUE");
                } 
                else {
                    if (cardsInHand.get(i).getColor().equals(Color.RED)) {
                        displayLineInRed(i, currentLineNumber);
                    } else {
                        displayLineInColor(i, currentLineNumber, "BLACK");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    private void displayCardIndexes(){
        
        for (int cardIndex = 0; cardIndex < cardsInHand.size(); cardIndex++) {
            
            if (cardIndex < 10) {System.out.print(cardIndex + 1 + "       ");} 
            else {System.out.print(cardIndex + 1 + "      ");}
        }
        System.out.println();
    }

    private void displayLineInColor(int i, int currentLineNumber, String color){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";

        if (color == "RED"){
            System.out.print(ANSI_RED + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + " "
            + ANSI_RESET);
        }
        else if (color == "BLACK"){
            System.out.print(ANSI_BLACK + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber)
            + " " + ANSI_RESET);
        }
        else{
            System.out.print(ANSI_BLUE + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + " "
            + ANSI_RESET);
        }
    }

}