package com.nick.love.myra;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestFunctionInterface {
	
	public static void main(String[] args) {
		// 传入 Lambda 表达式
		TestMyraFunInterface.test(() -> { System.out.println(); });
		// 传入方法引用
		TestMyraFunInterface.test(System.out :: println);
		
		// 打印名字列表中包含  Myra 字符串的名字
		String[] names = {"aa", "Myra is a beautiful girl.", "I love Myra Ma.", "dd"};
		PrintNameWithMyra.print(Arrays.asList(names), name -> name.contains("Myra"));
	}
	
	static class TestMyraFunInterface {
		public static void test(MyraFunctionInterface object) {
			object.test2();
		}
	}
	
	static class PrintNameWithMyra {
		public static void print(List<String> names, Predicate<String> condition) {
			for (String name : names) {
				if (condition.test(name)) {
					System.out.println(name);
				}
			}
		}
	}
}
