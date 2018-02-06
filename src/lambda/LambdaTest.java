package lambda;

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
		// 再简洁
		Collections.sort(names, (a, b) -> a.compareTo(b));
		Comparator<String> comparator2 = (a, b) -> a.compareTo(b);
		// 自定义函数式接口，如果Converter你不写 @FunctionalInterface 注解，程序也是正确的
		// 任意只包含一个抽象方法的接口，我们都可以用来做成lambda表达式
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		converter.eat();
		Integer convert = converter.convert("123");
		System.out.println(convert);
		// 上面的代码实例可以通过静态方法引用，使之更加简洁：
		Converter<String, Integer> converter1 = Integer::valueOf;
		// Java 8 允许你通过 :: 关键字获取方法或者构造函数的的引用。
		// 上面的例子就演示了如何引用一个静态方法。而且，我们还可以对一个对象的方法进行引用：
		Something something = new Something();
		Converter<String, String> converter2 = something::startsWith;
		String converted = converter2.convert("Java");
		System.out.println(converted);
		// 如下理解
		Converter<String, String> converter3 = new Converter<String, String>() {
			@Override
			public String convert(String from) {
				String startsWith = something.startsWith(from);
				return startsWith;
			}

		};
		String convert2 = converter3.convert("hello");
		System.out.println(convert2);
	}

}

class Something {
	String startsWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}
class Person {
	String firstName;
	String lastName;

	Person() {
	}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}