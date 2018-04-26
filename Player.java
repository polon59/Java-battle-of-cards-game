import java.util.ArrayList;
import java.util.List;

// abstract class for class Player
public abstract class Player {

    protected List<Card> cardsInHand;
    protected int numOfPutCards;

    public abstract int pickCard(Deck deck, Card patternCard);

    public abstract int chooseOption(Deck deck, Card patternCard);

    public abstract void addCardsFromPile(Deck pileOnTable);

    public void move(Player opponent, Deck deck, Card patternCard) {
        int option = chooseOption(deck, patternCard);
        if (option == 1) {
            placeCardOnTop(deck, patternCard);
        } else {
            check(deck, opponent, patternCard);
        }
    }

    public void placeCardOnTop(Deck deck, Card patternCard) {
        int index = pickCard(deck, patternCard);
        Card chosenCard = getCardsInHand().get(index);
        chosenCard.setFaceDown(true);
        deck.addCardToPile(chosenCard);
        cardsInHand.remove(index);
    }

    public void drawCards(Deck deck) {
        List<Card> list = deck.getListOfCards();
        this.cardsInHand = new ArrayList<>();
        cardsInHand = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cardsInHand.add(list.get(i));
            list.remove(i);
        }

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
        }
    }

    public List<Card> getCardsInHand() {
        return this.cardsInHand;
    }

    public void displayCardsInhand() {
        int allLines = 6;
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";

        for (int cardIndex = 0; cardIndex < cardsInHand.size(); cardIndex++) {
            if (cardIndex < 10) {
                System.out.print(cardIndex + 1 + "       ");
            } else {
                System.out.print(cardIndex + 1 + "      ");
            }
        }

        System.out.println();

        for (int currentLineNumber = 0; currentLineNumber < allLines; currentLineNumber++) {

            for (int i = 0; i < cardsInHand.size(); i++) {
                if (cardsInHand.get(i).getFaceDown()) {
                    System.out.print(ANSI_BLUE + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + " "
                            + ANSI_RESET);

                } else {
                    if (cardsInHand.get(i).getColor().equals(Card.Color.RED)) {
                        System.out.print(ANSI_RED + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + " "
                                + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_BLACK + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber)
                                + " " + ANSI_RESET);
                    }
                }

            }
            System.out.print("\n");
        }
    }

}