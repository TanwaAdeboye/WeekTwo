package Model;

import Interface.CustomerRole;

public class Customer extends  Person implements CustomerRole {
    private double balance;

    public Customer(String name, String phoneNumber, double balance) //constructors
    {
        super(name, phoneNumber, "default email");
        this.balance = balance;
        //initializing the fields
    }

    //Customer can make purchases
    @Override
    public String canPurchase() {
        return "can make purchases";
    }

    public double getBalance() {
        return balance;
    }
}