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
        boolean gameRunning = true;
        SetPatternCard();


        while (gameRunning){
            
            clearScreen();
            displayGameTable();
            playerMove(person, computer);
            clearScreen();
            displayGameTable();

            
            sleep(1);
            clearScreen();
            displayGameTable();
            
            playerMove(computer, person);
            
        }
    }


    public void addCardsOnTableToPlayer(Player playerWhoTakeCards){

        Card cardToAdd;

        for (int i =0; i<cardsOnTable.getSizeOfPile(); i++){
            cardToAdd = cardsOnTable.getCard(i);
            cardToAdd.turnCard();
            playerWhoTakeCards.cardsInHand.add(cardToAdd);
        }
        cardsOnTable.clear();
        this.cardOnTop = null;
    }


    public void playerMove(Player player, Player opponent){
        //int choice = player.ChooseOption()

        int index = player.pickCard();
        
        cardOnTop = player.getCardsInHand().get(index);

        if (!cardOnTop.faceDown) {cardOnTop.turnCard();}
        player.cardsInHand.remove(index);
        cardsOnTable.addCardToPile(cardOnTop);


        // place card
    //     if (choice == 1){
    //         int index = player.pickCard();
            
    //         cardOnTop = player.getCardsInHand().get(index);
    
    //         if (!cardOnTop.faceDown) {cardOnTop.turnCard();}
    //         player.cardsInHand.remove(index);
    //         cardsOnTable.addCardToPile(cardOnTop);
    //     }

    //     // check opponent
    //     else{
    //         if cardOnTop is valid{addCardsOnTableToPlayer(player);}
    //         else{addCardsOnTableToPlayer(opponent);}
    //     }

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