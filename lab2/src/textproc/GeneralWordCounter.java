package textproc;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor{
	private Set<String> exceptions;
	private Map<String, Integer> counter = new TreeMap<String, Integer>();

	public GeneralWordCounter(Set<String> exceptions) {
		this.exceptions = exceptions;
	}
	
	@Override
	public void process(String w) {
        if(!exceptions.contains(w)) {
			Integer count = counter.get(w);
	 
	        if (count == null) {
	            counter.put(w, 1);
	        }
	        else {
	            counter.put(w, count + 1);
	        }
        }
	}

	@Override
	public void report() {
/*		for(String key: counter.keySet()) {
			if(counter.get(key) >= 200) {
				System.out.println(key);
			}
		}*/
		Set<Map.Entry<String, Integer>> wordSet = counter.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort((j1, j2) -> j2.getValue() - j1.getValue());
		for(int i = 0; i < 5; i++) {
			System.out.println(wordList.get(i).getKey() + " " +wordList.get(i).getValue());
		}
	}
	
	public List<Map.Entry<String, Integer>> getWordList(){
		return new ArrayList<Map.Entry<String, Integer>>(counter.entrySet());
	}
}
