import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Card {
    Rank rank;
    Color color;
    boolean faceDown;

    public Card(Rank rank, Color color, boolean faceDown) {
        this.rank = rank;
        this.color = color;
        this.faceDown = faceDown;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public boolean getFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }

    public boolean isSameColor(Card card) {
        return this.getColor().equals(card.getColor());
    }

    public boolean isSameRank(Card card) {
        return this.getRank().equals(card.getRank());
    }

    public void turnCard() {

        faceDown = !faceDown;
    }

    public ArrayList<String> readASCIIfromFile() {
        ArrayList<String> lines = new ArrayList<>();
        String fileName;
        if (faceDown) {fileName = "cardASCII/cardback.txt";} 

        else {
            if(this.getColor().equals(Color.RED)){
                fileName = "cardASCII/" + getRank().getNumber() + "-RED" + ".txt";
            }else{
                fileName = "cardASCII/" + getRank().getNumber() + "-BLACK" + ".txt";
            }
        }

        try {
            Scanner fileReaded = new Scanner(new File(fileName));

            while (fileReaded.hasNextLine()) {
                lines.add(fileReaded.nextLine());
            }

            fileReaded.close();
        
        } catch (FileNotFoundException e) {System.out.println("file not found");}

        return lines;
    }

    public String toString() {
        ArrayList<String> cardLines = readASCIIfromFile();
        String cardImage = "";
        String color;

        for (int i = 0; i < cardLines.size(); i++) {
            cardImage += cardLines.get(i) + "\n";
        }

        if (faceDown) {color = "BLUE";}
        else {
            if (this.getColor().equals(Color.RED)) {
                color = "RED";
            } 
            else {color = "BLACK";}
        }
        
        String cardImageInColor = adjustCardColor(cardImage, color);

        return cardImageInColor;
    }

    private String adjustCardColor(String cardImage, String color){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";

        if (color == "RED"){
            cardImage = ANSI_RED + cardImage + ANSI_RESET;
        }
        else if (color == "BLACK"){
            cardImage = ANSI_BLACK + cardImage + ANSI_RESET;
        }
        else{
            cardImage = ANSI_BLUE + cardImage + ANSI_RESET;
        }

        return cardImage;  
    }


    public enum Color {
        RED, BLACK;
    }
}