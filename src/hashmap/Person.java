package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Person {
	private String name;
	private int age;
	private boolean gender;

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object another) {
		if (this == another) {
			return true;
		}
		if (another instanceof Person) {
			Person anotherPerson = (Person) another;
			if (this.getName().equals(anotherPerson.getName()) && this.getAge() == anotherPerson.getAge()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + getName().hashCode();
		hash = hash * 31 + getAge();
		return hash;
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.age = 11;
		person.name = "张三";
		System.out.println(person);
		System.out.println(person.hashCode());
		Person person1 = new Person();
		person1.age = 11;
		person1.name = "张三";
		System.out.println(person1);
		System.out.println(person1.hashCode());

		Map<Person, String> map = new HashMap<Person, String>();
		map.put(person, "123");
		System.out.println(map.get(person1));
	}

}
