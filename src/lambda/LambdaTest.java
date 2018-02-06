package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		double calculate = formula.calculate(100);
		double sqrt = formula.sqrt(16);
		System.out.println(calculate);
		System.out.println(sqrt);
		
		
		List<String> names = Arrays.asList("1", "2", "3", "4");
		System.out.println("原始集合>>>>>" + names);
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		System.out.println("第一次排序>>>" + names);
		Comparator<String> comparator = new MyComparator();
		Collections.sort(names, comparator);
		System.out.println("第二次排序>>>" + names);
		Collections.sort(names, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println("第三次排序>>>" + names);
		File file = new File("");
		System.out.println(file.isFile());
		
	}

}
