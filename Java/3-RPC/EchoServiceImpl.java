package com.ouc.cs;

public class EchoServiceImpl implements EchoService {
   @Override
   public String echo(String ping) {
	   return ping != null ? ping + " --> I am ok." : " I am ok.";
   }
}
