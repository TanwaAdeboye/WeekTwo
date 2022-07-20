package Model;

import java.util.List;

import static Model.Cashier.currCashier;

public class Main {
    public static void main(String[] args) {
        Manager headManager = new Manager("Mr Jones", "090827388", "@gmail.com");
       Applicant applicants = new Applicant(19, "BSc");

       // Cashier cashierNew = new Cashier("Bob", "09085789", "@gmail.com");
        System.out.println(headManager.canHire(applicants));
        // currCashier.getName();
       // Cashier cashier1 = new Cashier("Dolly", "09789", "@gmail");
        //Products product = new Products(2000, "Milo", 4);   //enums for products

        Customer customer1 = new Customer("Tim", "090766",  234563.0);
        Customer customer2 = new Customer("Great", "0902", 23892);
        Customer customer3 = new Customer("Peter", "12345", 1230999);
       //
        // Customer customer3 = new Customer("Ben", "0932", 235792);
        //System.out.println(customer1.canPurchase(product));
      //  System.out.println(cashier1.canSellAndCanIssueReceipt(product, customer1));


        MyStore store = new MyStore();
        String path = "FoodSales.csv";

        store.readFile(path);

        for(Products product: store.getProductsInStore().values()){
            System.out.println(product);
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
       // System.out.println(store.canPurchase(customer1, "Banana", 80));
        System.out.println(store.canPurchase(customer1, "Potato Chips", 15));
        System.out.println(store.canPurchase(customer2, "Potato Chips", 10));
        System.out.println(store.canPurchase(customer3, "Carrot", 25));
        System.out.println(store.canPurchase(customer2, "Carrot", 50));

       // System.out.println(store.canPurchase(customer3, "Whole meal", 15));

        System.out.println(currCashier.canSellAndCanIssueReceipt());
        System.out.println(currCashier.canSellAndCanIssueReceipt());
    }
}