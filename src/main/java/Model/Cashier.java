package Model;

import Interface.CashierRoles;

public class Cashier extends Person {
    public static Cashier currCashier;  //only one copy, no matter how many instances of the object created, can only be accesed by the class name.

    public Cashier(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, emailAddress);
    }


    public String canSellAndCanIssueReceipt(Customer customer) {
        double totalPrice = 0;  // create an empty varaible to count the total price

        for (Products product : customer.getMyCustomerList()) { //loop through the customer cart to get the price of each product
            totalPrice += product.getPrice() * product.getQuantity();
        }
        if (customer.getBalance() >= totalPrice) {
            return "Your total price is " + totalPrice;
        } else {
            return "insufficient funds";
        }
    }

}
// }



