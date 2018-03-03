package string;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "123";
		System.out.println("123" == str1.substring(0)); // 3,true
		System.out.println("23" == str1.substring(1));
		System.out.println(str1.substring(1));
		System.out.println(3 * 0.1);
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count = (count++);
		}
		System.out.println("count=" + count);
	}
}
