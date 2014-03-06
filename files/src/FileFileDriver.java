

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileFileDriver {

	public static void main(String[] args) throws IOException {
		File currentDirectory = new File("/home/darrell");
		
		System.out.println(currentDirectory.getCanonicalPath());
		
		
		File [] allFiles = currentDirectory.listFiles();
		
		Arrays.sort(allFiles, new Comparator<File>() {
			public int compare(File a, File b) {
				return (int) a.length() - (int) b.length();
			}
		});
		
		for(File aFile : allFiles) {
			System.out.println(aFile.getName() + " " + aFile.length());
		}
	}

}
