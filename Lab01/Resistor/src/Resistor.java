/*
Date: 13-09-2022
*/

public class Resistor {
    //Instance (state) variables
    private double RealResistance;
    private double RealVoltage;
    private double RealCurrent;


    public Resistor(double resistance) { //resistance is always know
        RealResistance = resistance; //set resistance
    }
    public double getPower() {
        return RealCurrent*RealVoltage;
    }

    public double getVoltage() {
        return RealVoltage;
    }
    public double getResistance() { //getting resistance either 50 or 100
        return RealResistance;
    }

    public double getCurrent() {
        return RealCurrent;
    }

    public void setVoltage(double voltage) { //set voltage
        if (voltage <= 50.0 && voltage >= -50.0) {
            RealVoltage = voltage;
            RealCurrent = voltage / RealResistance;
        } else {
            System.out.println("Error: voltage value beyond limit");
        }
    }

    public void setCurrent(double current) {

        if (current <= 5.0 && current >= -5.0) {
            RealCurrent = current;
            RealVoltage = current * RealResistance;
        } else {
            System.out.println("Error: current value beyond limit");
        }
    }

    public static void main(String[] args) {
        Resistor r1, r2;

        System.out.println("Creating a 50 Ohm resistor (r1)");

        r1 = new Resistor(50.0);
        System.out.println("Its resistance is " + r1.getResistance() + " Ohms"); //set 50
        System.out.println("Its current is " + r1.getCurrent() + " Amps"); // zero
        System.out.println("Its voltage is " + r1.getVoltage() + " Volts"); //zero
        System.out.println("Its power is " + r1.getPower() + " Watts"); //zero


        System.out.println("Creating a 100 Ohm resistor (r2)"); //set 100
        r2 = new Resistor(100.0);

        System.out.println("Its resistance is " + r2.getResistance() + " Ohms"); //100
        System.out.println("Setting r1's current to 10 Amps");
        r1.setCurrent(10.0); //rejected
        System.out.println("Setting r1's current to 2 Amps");
        r1.setCurrent(2.0); //accepted
        System.out.println("Its current is " + r1.getCurrent() + " Amps"); //2
        System.out.println("Its voltage is " + r1.getVoltage() + " Volts"); //2 * 50
        System.out.println("Its power is " + r1.getPower() + " Watts"); // 100 * 2

        System.out.println("Setting r1's voltage to 90 Volts");
        r1.setVoltage(90.0); //rejected

        System.out.println("Setting r1's voltage to 50 Volts");
        r1.setVoltage(50.0); //accepted

        System.out.println("Its current is " + r1.getCurrent() + " Amps"); //50/50

        System.out.println("Setting r2's current to 3 Amps");
        r2.setCurrent(3.0); //accepted
        System.out.println("Its voltage is " + r2.getVoltage() + " Volts"); //100*3
    }
}
