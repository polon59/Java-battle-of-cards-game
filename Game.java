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
        deck.createCards();
        person = new Person(deck);
        computer = new Computer(deck);
        cardsOnTable = new Deck();
        runGame();
    }

    public void runGame(){
        //losowanie pierwszej karty
        clearScreen();
        SetPatternCard();


        displayGameTable();
        placeCardOnTop(person);
        clearScreen();

        displayGameTable();
        placeCardOnTop(computer);
        displayGameTable();

    }

    public void placeCardOnTop(Player player){
        int index = player.pickCard();
        cardOnTop = player.getCardsInHand().get(index -1);
        if (!cardOnTop.faceDown) cardOnTop.turnCard();

        player.cardsInHand.remove(index-1);
        cardsOnTable.addCardToPile(cardOnTop);
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
        System.out.println("Cards on pile " + cardsOnTable.getSizeOfPile());
    }

    public void displayGameTable(){
        computer.displayCardsInhand();
        System.out.println("\n \n");

       displayCardsOnTable();

        System.out.println("\n \n");
        person.displayCardsInhand();
    }
}