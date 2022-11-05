
package coe318.lab4;


public class Account {
    private String name;
    private double balance;
    private int number;
    
    
    public Account(String name, int number, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.number = number;
    }
    
    String getName() {
        return this.name;
    }
    
    double getBalance() {
        return this.balance;
    }
    
    int getNumber() {
        return this.number;
    }
    
    boolean deposit (double amount) {
        if (amount <= 0) {
            return false;
        }
        else {
            this.balance = this.balance + amount; 
            return true;
        }
    }
    
    boolean withdraw (double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        else {
            this.balance = this.balance - amount; 
            return true;
        }
    }
    
    @Override 
    public String toString() {
        return "(" + getName() + ", " + getNumber() + ", " + 
                String.format("$%.2f", getBalance()) + ")";
        }
}

