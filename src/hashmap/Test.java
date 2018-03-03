package hashmap;

public class Test {
	public static void main(String[] args) {
		int sum=0;
		for (int i = 1; i <=10000; i++) {
			sum=sum+i;
		}
		System.out.println("1+2+3+.....+9999+10000的结果是"+sum);
	}
}
