package number;

import java.text.NumberFormat;

public class test1 {

	public static void main(String[] args) {
		NumberFormat num = NumberFormat.getPercentInstance(); 
		num.setMaximumIntegerDigits(3); 
		num.setMaximumFractionDigits(2); 
		double csdn = 0.2049544; 
		System.out.println(num.format(csdn));

	}

}
