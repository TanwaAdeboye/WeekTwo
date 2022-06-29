package Model;

public class Products
{
    private double price;
    private String productType;
    private double productQuantity;
    // products quantity and prices
    public Products(double price, String productType, double productQuantity) {
        this.price = price;
        this.productType = productType;
        this.productQuantity = productQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getTotalPrice()
    {
        double totalPrice = getPrice() * getProductQuantity();
        return totalPrice;
    }

}



