package coe318.lab6;
import java.util.Scanner;
import java.util.ArrayList;

public class AppTest {
    
    static Scanner user = new Scanner(System.in);
    public static void main(String[] args) {
        int k = 0;
        //1 resis == 2 nodes
        ArrayList <Node> tNodes = new ArrayList <Node>();
        ArrayList <Resistor> tResistors = new ArrayList <Resistor>();
        
        Circuit crkt = Circuit.getInstance();

        //ask for resistors
        System.out.println("How many resistors would you like in your circuit? ");
        int choice = user.nextInt();// ask for amount of resistors
        System.out.println("--- Creating " + choice + " Resistors" + "\n...");
        System.out.println("--- Creating " + choice*2 + " Nodes" + "\n...\n");
        for (int i = 0; i < choice*2; i++) {
            tNodes.add(new Node());
        }
        int rn = 1;
        for (int j = 0; j < choice;j++) {
            System.out.println("Resistance for resistor " + rn++);
            int resis = user.nextInt(); //ask for resistance
            tResistors.add(new Resistor(resis, tNodes.get(k), tNodes.get(++k)));
            
        }

        for (int l = 0; l < tResistors.size(); l++) {
            crkt.add(tResistors.get(l));
        }

        System.out.println("\n" + "-=+ Your Circuit +=- \n\n" + crkt);


    }

}

