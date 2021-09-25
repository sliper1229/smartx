package com.cc.smartx.javanio.zhss.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileLockDemo1 {

	/**
	 * 文件锁
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		RandomAccessFile in = new RandomAccessFile("D:\\资料\\京东资料\\技术\\技术\\smartx\\smartx-practice\\src\\main\\java\\com\\cc\\smartx\\practice\\nio\\channel\\hello.txt",
				"rw");
		FileChannel channel = in.getChannel();

		channel.lock(0, Integer.MAX_VALUE, true);
		Thread.sleep(60 * 60 * 1000);

		channel.force(true);
		
		channel.close();
		in.close();
	}
	
}
