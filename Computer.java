import java.util.List;
import java.util.Random;

public class Computer extends Player {
    Random generator = new Random();

    public Computer(Deck deck) {
        drawCards(deck);
        for (int i = 0; i < super.cardsInHand.size(); i++) {
            super.cardsInHand.get(i).turnCard();
        }
    }

    public void move(Player opponent, Deck deck, Card patternCard) {
    }

    public int pickCard(Deck deck) {
        int cardIndex = generator.nextInt(super.cardsInHand.size());
        return cardIndex;
    }

    public void addCardsFromPile(Deck pileOnTable) {
        for (Card card : pileOnTable.getListOfCards()) {
            card.setFaceDown(true);
            this.cardsInHand.add(card);
        }
    }

    private int chooseRandomCard() {
        return generator.nextInt(super.cardsInHand.size());
    }

    public int chooseOption(Deck deck) {
        // if(deck.getSizeOfPile() < 5) {
        //     return 1;
        // } else if (haveValidCard) {
        //     return generator.nextInt(2) + 1; }
        // else return 2;
        return 1;
    }

}
