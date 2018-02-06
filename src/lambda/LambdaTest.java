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

		// java8以前
		/*
		 * 静态工具方法Collections.sort接受一个list，和一个Comparator接口作为输入参数，
		 * Comparator的实现类可以对输入的list中的元素进行比较。通常情况下，
		 * 你可以直接用创建匿名Comparator对象，并把它作为参数传递给sort方法。
		 */
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
		// 除了创建匿名对象以外，Java 8 还提供了一种更简洁的方式，Lambda表达式。
		Collections.sort(names, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println("第三次排序>>>" + names);
		// 简洁
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		System.out.println("第四次排序>>>" + names);
		// 再简洁
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println("第四次排序>>>" + names);

	}

}
