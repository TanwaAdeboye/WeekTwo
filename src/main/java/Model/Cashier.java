package Model;

import java.util.Map;
import java.util.PriorityQueue;

public class Cashier extends Person {
    public static Cashier currCashier;  //only one copy, no matter how many instances of the object created, can only be accesed by the class name.

    public Cashier(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, emailAddress);
    }


    public String canSellAndCanIssueReceipt() {
        double totalPrice = 0;  // create an empty varaible to count the total price
        String output = "";

        for (Map.Entry<String, PriorityQueue<CashierDTO>> entry : MyStore.customerQueue.entrySet()) { //loop through the customer cart to get the price of each product
           PriorityQueue<CashierDTO> working = entry.getValue();
           while(working.iterator().hasNext()) {
               output += working.peek().getName() + " bought " + working.peek().getQuantity() + " of  " +
                       entry.getKey() + "\n";
               working.poll() ;
           }
        }
            return  output;

    }

}
// }



