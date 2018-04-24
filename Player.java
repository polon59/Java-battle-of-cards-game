import java.util.ArrayList;
import java.util.List;

// abstract class for class Player
public abstract class Player{

    public List<Card> cardsInHand;

public abstract Card pickCard();

public List<Card> drawCards(List<Card> list) {
    cardsInHand = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        cardsInHand.add(list.get(i));
        list.remove(i);
    }
    return cardsInHand;
}

public List<Card> getCardsInHand(){
    return cardsInHand;
}

public void displayCardsInhand(){
    int allLines = 6;
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";

    for (int cardIndex = 0; cardIndex < cardsInHand.size(); cardIndex ++){
        System.out.print(cardIndex +1 + "       ");
    }
    
    System.out.println();


    for (int currentLineNumber = 0; currentLineNumber < allLines; currentLineNumber ++){
        
        
        for (int i = 0; i < cardsInHand.size(); i++){
            //cardLineToPrint = "";

            
            if (cardsInHand.get(i).checkIfCardIsRed()){
                System.out.print(ANSI_RED + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + 
                " " + ANSI_RESET); 
            }
            else{
                System.out.print(ANSI_BLACK + cardsInHand.get(i).readASCIIfromFile().get(currentLineNumber) + 
                " " + ANSI_RESET); 
            }
            

        }
        System.out.print("\n");
    } 
}




}