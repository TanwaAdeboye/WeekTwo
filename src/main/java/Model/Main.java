package Model;

import java.util.List;

import static Model.Cashier.currCashier;

public class Main {
    public static void main(String[] args) {
     //   Manager headManager = new Manager("Mr Jones", "090827388", "@gmail.com");
    //    Applicant applicants = new Applicant(19, "BSc");
    //    System.out.println(headManager.canHire(applicants));

        Cashier cashier1 = new Cashier("Dolly", "09789", "@gmail");
        //Products product = new Products(2000, "Milo", 4);   //enums for products

        Customer customer1 = new Customer("Tim", "090766",  234563.0);
        //System.out.println(customer1.canPurchase(product));
      //  System.out.println(cashier1.canSellAndCanIssueReceipt(product, customer1));


        MyStore store = new MyStore();
        String path = "FoodSales.csv";
        store.readFile(path);

        for(Products product: store.getProductsInStore().values()){
            System.out.println(product);
        }

        System.out.println(store.canPurchase(customer1, "Banana", 10));

        System.out.println(cashier1.canSellAndCanIssueReceipt(customer1));

    }
}