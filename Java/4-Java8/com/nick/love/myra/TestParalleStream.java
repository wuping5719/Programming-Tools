package com.nick.love.myra;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestParalleStream {

	public static void main(String[] args) {
		Random random = new Random(100000);
		List<Integer> list = Stream.generate(random::nextInt).limit(100000)
				.collect(Collectors.toList());

		System.out.println("I love Myra Ma！");
		// 普通的 for 循环
		long startTime1 = System.nanoTime();
		for (@SuppressWarnings("unused") Integer i : list) {
			System.out.print("");
		}
		System.out.println("传统方式耗时：" + (System.nanoTime() - startTime1));

		// 使用 Stream 并发处理
		long startTime2 = System.nanoTime();
		list.parallelStream().forEach(n -> { System.out.print(""); });
		System.out.println("并行方式耗时：" + (System.nanoTime() - startTime2));
	}

}
