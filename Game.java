import java.util.concurrent.TimeUnit;

public class Game{
    Player person;
    Player computer;

    Deck deck;
    Deck cardsOnTable;

    Card patternCard;
    Card cardOnTop;
    


    public Game(){
        deck = new Deck();
        person = new Person(deck);
        computer = new Computer(deck);
    }

    public void runGame(){
        //losowanie pierwszej karty
        SetPatternCard();

        displayGameTable();
        sleep(3);
        clearScreen();
        
        placeCardOnTop(2);
        displayGameTable();


    }

    public void placeCardOnTop(int index){
        cardOnTop = person.getCardsInHand().get(index);
        cardOnTop.turnCard();
        person.cardsInHand.remove(index);
    }

    private static void clearScreen() { 
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();   
    } 
    
    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch(InterruptedException e){};
    }

    public void SetPatternCard(){
         patternCard = deck.getListOfCards().get(0);
        //deck.remove card from deck (int index = 0)
    }

    public void displayCardsOnTable(){
        String blankCard = "_______\n|     |\n|     |\n| PILE|\n|     |\n|_____|";
        System.out.println(patternCard.toString());
        
        if (cardOnTop == null){System.out.println(blankCard);}
        else{System.out.println(cardOnTop.toString());}
    }

    public void displayGameTable(){
       displayCardsOnTable();
        System.out.println("\n \n");
        person.displayCardsInhand();
    }
}