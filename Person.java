import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Integer;

public class Person extends Player {
    Scanner reader;

    public Person(Deck deck) {
        drawCards(deck);
    }

    public void move(Player opponent, Deck deck, Card patternCard) {
        int option = chooseOption(deck);
        if (option == 1) {
            placeCardOnTop(deck);
        } else {
            check(deck, opponent, patternCard);
        }
    }

    private void placeCardOnTop(Deck deck) {
        int index = pickCard(deck);
        Card chosenCard = getCardsInHand().get(index);
        chosenCard.setFaceDown(tru
        deck.addCardToPile(chosenCard);
        cardsInHand.remove(index);      
    } 

    p

    } 
    
    public int pickCard(Deck deck){
                
        int numberOfCardsInHards = super.cardsInHand.size();
        return foolproofInput("Please enter a number of card between 1 and " + numberOfCardsInHards, numberOfCardsInHards) - 1;
    } 

    public int foolproofInput(String message, int upperBound){
        boole an isWrongInpu t = true;
        int index = 1;
        while(isWrongInput){
            rea der = new Scanner(System.in);
            System.out.println(message);
            try{  
                index = reader.nextInt();
                if(index > 0 && index < upperBound + 1){
                  }  
            }
            catch(InputMismatchException e){
                System.out.println("Wrong input, try again");
            }
        }
        return index;
    }
}