package Model;
public class Applicant {
    private int age;
    private String qualify;
   // private String name;
    public Applicant(int age, String qualify)
    {
        this.age = age;
        this.qualify = qualify;
    }

    public int getAge() {
        return age;
    }

    public String getQualify() {
        return qualify;
    }
}

