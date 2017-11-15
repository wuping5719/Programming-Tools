package com.nick.love.myra;

import java.util.Base64;

public class TestBase64 {

	public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encoderResult = encoder.encodeToString("Myra is my girl.".getBytes());
        System.out.println(encoderResult);
        
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println(new String(decoder.decode(encoderResult)));
	}

}
