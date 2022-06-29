package Model;

public class Main {
    public static void main(String[] args) {
        Manager headManager = new Manager("Mr Jones", "090827388", "@gmail.com");
        Applicant applicants = new Applicant(15, "Mike");
        System.out.println(headManager.canHire(applicants));

        Cashier cashier1 = new Cashier("0908765",  "@gmail.com");
        Products product = new Products(20000, "Milo", 4);

        Customer customer1 = new Customer("Tim", "090766",  234563.0);
        System.out.println(cashier1.canSellAndCanIssueReceipt(product, customer1, applicants));
    }
}