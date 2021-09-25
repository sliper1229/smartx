package com.cc.smartx.javanio.zhss.buffer;

import java.nio.ByteBuffer;

public class BufferFlipDemo {
	
	public static void main(String[] args) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		
		System.out.println("position=" + buffer.position());  
		System.out.println("capacity=" + buffer.position());  
		System.out.println("limit=" + buffer.limit());  
	
		byte[] src = new byte[] {1, 2, 3, 4, 5};
		buffer.put(src);
		System.out.println("position=" + buffer.position());  // position = 0~4，都填充了数据 
		
		// position = 5，此时如果你直接读数据，是读不到的，是空的没有数据
		// 手动操作一下position，调整到position = 0的地方，开始读数据
		buffer.position(0);
		buffer.put(Byte.valueOf("15"));
		buffer.put(Byte.valueOf("16"));
		buffer.put(Byte.valueOf("17"));
		// 15, 16, 17, 4, 5
		buffer.flip();

		readBuffer(buffer);

		buffer.rewind();

		readBuffer(buffer);
	}

	private static void readBuffer(ByteBuffer buffer) {
		byte[] dst = new byte[3];
		buffer.get(dst);
		System.out.println("position=" + buffer.position());

		System.out.print("dst=[");
		for(int i = 0; i < dst.length; i++) {
			System.out.print(i);
			if(i < dst.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

}
