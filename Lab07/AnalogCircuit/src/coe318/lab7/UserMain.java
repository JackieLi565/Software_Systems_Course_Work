package coe318.lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
    //for location count
    static int rCount = 0;
    static int vCount = 0;
    //user input
    static Scanner user = new Scanner(System.in);
    //arraylists
    static ArrayList <Node> tNodes = new ArrayList <>();
    static ArrayList <Resistor> tResistors = new ArrayList <>();
    static ArrayList <VoltageSource> tVoltges = new ArrayList <>();
    static Circuit crkt = Circuit.getInstance(); //creates 1 circuit obj singleton design
    public static void main(String[] args) {
        boolean condition = true;
        AskNode();
        //loop spice/exist
        while (condition == true) {
            System.out.println("\nWould you like to add a resistor (R) or a voltage source (V)\n--To print out your circuit input 'Spice'\n--To exist the program input 'end'");
            String choice = user.next().toLowerCase();

            switch(choice.toLowerCase()) {
                case "v":
                    System.out.println("Please enter voltage magnitude:");
                    Askcomponent("v");
                    break;
                case "r":
                    System.out.println("Please enter resistance magnitude:");
                    Askcomponent("r");
                    break;
                case "spice":
                    System.out.println("-=+ Your Circuit +=-");
                    System.out.println(crkt);
                    break;
                case "end":
                    condition = false;
                    break;
                default:
                    System.out.println("You did not enter a correct value.");
            }
        }
    
    }

    //amount of nodes
    public static void AskNode() {
        //ask for nodesamt
        System.out.println("How many nodes would you like in your circuit? ");
        int choice = user.nextInt();// ask for amount of nodes
        //creates the nodes
        for (int i = 0; i < choice; i++) {
            tNodes.add(new Node());
        }
    }
    //adding either a resistor or a voltage to the circuit
    public static void Askcomponent(String type) {
        double ComponentMagnitude  = user.nextDouble();

            int nodeP = nodey(true);
            int nodeN = nodey(false);

            if (conditions(nodeP, nodeN)) {
                if (type.equals("r")) {
                    tResistors.add(new Resistor(ComponentMagnitude, tNodes.get(nodeP), tNodes.get(nodeN)));
                    crkt.Radd(tResistors.get(rCount++));
                    System.out.println("->Resistor successfully added\n");

                }
                if (type.equals("v")) {
                    tVoltges.add(new VoltageSource(ComponentMagnitude, tNodes.get(nodeP), tNodes.get(nodeN)));
                    crkt.Vadd(tVoltges.get(vCount++));
                    System.out.println("->Voltage source successfully added\n");
                }   
        }
        
    }
    //meet conditions 
    public static boolean conditions(int nodeP, int nodeN) {
        if (nodeP > tNodes.size() || nodeN >= tNodes.size()) {
            System.out.println("Node does not exist in the list, please try again");
            return false;
        } else if (nodeN == nodeP) {
            System.out.println("Component can't be connected to the same node, please try again");
            return false;
        } else {
            return true;
        }
    }

    //asks for how the comp is connected and its polarity
    public static int nodey(boolean check) {
        int NodePolarity;

        if (check) {
            System.out.print("The node connected to the positive terminal: ");
            NodePolarity = user.nextInt();
            return (NodePolarity);
        }
        else {
            System.out.print("The node connected to the negative terminal: ");
            NodePolarity = user.nextInt();
            return (NodePolarity);
        }
    }  

}
