package Model;

import Interface.CashierRoles;

public class Cashier extends Person implements CashierRoles {
    public Cashier(String phoneNumber, String emailAddress) {
        super("default", phoneNumber, "default");
    }

    // Cashier gets to sell products to customers, and deduct customers money from their balance

    @Override
    public String canSellAndCanIssueReceipt(Products product, Customer customers, Applicant applicants)
    {
        if (applicants.getAge()>18 && applicants.getAge() <=35){

            if(customers.getBalance()> product.getPrice() ){
                return "I " +applicants.getName() + " can sell and issue receipts";

            }
            else {
                return "You do not have enough money in your wallet";
            }

        }
        else {
            return "I am not a cashier";
        }
    }

}

