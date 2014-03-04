import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;

public class FileDriverTryCatch {

	public static void main(String[] args) {

		PrintWriter writer;
		
		try {
			writer = new PrintWriter(new File("/myFile.txt"));
			writer.println("Hello a longer line");
			writer.println("there more stuff");
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("This is an error " + e.getMessage());
		} 
		
		Scanner aScanner;
		try {
			aScanner = new Scanner(new File("myFile.txt"));
			while (aScanner.hasNextLine()) {
				String aLine = aScanner.nextLine();
				System.out.println(aLine);
			}

			aScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
