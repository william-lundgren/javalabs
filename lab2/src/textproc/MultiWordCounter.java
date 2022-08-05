package textproc;

import java.util.TreeMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{
	private Map<String, Integer> counter = new TreeMap<String, Integer>();
	
	public MultiWordCounter(String[] args) {
		for(int i = 0; i < args.length; i++) {
			counter.put(args[i], 0);
		}
	}
	
	@Override
	public void process(String w) {
		if(counter.containsKey(w)) {
			int count = counter.get(w);
			counter.put(w, count + 1);
		}
	}

	@Override
	public void report() {
		for(String key: counter.keySet()) {
			System.out.println(key + ": " + counter.get(key));
		}
	}

}
