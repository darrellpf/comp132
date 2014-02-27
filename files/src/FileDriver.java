import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class FileDriver {

	public static void main(String[] args) throws MalformedURLException,
			IOException {

		// System.out.println("Hello");

		PrintWriter writer = new PrintWriter(new File("myFile.txt"));
		writer.println("Hello a longer line");
		writer.println("there more stuff");
		writer.close();

		Scanner aScanner = new Scanner(new File("myFile.txt"));

		while (aScanner.hasNextLine()) {
			String aLine = aScanner.nextLine();
			System.out.println(aLine);
		}

		aScanner.close();

		String arguments = "name=fred socialInsurance=656234121";

		System.out.println("Pairs");

		Scanner stringScan = new Scanner(arguments);
		while (stringScan.hasNext()) {
			String pair = stringScan.next();
			parsePair(pair);
		}

		stringScan.close();

		Scanner camosun = new Scanner(new URL("http://camosun.ca").openStream());
		while (camosun.hasNextLine()) {
			String aLine = camosun.nextLine();
			System.out.println(aLine);
		}

		camosun.close();
	}

	public static void parsePair(String pair) {
		Scanner pairScanner = new Scanner(pair);
		pairScanner.useDelimiter("=");

		String first = pairScanner.next();

		System.out.print(first);

		String second = pairScanner.next();

		System.out.println(" " + second);

		pairScanner.close();
	}
}
