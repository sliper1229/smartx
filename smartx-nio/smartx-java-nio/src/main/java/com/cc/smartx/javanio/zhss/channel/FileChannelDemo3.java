package com.cc.smartx.javanio.zhss.channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo3 {

	/**
	 * 从磁盘文件读取数据
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("D:\\资料\\京东资料\\技术\\技术\\smartx\\smartx-practice\\src\\main\\java\\com\\cc\\smartx\\practice\\nio\\channel\\hello.txt");
		FileChannel channel = in.getChannel();
	
		ByteBuffer buffer = ByteBuffer.allocateDirect(16);
		// 写到buffer里
		channel.read(buffer); // 读数据写入buffer，所以写完以后，buffer的position = 16

		// flip()后从buffer里读
		buffer.flip(); // position = 0，limit = 16
		byte[] data = new byte[16];
		buffer.get(data);
		
		System.out.println(new String(data));  
		
		channel.close();
		in.close();
	}
	
}
