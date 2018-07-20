//자바 파일 복사 

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

public class momojang2 {
	public static void main(String[] args) throws IOException {
		Path src = Paths.get("C:\\Users\\User\\git\\20180713\\Test1\\src\\momojang2.java");
		Path dst = Paths.get("C:\\Users\\User\\git\\20180713\\Test1\\src\\memojang3.java");
		
		Files.copy(src,  dst, StandardCopyOption.REPLACE_EXISTING);
		
		/*System.out.println("출력할 파일명 써줘");
		

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
