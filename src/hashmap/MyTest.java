package hashmap;

import java.util.HashMap;

/**
 * Created by chengxiao on 2016/11/15.
 */
public class MyTest {
	private static class Person {
		int idCard;
		String name;

		public Person(int idCard, String name) {
			this.idCard = idCard;
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Person person = (Person) o;
			// 两个对象是否等值，通过idCard来确定
			return this.idCard == person.idCard;
		}

		@Override
		public int hashCode() {
			int hash = 17;
			hash = hash * 31 + this.name.hashCode();
			hash = hash * 31 + this.idCard;
			return hash;
		}

	}

	public static void main(String[] args) {
		HashMap<Person, String> map = new HashMap<Person, String>();
		Person person = new Person(1234, "峰");
		// put到hashmap中去
		map.put(person, "天龙八部");
		// get取出，从逻辑上讲应该能输出“天龙八部”
		Person person2 = new Person(1234, "峰");
		System.out.println("结果:" + map.get(person2));
	}
}
