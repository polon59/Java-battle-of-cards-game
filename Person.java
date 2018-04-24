import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Person extends Player{
    Scanner reader = new Scanner(System.in);


    public Person(Deck deck) {
        drawCards(deck);
    }

    public int pickCard(){
        System.out.println("Please enter a number between 1 and " + cardsInHand.size());

        try{
            int cardIndex = reader.nextInt(); 
        }
        catch(Exception InputMismatchException){
            System.out.println("Wrong input, try again");
        }
        return cardIndex - 1;
    }
}