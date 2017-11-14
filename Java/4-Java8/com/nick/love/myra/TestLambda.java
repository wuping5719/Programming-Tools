package com.nick.love.myra;

import java.util.Arrays;

public class TestLambda {

	public static void main(String[] args) {
      String[] strings = {"b", "a", "c", "d"};
      
      Arrays.sort(strings, (o1, o2) -> o1.compareToIgnoreCase(o2));
      
      Arrays.asList(strings).forEach(System.out::println);
	}

}
