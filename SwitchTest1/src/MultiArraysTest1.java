import java.util.*;
public class MultiArraysTest1 {
	public static void main(String args[]) {
		
		Random ran = new Random(); //Random Ŭ�������� �޼ҵ带 ����ϱ� ���� ���纻(��ü, �ν��Ͻ�) ����
		int[][] score = new int[4][4]; //int�� 4by4 ũ���� score��� �̸��� �迭����
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				score[i][j] = ran.nextInt(10)*(-1);
		
		for(int k=0; k<4; k++) {
			int sum=0;
			for (int value : score[k]) {
				System.out.print(value + " ");
				sum = sum + value;
				
			}
			System.out.println("�� �հ�� "+sum);
		
		}
	}
}
