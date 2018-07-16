import java.util.*;
public class MultiArraysTest1 {
	public static void main(String args[]) {
		
		Random ran = new Random(); //Random 클래스내의 메소드를 사용하기 위해 복사본(객체, 인스턴스) 생성
		int[][] score = new int[4][4]; //int형 4by4 크기의 score라는 이름의 배열생성
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				score[i][j] = ran.nextInt(10)*(-1);
		
		for(int k=0; k<4; k++) {
			int sum=0;
			for (int value : score[k]) {
				System.out.print(value + " ");
				sum = sum + value;
				
			}
			System.out.println("의 합계는 "+sum);
		
		}
	}
}
