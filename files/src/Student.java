import java.io.Serializable;


public class Student implements Serializable{
    private String firstName;
    private String lastName;
    private int age;

    public Student(String inFirstName, String inLastName, int inAge) {
        firstName = inFirstName;
        lastName = inLastName;
        age = inAge;
    }
    
    public Student() {
        firstName = "";
        lastName = "";
        age = 0;
  	
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
