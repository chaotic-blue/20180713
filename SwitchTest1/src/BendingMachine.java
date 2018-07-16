import java.util.Scanner;

public class BendingMachine {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("돈을 투입해주세요. ^^ "); // 1번절차 시작

			int money = stdin.nextInt(); // 돈 투입 금액
			if (money <= 0) {
				System.out.println("돈을 제대로 투입해주세요. ^^");
				System.out.println();
			}

			else {
				System.out.println(money + "원 투입하셨습니다."); // 투입금액표시
				System.out.println();
				System.out.println("콜라, 생수, 쥬스 (800원, 400원, 1000원) 선택해주세요.^^ "); // 2번절차 시작
				System.out.println("현재 투입금 = " + money + "원");
				System.out.println();
				System.out.println("거스름돈은 " + "반환" + " 버튼을 누르세요. ^^ ");

				// int drink = stdin.nextInt();
				String drink = stdin.next();

			}
		}

	}
}
