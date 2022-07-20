package Model;

public class CashierDTO implements Comparable<CashierDTO>{
    private String name;
    private  int quantity;

    public CashierDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(CashierDTO o) {
        return Integer.compare(this.quantity ,o.quantity);
    }
}
