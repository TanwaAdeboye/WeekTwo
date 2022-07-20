package Model;
import java.io.*;
import java.util.*;

import static java.lang.Long.parseLong;

public class MyStore {


//    static List<Products> productsList = new ArrayList<>();

    private Map<String, Products> productsInStore = new HashMap<>();

    private Map<String, List<String>> categoryMap = new HashMap<>();

    public static Map<String, PriorityQueue<CashierDTO>> customerQueue = new LinkedHashMap<>();
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
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            //BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] rowArr = line.split(",");
               // System.out.println(Arrays.toString(Arrays.stream(rowArr).toArray()) + " STRING");

                if (!productsInStore.containsKey(rowArr[4])){ //if no product yet, create product
                    String category = rowArr[3];
                    String productName = rowArr[4];
                    long quantity = Long.parseLong(rowArr[5]);
                    double price = Double.parseDouble(rowArr[6]);
                    Products product = new Products(category, productName,quantity, price); //object reference
                    productsInStore.put(productName, product); //the productName, and its attributes
                    if(!categoryMap.containsKey(category)){   // create a list of products if the category is not yet there.
                        List<String> categoryList = new ArrayList<>();
                        categoryList.add(productName);
                        categoryMap.put(category, categoryList);
                    }
                    else{
                        categoryMap.get(category).add(productName); //adds to the category list
                    }
                }
                else{
                    Products currentProduct = productsInStore.get(rowArr[4]);    //already categorized at point of adding,
                    currentProduct.setQuantity(currentProduct.getQuantity() + Long.parseLong(rowArr[5]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public String canPurchase(Customer customer, String productName, int customerQuantity) {
        if(this.getProductsInStore().containsKey(productName)){ //get the hashmap that stores our products in the store and see if it contains the productname the customer wants to buy
            if(this.getProductsInStore().get(productName).getQuantity() >= customerQuantity){
                // if the store has enough quantity to sell
                String category = this.getProductsInStore().get(productName).getCategory();  // get the category of the product
                String name = this.getProductsInStore().get(productName).getName();  //get name of the product
                long storeQuantity = this.getProductsInStore().get(productName).getQuantity(); //get the quantity of the product in store
                double price = this.getProductsInStore().get(productName).getPrice();   //get the price of the product
                Products newProduct = new Products(category,name,customerQuantity,price);
                //create the product to be added to the customer cart
                if(customerQueue.containsKey(productName)){
                     CashierDTO tempDTO = new CashierDTO(customer.getName(), customerQuantity);
                     customerQueue.get(productName).offer(tempDTO);
                }
                else{
                    PriorityQueue<CashierDTO> tempPriorityQueue= new PriorityQueue<>(Comparator.reverseOrder());
                    CashierDTO tempDTO = new CashierDTO(customer.getName(), customerQuantity);
                    tempPriorityQueue.offer(tempDTO);
                    customerQueue.put(productName, tempPriorityQueue);
                }
                productsInStore.get(productName).setQuantity(storeQuantity - customerQuantity);  //updating the quantity of the product left in store
                return customer.getName() + "added "  + customerQuantity + " " + productName + " to queue.";
            }
            else{
                return productName + " is not sufficient, you can get this, and check back later";
            }

        }
        else{
            return productName + " is not in store."; //the store does not have the product
        }
    }
}