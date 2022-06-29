package Model;
import Interface.ManagerRole;

public class Manager extends  Person implements ManagerRole {

    public Manager(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, "default");
    }

    @Override
    public boolean canHire(Applicant applicants)
    //Manager gets to hire applicants that are above 18years
    {
        if (applicants.getAge()>18 && applicants.getAge()<=35) {
            System.out.println("I am " + getName() + ", the Manager, Congratulations, you are hired");
            return true;

        }
        else {
            System.out.println("I am " + getName() + ", the Manager, Sorry, you can not be hired");
            return false;
        }


    }
}
