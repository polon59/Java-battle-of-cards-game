public enum Suit {
    HEART("heart", 1),
    SPADE("spade", 2),
    DIAMOND("diamond", 3),
    CLUB("club", 4);

    private String suitName;
    private int n;

    Suit(String suitName, int n){
        this.suitName = suitName;
        this.n = n;
    }
    public String getSuitName(){
        return suitName;
    }
    public int getN(){
        return n;
    }
    
}