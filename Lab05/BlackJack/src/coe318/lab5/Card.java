package coe318.lab5;

public class Card implements Comparable {
    //Symbolic constants

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    int rank;
    private int suit;
    private boolean faceUp;

    /**
     * Construct a card of the given rank, suit and whether it is faceup or
     * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
     * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
     * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
     * Clubs, Diamonds, Hearts and Spades respectively.
     *
     * @param rank
     * @param suit
     * @param faceUp
     */
    public Card(int rank, int suit, boolean faceUp) {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = faceUp;
    }

    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
      return this.faceUp; //FIX THIS
    }

    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {
      this.faceUp = faceUp;
    }

    /**
     * @return the rank
     */
    public int getRank() {
      return this.rank; 
    }

    /**
     * @return the suit
     */
    public int getSuit() {
      return this.suit;
    }

    @Override
    public boolean equals(Object ob) {
      if (!(ob instanceof Card)) {
        return false;
      }
      Card c = (Card) ob; //compare if the cards match or not
      if (c.rank == this.rank && c.suit == this.suit)  //card c is Ace
          return true;
      else
          return false;

    }

    @Override
    public int hashCode() {//DO NOT MODIFY
      int hash = 7;
      hash = 31 * hash + this.getRank();
      hash = 31 * hash + this.getSuit();
      return hash;
    }

    @Override
    public int compareTo(Object obj) {//DO NOT MODIFY
      return compareTo((Card) obj);
    }

    public int compareTo(Card c) {
        if (this.rank < c.rank || this.suit < c.suit) { //rank
            return -1;
        } else if (this.rank > c.rank || this.suit > c.suit) {
            return 1;
        } else {
            return 0;
        }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
    public String getRankString() { 
        switch(this.rank){
            case 11:
                return("Jack");
            case 12:
                return("Queen");
            case 13:
                return("King");
            case 14:
                return("Ace");
            default: //will print out number of card thats below 10
                return(Integer.toString(this.rank));
            }
    }
   
    public String getSuitString() { //converts the spades # back to string
        String suit = "";
        
        switch(this.suit) {
            case 0:
                suit = "Clubs";
                break;
            case 1:
                suit = "Diamonds";
                break;
            case 2:
                suit = "Hearts";
                break;
            case 3:
                suit = "Spades";
                break;            
        }
        return suit;
    }
   
    @Override
    public String toString() {
        if(this.faceUp)
            return (this.getRankString() + " of " + this.getSuitString());
        else 
            return "?";
    }

    public static void main(String[] args) {
        //Create 5 of clubs
        Card club5 = new Card(5, 0, true);
        System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println("spadeAce: " + spadeAce);
        System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce)); //false
        System.out.println("club5 compareTo club5: " + club5.compareTo(club5)); //0
        System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce)); //false
        System.out.println("club5 equals club5: " + club5.equals(club5)); //true
    }
}
