import java.util.ArrayList;
import java.util.List;

// abstract class for class Player
public abstract class Player{

    public List<Card> cardsInHand;

public abstract int pickCard();

public void drawCards(Deck deck) {
    List<Card> list = deck.getListOfCards();
    this.cardsInHand = new ArrayList<>();
    cardsInHand = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        cardsInHand.add(list.get(i));
        list.remove(i);
    }
    
}

public List<Card> getCardsInHand(){
    return this.cardsInHand;
}

public void displayCardsInhand(){
    int allLines = 6;
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLUE = "\u001B[34m";

    for (int cardIndex = 0; cardIndex < cardsInHand.size(); cardIndex ++){
        System.out.print(cardIndex +1 + "       ");
    }
    
    System.out.println();


    for (int currentLineNumber = 0; currentLineNumber < allLines; currentLineNumber ++){
        
        
        for (int i = 0; i < cardsInHand.size(); i++){
            //cardLineToPrint = "";

            // change to getFaceDown
            if(cardsInHand.get(i).faceDown){
                System.out.print(ANSI_BLUE + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + 
                " " + ANSI_RESET); 

            }
            else{
                if (cardsInHand.get(i).getColor().equals(Card.Color.RED)){
                    System.out.print(ANSI_RED + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + 
                    " " + ANSI_RESET); 
                }
                else{
                    System.out.print(ANSI_BLACK + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + 
                    " " + ANSI_RESET); 
                }
            }
            
            
            

        }
        System.out.print("\n");
    } 
}




}