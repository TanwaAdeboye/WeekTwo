package Interface;
import Model.Customer;
import Model.Products;
import Model.Cashier;

public interface CashierRoles {
    //Cashier gets to sell products and issue receipts to customers
    // Cashier withdraws amount of purchases from customers balance
    String canSellAndCanIssueReceipt(Products product, Customer customers);

}

