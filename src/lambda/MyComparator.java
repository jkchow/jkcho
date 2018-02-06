package lambda;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		return b.compareTo(a);
	}


}
