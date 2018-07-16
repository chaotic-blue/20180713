import java.util.Scanner;

public class Test_bendingmachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int TotalMoney = 0;  // 잔액 기억 저장공간(변수)
		Scanner objDrink = new Scanner(System.in);
		int YourChoice = -1;
		
		System.out.println("어서오세요. 음료한잔 하고 가시죠?");
		System.out.println("잔액 : " + TotalMoney);
		
		while(true)  // 무한 반복.
		{
			System.out.print("마시고 싶으면, 돈을 투입하세요: ");
			Scanner objMoney = new Scanner(System.in); // 클래스로부터 객체 생성.
			int Money = objMoney.nextInt();
			if (Money >0)  //투입된 금액이 있으면
			{
				TotalMoney = TotalMoney + Money;  //기존 잔액에 투입된 금액을 더해서, 잔액 재계산
				System.out.println("잔액 : " + TotalMoney);
			}
			//선택가능한 메뉴를 표시.
			if (TotalMoney >= 1000)
				System.out.print("메뉴선택하시오(반환: 0, 생수:1, 콜라:2, 쥬스:3) : ");
			else if (TotalMoney >= 800)
				System.out.print("메뉴선택하시오(반환: 0, 생수:1, 콜라:2) : ");
			else if (TotalMoney >= 400)
				System.out.print("메뉴선택하시오(반환: 0, 생수:1) : ");
			else
				System.out.println("잔액으로 선택할수 있는 메뉴가 없습니다. 더 넣으세요 ");		
			// 메뉴 선택.
			if (TotalMoney >= 400)
			{
				YourChoice = objDrink.nextInt();
			}
			
			switch( YourChoice )
			{
				case 0: System.out.println("잔액 " + TotalMoney + "가 반환되었습니다. 잘 가세요.");
						TotalMoney = 0; // 잔액 재계산
						break;
				case 1: System.out.println("생수가 배출되었습니다.");
						TotalMoney = TotalMoney - 400; // 잔액 재계산
						break;
				case 2: System.out.println("콜라가 배출되었습니다.");
						TotalMoney -= 800; // 잔액 재계산		 	
						break;
				case 3: System.out.println("쥬스가 배출되었습니다.");
						TotalMoney -= 1000; // 잔액 재계산
						break;
			}
			//잔액 표시
			System.out.println("잔액 : " + TotalMoney);
		} //반복블럭 끝
	}
}
 

/*import java.util.Scanner;

public class Test_bendingmachine {

	public static void main(String[] args) {
		
		int TotalMoney = 0;
		Scanner objDrink = new Scanner(System.in);
		int YourChoice = -1;
		System.out.println("어서오세요. 음료한잔 하고 가시죠?");
		System.out.println("잔액 : " + TotalMoney);
		
		while(true)
		{
		System.out.println("마시고 싶으면, 돈을 투입하세요: ");
		Scanner objMoney = new Scanner(System.in); //클래스로부터 객체 생성
		int Money = objMoney.nextInt();
		
		if (Money > 0) //투입된 금액이 있으면
		{
			TotalMoney = TotalMoney + Money; //기존 잔액에 투입된 금액을 더해서, 잔액 재계산
			System.out.println("잔액 : " + TotalMoney);
		}
		//선택가능한 메뉴를 표시
		if(TotalMoney >= 1000)
			System.out.println("메뉴선택 하세요(반환: 0, 생수: 1, 콜라: 2, 쥬스: 3) : ");
		else if (TotalMoney >= 800)
			System.out.println("메뉴선택 하세요(반환: 0, 생수: 1, 콜라: 2) : ");
		else if (TotalMoney >= 400)
			System.out.println("메뉴선택 하세요(반환: 0, 콜라: 1, 생수: 2) : ");
		else 
			System.out.println("잔액으로 선택할 수 있는 메뉴가 없습니다. 더 넣으세요 ");
		//메뉴 선택
		if (TotalMoney >= 1000) {
		YourChoice = objDrink.nextInt();
		}
		
		switch(YourChoice) {
			case 0: System.out.println("잔액" + TotalMoney + "가 반환되었습니다. 잘 가세요.");
					TotalMoney = 0; // 잔액 재계산
					break;
			case 1: System.out.println("생수가 나왔습니다.");
					TotalMoney = TotalMoney - 400;
					break;
			case 2: System.out.println("콜라가 나왔습니다.");
					TotalMoney -= 800;
					break;
			case 3: System.out.println("쥬스가 나왔습니다.");
					TotalMoney -= 1000;
					break;
		}
		//잔액 재계산
		System.out.println("잔액 : " + TotalMoney);
		}
	}
}
*/
