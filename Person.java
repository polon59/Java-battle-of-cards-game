import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Integer;

public class Person extends Player{
    Scanner reader;


    public Person(Deck deck) {
        drawCards(deck);
    }

    public int chooseOption(Deck deck){
        return foolproofInput("1. Pick card\n2. Check opponent", 2);
    }
    
    public int pickCard(Deck deck){
        int numberOfCardsInHards = super.cardsInHand.size();
        return foolproofInput("Please enter a number of card between 1 and " + numberOfCardsInHards, numberOfCardsInHards);
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