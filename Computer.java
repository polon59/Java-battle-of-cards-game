import java.util.List;
import java.util.Random;

public class Computer extends Player {
    Random generator = new Random();
    Card validCard;

    public Computer(Deck deck) {
        drawCards(deck);
        for (int i = 0; i < super.cardsInHand.size(); i++) {
            super.cardsInHand.get(i).turnCard();
        }
    }

    public int pickCard(Deck deck, Card patternCard) {
        
        int cardIndex;
        if (deck.getSizeOfPile() <= 12) {
            cardIndex = generator.nextInt(cardsInHand.size());
        } else {
                cardIndex = cardsInHand.indexOf(validCard);
        }
        return cardIndex;
    }

    public void addCardsFromPile(Deck pileOnTable) {
        for (Card card : pileOnTable.getListOfCards()) {
            card.setFaceDown(true);
            this.cardsInHand.add(card);
        }
    }

    public int chooseOption(Deck deck, Card patternCard) {
        int option = 1;
        if(isLastComputerCard == true){
            return option;
        }
        if (cardsInHand.size() + deck.getSizeOfPile() == 18) {
            return option = 2;
        }
        else if(deck.getSizeOfPile() < 5) {
            option = 1;
        } else if (deck.getSizeOfPile() <= 12) {
            option = generator.nextInt(2) + 1; 
        } else if (deck.getSizeOfPile() > 12) {
            if(haveValidCard(patternCard)) {
               option = 1;
            } else {
                option = 2;
            }
        } return option;
    }

    private boolean haveValidCard(Card patternCard) {

        for(Card card : cardsInHand) {
            if (card.isSameColor(patternCard) || card.isSameRank(patternCard) ) {
                validCard = card;
                return true;
            } 
        } return false;
    }

}
