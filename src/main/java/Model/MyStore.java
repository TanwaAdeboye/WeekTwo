package Model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.parseLong;

public class MyStore {


//    static List<Products> productsList = new ArrayList<>();

    private Map<String, Products> productsInStore = new HashMap<>();

    private Map<String, List<String>> categoryMap = new HashMap<>();

    public MyStore(Map<String, Products> productsInStore, Map<String, List<String>> categoryMap) {
        this.productsInStore = productsInStore;
        this.categoryMap = categoryMap;
    }

    public MyStore() {
    }

    public Map<String, Products> getProductsInStore() {
        return productsInStore;
    }

    public void setProductsInStore(Map<String, Products> productsInStore) {
        this.productsInStore = productsInStore;
    }

    public Map<String, List<String>> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<String, List<String>> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public void readFile(String path) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] rowArr = line.split(",");

                if (!productsInStore.containsKey(rowArr[4])){ //if no product yet, create product
                    String category = rowArr[3];
                    String productName = rowArr[4];
                    int quantity = Integer.parseInt(rowArr[5]);
                    double price = Double.parseDouble(rowArr[6]);
                    Products product = new Products(category, productName,quantity, price);
                    productsInStore.put(productName, product); //the productname, and its attributes
                    if(!categoryMap.containsKey(category)){   // create a list of products if the category is not yet there.
                        List<String> categoryList = new ArrayList<>();
                        categoryList.add(productName);
                        categoryMap.put(category, categoryList);
                    }
                    else{
                        categoryMap.get(category).add(productName);
                    }
                }
                else{
                    Products currentProduct = productsInStore.get(rowArr[4]);    //already categorized at point of adding,
                    currentProduct.setQuantity(currentProduct.getQuantity() + Integer.parseInt(rowArr[5]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public String canPurchase(Customer customer, String productName, int customerQuantity) {
        if(this.getProductsInStore().containsKey(productName)){ //get the hashmap that stores our products in the store and see if it contains the productname the customer wants to buy
            if(this.getProductsInStore().get(productName).getQuantity() >= customerQuantity){ // if the store has enough quantity to sell
                String category = this.getProductsInStore().get(productName).getCategory();  // get the category of the product
                String name = this.getProductsInStore().get(productName).getName();  //get name of the product
                int storeQuantity = this.getProductsInStore().get(productName).getQuantity(); //get the quantity of the product in store
                double price = this.getProductsInStore().get(productName).getPrice();   //get the price of the product
                Products newProduct = new Products(category,name,customerQuantity,price); //create the product to be added to the customer cart
                customer.getMyCustomerList().add(newProduct);    // add the product to the customer cart
                productsInStore.get(productName).setQuantity(storeQuantity - customerQuantity);  //updating the quantity of the product left in store
                return "You have added " + customerQuantity + " " + productName + " in your list.";
            }
            else{
                return productName + " is out of stock.";
            }

        }
        else{
            return productName + " is not in store."; //the store does not have the product
        }
    }
}