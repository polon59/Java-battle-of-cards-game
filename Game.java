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

        for (int a =0; a <2; a++){
            clearScreen();
            displayGameTable();
            placeCardOnTop(person);
            clearScreen();
            displayGameTable();

            
            sleep(1);
            clearScreen();
            displayGameTable();
            placeCardOnTop(computer);
            clearScreen();
            displayGameTable();
            sleep(1);
        }



        
        


        clearScreen();
        //SetPatternCard();

        displayGameTable();
        System.out.println("Player turn");
        placeCardOnTop(person);
        clearScreen();
        displayGameTable();


        
        for (int i =0; i<cardsOnTable.getSizeOfPile(); i++){
            Card cardToAdd = cardsOnTable.getCard(i);
            cardToAdd.turnCard();
            person.cardsInHand.add(cardToAdd);
        
        }
        cardsOnTable.clear();
        this.cardOnTop = null;
        System.out.println("chuj");
        displayGameTable();
        sleep(5);
        clearScreen();
        System.out.println("Comp turn");
        placeCardOnTop(computer);
        clearScreen();
        displayGameTable();
        sleep(1);


            

        

    }

    public void placeCardOnTop(Player player){
        int index = player.pickCard();
        cardOnTop = player.getCardsInHand().get(index);
        if (!cardOnTop.faceDown) cardOnTop.turnCard();

        player.cardsInHand.remove(index);
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
        
        if (this.cardOnTop == null){System.out.println(blankCard);}
        else{System.out.println(this.cardOnTop.toString());}
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