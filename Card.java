import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Card {
    int rank;
    int suit;
    boolean faceDown;

    public Card(int rank, int suit, boolean faceDown) {
        this.rank = rank;
        this.suit = suit;
        this.faceDown = faceDown;
    }

    public boolean checkIfCardIsRed(){
        if (suit == 1 || suit == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<String> readASCIIfromFile() {
        ArrayList<String> lines = new ArrayList<>();
        String fileName = rank + ".txt";
        
        
        try{
            Scanner fileReaded = new Scanner(new File(fileName));
            
            while (fileReaded.hasNextLine()){
                lines.add(fileReaded.nextLine());
                //cardImage += fileReaded.nextLine() + "\n";
            }
    
            fileReaded.close();        
            
        }
        catch (FileNotFoundException e){System.out.println("file not found");}

        return lines;
    }
    
    public String toString() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        String cardImageInColor;
        String cardImage = "";
        ArrayList<String> cardLines = readASCIIfromFile();
        

        for (int i = 0; i < cardLines.size(); i++){
            cardImage += cardLines.get(i) + "\n";
        }

        if (checkIfCardIsRed()){
            cardImageInColor = ANSI_RED + cardImage + ANSI_RESET;
        }
        else{
            cardImageInColor = ANSI_BLACK + cardImage + ANSI_RESET;
        }

        return cardImageInColor;
    }
}