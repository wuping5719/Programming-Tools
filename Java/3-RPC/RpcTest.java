package com.ouc.cs;

import java.net.InetSocketAddress;

public class RpcTest {

	public static void main(String[] args) throws Exception {
       new Thread(new Runnable() {
    	   @Override
    	   public void run() {
    		   try {
    			   RpcExporter.exporter("localhost", 8088);
    		   } catch (Exception e) {
    			   e.printStackTrace();
    		   }
    	   }
       }).start();
       RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
       EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
       System.out.println(echo.echo("Are you ok ?"));
	}

}
