package com.nick.love.myra;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		String[] names = {"aa", "Myra is a beautiful girl.", "I love Myra Ma.", "I want Myra Ma!"};
		
		// Java7 要记得判断空值，否则可能出现空指针异常
		String result1 = getNameWithMyra1(Arrays.asList(names));
		if (result1 != null) {
			System.out.println(result1);
		}
		
		// Java8 通过 Optional 避免了空值的情况
		Optional<String> result2 = getNameWithMyra2(Arrays.asList(names));
		if (result2.isPresent()) {
			System.out.println(result2.get());
		}
	}

	public static String getNameWithMyra1(List<String> names) {
		for (String name : names) {
			if (name.contains("Myra")) {
				return name;
			}
		}
		return null;
	}

	public static Optional<String> getNameWithMyra2(List<String> names) {
		return names.stream().filter(name -> name.contains("Myra")).findFirst();
	}
}
