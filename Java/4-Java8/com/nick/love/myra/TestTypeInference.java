package com.nick.love.myra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTypeInference {

	public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("I love Myra.");
       list.add("My girlfriend is Myra.");
       
       // Java8 中的语法
       // list.addAll() 需要的参数类型是 Collection<? extends String>,
       // Arrays.asList() 的返回值是 List<T>， 
       // 这里的 T 就是根据 Collection<? extends String> 推断出是 String
       list.addAll(Arrays.asList());
       
       // Java7 中的语法
       list.addAll(Arrays.<String>asList());
       
       System.out.println(list);
	}

}
