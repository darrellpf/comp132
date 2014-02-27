
public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String inFirstName, String inLastName, int inAge) {
        firstName = inFirstName;
        lastName = inLastName;
        age = inAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String inFirstName) {
        firstName = inFirstName;
    }

    public void setLastName(String inLastName) {
        lastName = inLastName;
    }

    public void setAge(int inAge) {
        age = inAge;
    }
}
