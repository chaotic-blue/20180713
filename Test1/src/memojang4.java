//�ڹ� ���� ���� 

import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

class src1 {
	Path src = Paths.get("C:\\Users\\User\\git\\20180713\\Test1\\src\\momojang2.java");
	
	
}

class dst1 {
	Path dst = Paths.get("C:\\Users\\User\\git\\20180713\\Test1\\src\\memojang4.java");
}

public class momojang2 {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		src1 sr = new src1();
		dst1 ds = new dst1();
		
		
		Files.copy(sr.src,  ds.dst, StandardCopyOption.REPLACE_EXISTING);
		long end = System.currentTimeMillis();
		System.out.println( "���� �ð� : " + ( end - start ) / 1000.0 + "��" );
		/*System.out.println("����� ���ϸ� ����");
		

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
		*/
	
	}
}