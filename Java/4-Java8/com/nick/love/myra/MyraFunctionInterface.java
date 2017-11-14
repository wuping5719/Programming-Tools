package com.nick.love.myra;

// 当一个接口只包含一个抽象方法时，这个接口就是函数式接口

@FunctionalInterface
public interface MyraFunctionInterface {
   // 抽象方法
   void test1();
   
   // 默认方法
   default void test2() {
	   System.out.println("I love Myra Ma.");
   }
   
   // Object 中的方法
   boolean equals(Object other);
}
