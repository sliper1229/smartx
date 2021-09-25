package com.cc.smartx.javanio.zhss.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo2 {

	/**
	 * 多线程并发安全
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// 构造一个传统的文件输出流
		FileOutputStream out = new FileOutputStream(
				"D:\\资料\\京东资料\\技术\\技术\\smartx\\smartx-practice\\src\\main\\java\\com\\cc\\smartx\\practice\\nio\\channel\\hello.txt");
		// 通过文件输出流获取到对应的FileChannel，以NIO的方式来写文件
		FileChannel channel = out.getChannel();

		for(int i = 0; i < 10; i++) {
			new Thread() {
				
				public void run() {
					try {
						ByteBuffer buffer = ByteBuffer.wrap("hello world".getBytes());
						channel.write(buffer);
					} catch (Exception e) {
						e.printStackTrace();  
					}
				};
				
			}.start();
		}
	}
	
}
