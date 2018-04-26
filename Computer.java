import java.util.List;
import java.util.Random;

public class Computer extends Player {
    private Random generator = new Random();
    private Card validCard;
    private List<Card> validCards;

    public Computer(Deck deck) {
        drawCards(deck);
        for (int i = 0; i < super.cardsInHand.size(); i++) {
            super.cardsInHand.get(i).turnCard();
        }
    }

    public int pickCard(Deck deck, Card patternCard) {

        int cardIndex;
        if (deck.getSizeOfPile() > 12) {
            if (haveValidCard(patternCard) && validCards.size() > 1
                    || cardsInHand.size() == 1 && haveValidCard(patternCard)) {
                cardIndex = cardsInHand.indexOf(validCard);
            } else {
                cardIndex = generator.nextInt(cardsInHand.size());
            }
        } else {
            cardIndex = generator.nextInt(cardsInHand.size());
        }

        return cardIndex;
    }

    public void addCardsFromPile(Deck pileOnTable) {
        for (Card card : pileOnTable.getListOfCards()) {
            card.setFaceDown(true);
            this.cardsInHand.add(card);
        }
    }

    public int chooseOption(Deck deck, Card patternCard, Player opponent) {
        int option = 0;
        if (isLastComputerCard == true) {
            option = 1;
        } else if (opponent.cardsInHand.size() == 0) {
            option = 2;
        } else if (cardsInHand.size() == 1) {
            if (haveValidCard(patternCard)) {
                option = 1;
            } else
                option = generator.nextInt(2) + 2;
        } else if (deck.getSizeOfPile() < 3) {
            option = 1;
        } else {
            double usedCards = (double) opponent.numOfPutCards / opponent.startHandSize;
            System.out.println(opponent.numOfPutCards);
            System.out.println(opponent.startHandSize);
            System.out.println(usedCards);
            double chance = getChanceForCheck(usedCards);
            System.out.println(chance);
            option = randomChoice(chance);
        }

        return option;
    }

    private boolean haveValidCard(Card patternCard) {

        for (Card card : cardsInHand) {
            if (card.isSameColor(patternCard) || card.isSameRank(patternCard)) {
                validCard = card;
                validCards.add(card);
            }
        }
        return validCards.size() > 0;
    }

    private int randomChoice(double percent) {

        int randomInt = generator.nextInt(100);

        if (randomInt < percent) {
            return 2;
        } else
            return 1;

    }

    private double getChanceForCheck(double percent) {
        double base = (double) 2 / 3;
        if (percent < (double) 1 / 3) {
            return percent * 2;
        }
        return 540 * Math.pow((percent - base), 2) + 20;
    }
}
