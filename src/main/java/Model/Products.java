package Model;

import java.util.ArrayList;
import java.util.List;

public class Products
{

    private String category;
    private String name;

    private long quantity;
    private double price;

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    //    public static List<Products> productsList;

    //enums
    // products quantity and prices


    public Products(String category, String name, long quantity, double price) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Products;" + "\n" +
                "category: " + category + "\n" +
                "name: " + name + "\n" +
                "quantity: " + quantity + "\n" +
                "price: " + price + "\n";
    }
}




   // public double getTotalPrice()
  //  {
     //   double totalPrice = getPrice() * getProductQuantity();
     //   return totalPrice;






