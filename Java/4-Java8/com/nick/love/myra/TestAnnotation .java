package com.nick.love.myra;

import java.lang.annotation.Repeatable;

public class TestAnnotation {

	@Repeatable(Authorities.class)
	public @interface Authority {
		String role();
	}
	
	public @interface Authorities {
		Authority[] value();
	}
	
	public static class RepeatAnnotationUseNewVersion {
		@Authority(role="Admin")
		@Authority(role="Manager")
		public void doSomeThing() {
			System.out.println("Dear Myra Ma, Come on baby, we make love!");
		}
	}
	
	public static void main(String[] args) {
		RepeatAnnotationUseNewVersion repeatAnnotation = new RepeatAnnotationUseNewVersion();
		repeatAnnotation.doSomeThing();
	}

}
