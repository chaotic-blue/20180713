//메모장 내용 입력 받아 가져와서 출력 src폴더 안에 넣는게 아니라 그 전에 바깥에다 둬

import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class memojang {
	public static void main(String[] args) {
		//Scanner std = new Scanner(System.in);
		System.out.println("출력할 파일명 써줘");
		//String st = std.nextLine();

		try(Reader in = new FileReader("memo.txt")) {
			int as;

			while(true) {
				as = in.read();
				if(as == -1)
					break;
				System.out.print((char)as);

			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}
}

/*
Scanner std = new Scanner(System.in);
		System.out.println("출력할 파일명 써줘");
		String st = std.nextLine();

		try(Reader in = new FileReader(st)) {
			int as;

			while(true) {
				as = in.read();
				if(as == -1)
					break;
				System.out.print((char)as);

			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	
	
	
	
	String filePath="C:/Users/User/git/20180713/Test1/src/memo.txt";
		FileInputStream fileStream = null;
		int i =0;
		
		try
		{
			fileStream = new FileInputStream(filePath);
			
			do
			{
				i = fileStream.read();
				System.out.println((char) i);
			}
			while(i != -1);
			
		}
		catch (Exception e)
		{
			System.out.println("파일 입출력 에러!!" + e);
		}
		finally
		{
			try
			{
				fileStream.close();
			}
			catch(Exception e) {
				System.out.println("닫기 실패" + e);
			}

		}
	
*/