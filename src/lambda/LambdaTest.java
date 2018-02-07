package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
		Formula formula1 = (c) -> c* 100;
		double calculate2 = formula1.calculate(11);
		double sqrt2 = formula1.sqrt(121);
		System.out.println(calculate2);
		System.out.println(sqrt2);
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
		/**
		 * 方法和构造函数引用
		 */
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
		// :: 构造方法Person::new 来创建一个Person类构造函数的引用。
		// Java编译器会自动地选择合适的构造函数来匹配PersonFactory.create函数的签名，并选择正确的构造函数形式
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("振", "周");
		System.out.println(person);
		
		//Lambda的范围,对于lambda表达式外部的变量，其访问权限的粒度与匿名对象的方式非常类似。你能够访问局部对应的外部区域的局部final变量，以及成员变量和静态变量。
		//对于lambda表达式外部的变量，其访问权限的粒度与匿名对象的方式非常类似。
		//你能够访问局部对应的外部区域的局部final变量，以及成员变量和静态变量
		/**
		 * 访问局部变量, 在 lambda 表达式内部企图改变num的值也是不允许的{num=1;return
		 * String.valueOf(from+num);}
		 */
		int num = 1;// 允许去掉final num 在编译的时候被隐式地当做 final 变量来处理，
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		String convert3 = stringConverter.convert(5);
		System.out.println(convert3);
		/**
		 * 访问成员变量与静态变量
		 * 在下面一个类Lambda4  示例，
		 */
		//接口Formula定义了一个默认的方法sqrt，该方法能够访问formula所有的对象实例，包括匿名对象。这个对lambda表达式来讲则无效。
		//默认方法无法在lambda表达式内部被访问。因此下面的代码是无法通过编译的
		//Formula formula = (a) -> sqrt( a * 100);
		/*
		 * Predicates
		 * 是一个布尔类型的函数，该函数只有一个输入参数。
		 * Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
		 */
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));
		
	}

}
/*
	访问成员变量和静态变量
	与局部变量不同，
	我们在lambda表达式的内部能获取到对成员变量或静态变量的读写权。这种访问行为在匿名对象里是非常典型的。
 */
class Lambda4 {
	static int outerStaticNum;
	int outerNum;
	void testScopes(){
		Converter<Integer,String> stringConverter=(from)->{
			outerNum=1;
			outerStaticNum=2;//直接获取对成员变量的读写权。
			return String.valueOf(from);};
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

	@Override
	public String toString() {
		return this.lastName + this.firstName;
	}
}

interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}