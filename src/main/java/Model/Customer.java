package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends  Person {
    private double balance;

    private List<Products> myCustomerList = new ArrayList<>();

    public List<Products> getMyCustomerList() {
        return myCustomerList;
    }

    public void setMyCustomerList(List<Products> myCustomerList) {
        this.myCustomerList = myCustomerList;
    }

    public Customer(String name, String phoneNumber, double balance) //constructors
    {
        super(name, phoneNumber, "default email");
        this.balance = balance;
        //initializing the fields
    }

    //Customer can make purchases
    public double getBalance() {
        return balance;
    }


}


