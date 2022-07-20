package Model;
import Model.Applicant;
public class Manager extends  Person{

    public Manager(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, "default");
    }

    public boolean canHire(Applicant applicants)
    //Manager gets to hire applicants that are above 18years
    {
        if(Cashier.currCashier == null) {
            if ((applicants.getAge() > 18 && applicants.getAge() <= 35 ) && (applicants.getQualify() == ("BSc") || applicants.getQualify() ==("WAEC"))) {
               // created an object from the cashier
                Cashier cashierNew = new Cashier("Bob", "09085789", "@gmail.com");
                // passes the applicants name as the cashier

                Cashier.currCashier=cashierNew; //

                System.out.println("I am " + getName() + ", the Manager, Congratulations " + Cashier.currCashier.getName() + " you are hired");
                return true;

            } else {
                System.out.println("I am " + getName() + ", the Manager, Sorry, " + Cashier.currCashier.getName() + " you can not be hired");
                return false;
            }
        }
        else {
            return  false;
        }

    }
}
