import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Integer;

public class Person extends Player{
    private Scanner reader;

    public Person(Deck deck) {
        drawCards(deck);
        sortCards();
        this.startHandSize = cardsInHand.size();
    }
    

    public void addCardsFromPile(Deck pileOnTable) {
        for (Card card : pileOnTable.getListOfCards()) {
            card.setFaceDown(false);
            this.cardsInHand.add(card);
        }
    }

    public int chooseOption(Deck deck, Card patternCard, Player opponent){
        boolean isWrongInput = true;
        int index = 1;
        while(isWrongInput){
            reader = new Scanner(System.in);
            System.out.println("1. Pick card\n2. Check opponent\n3. Take additional card");
            try{
                index = reader.nextInt();
                if(index > 0 && index < 4 ){
                    if(index < 3){
                        isWrongInput = false;
                    }
                    else{
                        if(this.cardsInHand.size() < 9){
                            isWrongInput = false;
                        }
                    }
                }
            }
            catch(InputMismatchException e){
                System.out.println("Wrong input, try again");
            }
        }
        return index;
    }
    
    public int pickCard(Deck deck, Card patternCard){
        int numberOfCardsInHards = super.cardsInHand.size();
        return foolproofInput("Please enter a number of card between 1 and " + numberOfCardsInHards, numberOfCardsInHards) - 1;
    }

    public int foolproofInput(String message, int upperBound){
        boolean isWrongInput = true;
        int index = 1;
        while(isWrongInput){
            reader = new Scanner(System.in);
            System.out.println(message);
            try{
                index = reader.nextInt();
                if(index > 0 && index < upperBound + 1){
                    isWrongInput = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Wrong input, try again");
            }
        }
        return index;
    }
}