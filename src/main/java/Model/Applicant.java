package Model;
public class Applicant {
    private int age;
    private String name;
    public Applicant(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

