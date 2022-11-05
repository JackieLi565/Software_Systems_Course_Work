package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House Holds:" + this.game.getHouseCards().toString()); // House Cards
        System.out.println("You Hold:"  + this.game.getYourCards().toString()); // Your Cards
    }

  @Override
    public boolean hitMe() {
        boolean hit = false;
        int Player = game.score(game.getYourCards());
        
        //exsits when its over 21
        if (Player > 21) {
            System.out.println("Oh no! Your score is over 21; you lose, thanks for playing ");
            System.exit(0);
        }
        
        System.out.println("Would you like a hit? (y/n)");
        String choice = user.nextLine(); //user input
        
        if (choice.equals("y")) {
            return hit = true;
        } else if (choice.equals("n")) {
            return hit = false;
        } else {
            System.out.println("Please select a valid input.");
            hit = hitMe();
        }
        return(hit);
        
    }

  @Override
    public void gameOver() {
        this.display();
        int Player  = game.score(game.getYourCards());
        int House = game.score(game.getHouseCards());
        System.out.println("House Score: " + House + ", Your Score: " + Player);
        
        if ( ((House >= Player) && (House < 21)) || Player > 21) {
            System.out.println("You Lose, Thanks for playing");
        } else {
            System.out.println("You Win, Thanks for playing");
        }
        
    }

}
