package com.nick.love.myra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStream {

	private static Integer[] nums = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) {
       // 实现返回数组中值在 2 <= x <= 4 范围的元素
	   // before java8
	   List<Integer> result = new ArrayList<Integer>();
	   for (Integer item : nums) {
		   if (item >= 2 && item <= 4) {
			   result.add(item);
		   }
	   }
	   System.out.println(result);
	   
	   System.out.println("---------------------");
	   // java8
	   Arrays.asList(nums).stream()
	     .filter(item -> (item >= 2 && item <= 4))
	     .forEach(System.out :: println);
	}

}
