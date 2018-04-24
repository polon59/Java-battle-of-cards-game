import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Person extends Player{
    Scanner reader = new Scanner(System.in);


    public Person(Deck deck) {
        drawCards(deck);
    }

    public int pickCard(){
        boolean isWrongInput = true;
        int cardIndex = 1;

        while(isWrongInput){
            System.out.println("Please enter a number of card between 1 and " + super.cardsInHand.size());
            try{
                isWrongInput = false;
                cardIndex = reader.nextInt(); 
            }
            catch(Exception InputMismatchException){
                System.out.println("Wrong input, try again");
                isWrongInput = true;
            }
        }
        return cardIndex;
    }

    
}