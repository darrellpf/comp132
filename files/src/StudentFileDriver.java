import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentFileDriver {

	public static void main(String[] args) throws FileNotFoundException {
		List<Student> allStudents = new ArrayList<>();

		allStudents.add(new Student("Fred", "Flintstone", 23));
		allStudents.add(new Student("Barney", "Rubble", 44));
		allStudents.add(new Student("Wilma", "Flintstone", 55));

		String fileName = "studentFile.txt";
		
		writeOutFile(fileName, allStudents);
		
		List<Student> aCopy = new ArrayList<>(allStudents);
		
		Student fred1 = allStudents.get(0);
		Student fred2 = aCopy.get(0);
		
		if(fred1 == fred2) {
			System.out.println("Fred1 and Fred2 are the same");
		}
		
		List<Student> copyOfStudents = readInFile(fileName);
			
		for(Student aStudent : copyOfStudents) {
			System.out.println(aStudent.getFirstName());
		}
		
		Student fred10 = allStudents.get(0);
		Student fred20 = copyOfStudents.get(0);

		if(fred10 == fred20) {
			System.out.println("Fred10 and Fred20 are the same");
		}

		allStudents.add(allStudents.get(0));
		
		String objectFileName = "students.obj";
		writeObjectStudentFile(objectFileName, allStudents);
		
		List<Student> anotherCopy = readObjectStudentFile(objectFileName);
		
		System.out.println("Names from object file");
		
		for(Student aStudent : anotherCopy) {
			System.out.println(aStudent.getFirstName());
		}
		
		Student fred30 = allStudents.get(0);
		Student fred40 = anotherCopy.get(3);

		if(fred30 == fred40) {
			System.out.println("Fred30 and Fred40 are the same");
		}
		
		printMethods();
		
		String xmlFileName = "students.xml";

		writeXMLStudentFile(xmlFileName, allStudents);
		
		List<Student> xmlread  = readXMLStudentFile(xmlFileName);
		
		for(Student who : xmlread) {
			System.out.println(who.getLastName());
		}
	}
	
	private static void writeXMLStudentFile(String fileName,
			List<Student> allStudents) {
		try (XMLEncoder writer = new XMLEncoder(new FileOutputStream(fileName))) {
			writer.writeObject(allStudents);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	private static List<Student> readXMLStudentFile(String fileName) {
		List<Student> anotherListStudents = null;
		try (XMLDecoder reader = new XMLDecoder(new FileInputStream(fileName))) {
			anotherListStudents = (List<Student>) reader.readObject();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

		return anotherListStudents;
	}
	
	private static List<Student> readObjectStudentFile(String fileName) {
		List<Student> copyStudents = null;

		try (ObjectInputStream reader = new ObjectInputStream(
				new FileInputStream(fileName))) {

			copyStudents = (List<Student>) reader.readObject();

		} catch (IOException | ClassNotFoundException x) {
			System.err.format("IOException: %s%n", x);
		}

		return copyStudents;
	}
	
	private static void writeObjectStudentFile(String fileName,
			List<Student> allStudents) {

		try (ObjectOutputStream writer = new ObjectOutputStream(
				new FileOutputStream(fileName))) {

			writer.writeObject(allStudents);

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	
	private static void writeOutFile(String fileName, List<Student> allStudents) throws FileNotFoundException {
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
	}
	
	private static List<Student> readInFile(String fileName) throws FileNotFoundException {
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
		
		return copyOfStudents;
	}
	
	private static void printMethods() {
		System.out.println("Methods of Students");

		Class<Student> aClass = Student.class;

		for (Method aMethod : aClass.getDeclaredMethods()) {
			System.out.println(aMethod.getName());
		}
	}

}


