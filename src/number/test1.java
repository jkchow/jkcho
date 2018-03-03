package number;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1 {

	public static void main(String[] args) {
		NumberFormat num = NumberFormat.getPercentInstance(); 
		num.setMaximumIntegerDigits(3); 
		num.setMaximumFractionDigits(2); 
		double csdn = 0.2099544; 
		System.out.println(num.format(csdn));
		long a=(long)((Math.random()*9+1)*10000);
		System.out.println(a);
		System.out.println((long)(a));
		long time = new Date().getTime();
		long currentTimeMillis = System.currentTimeMillis();
		long nanoTime = System.nanoTime();
		System.out.println(time);
		System.out.println(currentTimeMillis);
		System.out.println(nanoTime);
		Map<String,Integer> aMap=new HashMap<String, Integer>();
		aMap.put("1", 1);
		aMap.put("2", 2);
		aMap.put("3", 3);
		System.out.println(aMap);
		Integer integer = aMap.get("");
		List  ab=new ArrayList<>();
		ab.add("123");
		ab.add("1235");
		System.out.println(ab);
		
	}

}
