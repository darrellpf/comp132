import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileDriver {

	public static void main(String[] args) throws FileNotFoundException {

	System.out.println("Hello");

	PrintWriter writer = new PrintWriter("myFile.txt");
	writer.println("Hello");
	writer.println("there");
	writer.close();
	}

}
