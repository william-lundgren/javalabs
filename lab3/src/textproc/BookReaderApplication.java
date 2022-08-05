package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();

		while (scan.hasNext()) {
			String exception = scan.next().toLowerCase();
			stopwords.add(exception);
		}
		
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			counter.process(word);	
		}
		
		BookReaderController controller = new BookReaderController(counter);
	}
}
