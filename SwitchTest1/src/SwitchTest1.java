import java.util.Scanner;
//switch문을 이용하여 봄, 여름, 가을, 겨울 출력.
public class SwitchTest1 {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		System.out.print("월을 입력하세요 : ");
		int month = stdin.nextInt();
		String MtoS;
		switch (month) {
		case 12:
		case 1:
		case 2:
			MtoS = "겨울 입니다.";
			break;
		case 3:
		case 4:
		case 5:
			MtoS = "봄 입니다.";
			break;
		case 6:
		case 7:
		case 8:
			MtoS = "여름 입니다.";
			break;
		case 9:
			System.out.print("멋진 9월과 ");
		case 10:
			System.out.print("아름다운 10월과 ");
		case 11:
			System.out.print("낙엽의 11월은 ");
			MtoS = "가을 입니다.";
			break;
		default:
			MtoS = "1 ~ 12월을 벗어난 달입니다.";
			break;

		}
		System.out.println(MtoS);
	}
}


/*  for문 사용하여 작성
public class SwitchTest1 {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 : ");
		
		int month = stdin.nextInt();
		
		if( ( month == 12) || (month == 1) || (month ==2))
			System.out.println("겨울 입니다.");
		else if ( (month == 3) || (month == 4) || (month == 5))
			System.out.println("봄 입니다.");
		else if ( (month == 6) || (month == 7) || (month == 8))
			System.out.println("여름 입니다.");
		else if ( (month == 9) || (month == 10) || (month == 11))
			System.out.println("가을 입니다.");
		else
			System.out.println("제대로 입력하세욤.");
		
	}
}
*/

