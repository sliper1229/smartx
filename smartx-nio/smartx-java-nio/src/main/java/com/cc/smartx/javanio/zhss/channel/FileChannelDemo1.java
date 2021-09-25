package com.cc.smartx.javanio.zhss.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {

	public static void main(String[] args) throws Exception {
		nioReadFile();
//		readFile();
	}

	/**
	 * NIO操作文件
	 */
	private static void nioReadFile() throws IOException {
		// 构造一个传统的文件输出流
		FileOutputStream out = new FileOutputStream(
				"D:\\资料\\京东资料\\技术\\技术\\smartx\\smartx-practice\\src\\main\\java\\com\\cc\\smartx\\practice\\nio\\channel\\hello.txt");
		// 通过文件输出流获取到对应的FileChannel，以NIO的方式来写文件
		FileChannel channel = out.getChannel();

		ByteBuffer buffer = ByteBuffer.wrap("hello world".getBytes());
		channel.write(buffer);
		System.out.println("buffer.position():" + buffer.position());
		System.out.println("channel.position():" + channel.position());
		System.out.println("=====================");

		// 随机写
		buffer.rewind();
		channel.position(5);
		channel.write(buffer);
		System.out.println("buffer.position():" + buffer.position());
		System.out.println("channel.position():" + channel.position());
		System.out.println("=====================");

		channel.close();
		out.close();
	}

	private static void readFile() throws IOException {
		FileOutputStream out = new FileOutputStream(
				"D:\\资料\\京东资料\\技术\\技术\\smartx\\smartx-practice\\src\\main\\java\\com\\cc\\smartx\\practice\\nio\\channel\\hello.txt");
		out.write("hello world 222".getBytes());
	}

}
