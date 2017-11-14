package com.nick.love.myra;

import java.util.ArrayList;
import java.util.List;

public class TestRefercence {

	static class Person {
		private String name;
		
		private int age;
		
		public Person(String name, int age) {
           this.name = name;
           this.age = age;
		}

		public static int compareByAge(Person person1, Person person2) {
			if (person1.age < person2.age) {
				return -1;
			} else if (person1.age == person2.age) {
				return 0;
			} else {
				return 1;
			}
		}
		
		public int compareByName(Person person1, Person person2) {
			return person1.getName().compareToIgnoreCase(person2.getName());
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
	}
	
	static List<Person> personList;
	static {
		personList = new ArrayList<>();
		personList.add(new Person("bb", 6));
		personList.add(new Person("aa", 25));
		personList.add(new Person("cc", 1));
		personList.add(new Person("ee", 46));
		personList.add(new Person("dd", 12));
	}
	
	public static void main(String[] args) {
		// lambda 表达式
		// personList.sort((p1, p2) -> Person.compareByAge(p1, p2));
		
		// 方法引用 (引用静态方法)
		// personList.sort(Person::compareByAge);
	    
		// 方法引用 (引用特定实例的实例方法)
		// personList.sort(personList.get(0)::compareByName);
		
		for (Person p : personList) {
			System.out.println(p.name + ": " + p.age);
		}
		
		List<String> stringList = new ArrayList<>();
		personList.forEach((p) -> { stringList.add(p.getName()); });
		// 方法引用 (引用特定类的任意实例的实例方法)
		stringList.sort(String::compareToIgnoreCase);
		System.out.println();
		for (String str : stringList) {
			System.out.println(str);
		}
	}

}
