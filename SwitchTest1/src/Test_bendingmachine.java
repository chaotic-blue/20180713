import java.util.Scanner;

public class Test_bendingmachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int TotalMoney = 0;  // �ܾ� ��� �������(����)
		Scanner objDrink = new Scanner(System.in);
		int YourChoice = -1;
		
		System.out.println("�������. �������� �ϰ� ������?");
		System.out.println("�ܾ� : " + TotalMoney);
		
		while(true)  // ���� �ݺ�.
		{
			System.out.print("���ð� ������, ���� �����ϼ���: ");
			Scanner objMoney = new Scanner(System.in); // Ŭ�����κ��� ��ü ����.
			int Money = objMoney.nextInt();
			if (Money >0)  //���Ե� �ݾ��� ������
			{
				TotalMoney = TotalMoney + Money;  //���� �ܾ׿� ���Ե� �ݾ��� ���ؼ�, �ܾ� ����
				System.out.println("�ܾ� : " + TotalMoney);
			}
			//���ð����� �޴��� ǥ��.
			if (TotalMoney >= 1000)
				System.out.print("�޴������Ͻÿ�(��ȯ: 0, ����:1, �ݶ�:2, �꽺:3) : ");
			else if (TotalMoney >= 800)
				System.out.print("�޴������Ͻÿ�(��ȯ: 0, ����:1, �ݶ�:2) : ");
			else if (TotalMoney >= 400)
				System.out.print("�޴������Ͻÿ�(��ȯ: 0, ����:1) : ");
			else
				System.out.println("�ܾ����� �����Ҽ� �ִ� �޴��� �����ϴ�. �� �������� ");		
			// �޴� ����.
			if (TotalMoney >= 400)
			{
				YourChoice = objDrink.nextInt();
			}
			
			switch( YourChoice )
			{
				case 0: System.out.println("�ܾ� " + TotalMoney + "�� ��ȯ�Ǿ����ϴ�. �� ������.");
						TotalMoney = 0; // �ܾ� ����
						break;
				case 1: System.out.println("������ ����Ǿ����ϴ�.");
						TotalMoney = TotalMoney - 400; // �ܾ� ����
						break;
				case 2: System.out.println("�ݶ� ����Ǿ����ϴ�.");
						TotalMoney -= 800; // �ܾ� ����		 	
						break;
				case 3: System.out.println("�꽺�� ����Ǿ����ϴ�.");
						TotalMoney -= 1000; // �ܾ� ����
						break;
			}
			//�ܾ� ǥ��
			System.out.println("�ܾ� : " + TotalMoney);
		} //�ݺ��� ��
	}
}
 

/*import java.util.Scanner;

public class Test_bendingmachine {

	public static void main(String[] args) {
		
		int TotalMoney = 0;
		Scanner objDrink = new Scanner(System.in);
		int YourChoice = -1;
		System.out.println("�������. �������� �ϰ� ������?");
		System.out.println("�ܾ� : " + TotalMoney);
		
		while(true)
		{
		System.out.println("���ð� ������, ���� �����ϼ���: ");
		Scanner objMoney = new Scanner(System.in); //Ŭ�����κ��� ��ü ����
		int Money = objMoney.nextInt();
		
		if (Money > 0) //���Ե� �ݾ��� ������
		{
			TotalMoney = TotalMoney + Money; //���� �ܾ׿� ���Ե� �ݾ��� ���ؼ�, �ܾ� ����
			System.out.println("�ܾ� : " + TotalMoney);
		}
		//���ð����� �޴��� ǥ��
		if(TotalMoney >= 1000)
			System.out.println("�޴����� �ϼ���(��ȯ: 0, ����: 1, �ݶ�: 2, �꽺: 3) : ");
		else if (TotalMoney >= 800)
			System.out.println("�޴����� �ϼ���(��ȯ: 0, ����: 1, �ݶ�: 2) : ");
		else if (TotalMoney >= 400)
			System.out.println("�޴����� �ϼ���(��ȯ: 0, �ݶ�: 1, ����: 2) : ");
		else 
			System.out.println("�ܾ����� ������ �� �ִ� �޴��� �����ϴ�. �� �������� ");
		//�޴� ����
		if (TotalMoney >= 1000) {
		YourChoice = objDrink.nextInt();
		}
		
		switch(YourChoice) {
			case 0: System.out.println("�ܾ�" + TotalMoney + "�� ��ȯ�Ǿ����ϴ�. �� ������.");
					TotalMoney = 0; // �ܾ� ����
					break;
			case 1: System.out.println("������ ���Խ��ϴ�.");
					TotalMoney = TotalMoney - 400;
					break;
			case 2: System.out.println("�ݶ� ���Խ��ϴ�.");
					TotalMoney -= 800;
					break;
			case 3: System.out.println("�꽺�� ���Խ��ϴ�.");
					TotalMoney -= 1000;
					break;
		}
		//�ܾ� ����
		System.out.println("�ܾ� : " + TotalMoney);
		}
	}
}
*/
