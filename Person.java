import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Integer;

public class Person extends Player{
    Scanner reader;


    public Person(Deck deck) {
        drawCards(deck);
    }

    public int pickCard(){
        boolean isWrongInput = true;
        int cardIndex = 1;

        while(isWrongInput){
            reader = new Scanner(System.in);
            System.out.println("Please enter a number of card between 1 and " + super.cardsInHand.size());
            try{
                cardIndex = reader.nextInt();
                if(cardIndex > 0 && cardIndex < super.cardsInHand.size()+1){
                    isWrongInput = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Wrong input, try again");
            }
        }
        return cardIndex;
    }
}