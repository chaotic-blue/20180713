

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileCopierVerNIO {
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		System.out.println("대상파일 : ");
		Path src = Paths.get("C://Users//User//git//20180713//Test1//sample.txt");
		
		System.out.println("사본이름 : ");
		Path dst = Paths.get("D://sample.txt");
		
		long start = System.currentTimeMillis();
		
		ByteBuffer buf = ByteBuffer.allocate(1024); //버퍼 용량 할당, 버퍼 용량이 작게 설정하면 담는 버퍼수도 많아지기에 프로세스 많이 사용
		
		try(FileChannel ifc = FileChannel.open(src,  StandardOpenOption.READ);
				FileChannel ofc = FileChannel.open(dst,  StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
			int num;
			while(true) {
				num = ifc.read(buf);
				if(num == -1)
					break;
				
				buf.flip();
				ofc.write(buf);
				buf.clear();
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start ) / 1000.00 + "초" );
		/*
		 C:\Users\User\git\20180713\Test1\src\FileCopierVerNIO.java
		 C:\Users\User\git\20180713\Test1\src\Copy.java
		 */
		
	}
}
