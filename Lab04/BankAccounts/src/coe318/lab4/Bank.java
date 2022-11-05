package coe318.lab4;

public class Bank {
    private String name;
    private Account [] accounts;
    private int numAccounts;//number of active accounts
    private int max;

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
        this.max = maxNumberAccounts;
    }

    public String getName() {
        return this.name;
    }

    public int getNumAccounts() {
        return this.numAccounts;
    }


    public Account[] getAccounts() {
        return this.accounts; //Fix this
    }

    public boolean hasAccountNumber(int accountNumber) {
        for (int i = 0; i < getNumAccounts(); i++) {
            if (this.accounts[i].getNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Account account) {
        boolean check = false;
        for (int i = 0; i < getNumAccounts(); i++) {
            if (this.accounts[i].getNumber() == account.getNumber()) {
                check = true;
            }
        }
        if (check == true || getNumAccounts() == max) { //at account 4 aka index 3 it does not add since it would be out of bounds
            return false;
        } else {
            accounts[getNumAccounts()] = account;
            this.numAccounts++;
        }
        return true;
    }

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}

