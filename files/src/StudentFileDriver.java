import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentFileDriver {

	public static void main(String[] args) throws FileNotFoundException {
		List<Student> allStudents = new ArrayList<>();

		allStudents.add(new Student("Fred", "Flintstone", 23));
		allStudents.add(new Student("Barney", "Rubble", 44));
		allStudents.add(new Student("Wilma", "Flintstone", 55));

		String fileName = "studentFile.txt";
		
		PrintWriter writer = new PrintWriter(new File(fileName));

		for(Student who : allStudents) {
			String first = who.getFirstName();
			
			String last =  who.getLastName();
			
			int age = who.getAge();
			String anAge = Integer.toString(age);

			String result = first + " " + last + " " + anAge;
			writer.println(result);
		}
		
		writer.close();
		
		List<Student> copyOfStudents = new ArrayList<>();
		
		Scanner inFile = new Scanner(new File(fileName));
		
		while(inFile.hasNextLine()) {
			String aLine = inFile.nextLine();
			
			Scanner splitter = new Scanner(aLine);
			String first = splitter.next();
			String last = splitter.next();
			String age = splitter.next();
			
			int intAge = Integer.parseInt(age);
			
			Student who = new Student(first, last, intAge);
			copyOfStudents.add(who);
		}
		
		inFile.close();
		
		for(Student aStudent : copyOfStudents) {
			System.out.println(aStudent.getFirstName());
		}
	}

}
