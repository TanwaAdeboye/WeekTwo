package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    Cashier cashierOne = new Cashier("Ben", "098977878", "@gmail");
    //Products productBought = new Products(5987.7,"Beverages", 3.50);

    Customer customerNew = new Customer("Joel", "234456", 12345678);

    Applicant applicantNew = new Applicant(19, "Zion");


    @Test
    void canSellAndCanIssueReceiptTest()
    {
   //  assertEquals("I " + customerNew.getName() + " can sell and issue receipts", cashierOne.canSellAndCanIssueReceipt(productBought, customerNew, applicantNew));

    }
}