import java.util.Scanner;

public class MoneyCal {
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		System.out.print("���� �����آa : ");
		int inMoney = std.nextInt(); //�� ����
		int compa,cnt,mod,sum = 0;
		int zzz=0;
		int [] Money = {50000, 10000, 5000, 1000, 500, 100, 10, 1};
	
		
		for(int i=0; i<Money.length; i++) {
			
			compa = Money[i];
			
			
			if(inMoney == compa) {
				cnt=inMoney/compa;
				System.out.println(Money[i]+" : "+ cnt + "��");
				break;
			}
		
			else if(inMoney != compa) {
				//while(sum==inMoney) {
				cnt=inMoney/compa;
				sum+=(compa*cnt);

				System.out.println(Money[i]+" : "+ cnt + "��");
				//System.out.println(sum);
				//}
				
				
				/*
				if(sum!=inMoney) {
				System.out.println(Money[i]+" : "+ cnt + "��");
				}
				else if(sum==inMoney) {
					System.out.println(Money[i]+" : "+ "0" + "��");
				}*/
			}
			
			
			//System.out.println(sum + "��");
		}
	
		
		
		
	}
}
