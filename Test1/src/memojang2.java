//�޸��� ���� �Է� �޾� �����ͼ� ��� src���� �ȿ� �ִ°� �ƴ϶� �� ���� �ٱ����� ��

import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class memojang {
	public static void main(String[] args) {
		//Scanner std = new Scanner(System.in);
		System.out.println("����� ���ϸ� ����");
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
		System.out.println("����� ���ϸ� ����");
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
			System.out.println("���� ����� ����!!" + e);
		}
		finally
		{
			try
			{
				fileStream.close();
			}
			catch(Exception e) {
				System.out.println("�ݱ� ����" + e);
			}

		}
	
*/