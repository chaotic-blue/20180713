import java.util.*;

public class Lotto1 {
	public static void main(String[] args) {

		int Lotto[] = new int[6]; // 로또 당첨으로 뽑히는 6개 번호
		int sel[] = new int[6]; // 로또 참여자가 뽑는 6개 번호
		int count = 0;
		int count1 = 0;
		double percent = 0.0;

		Random ran = new Random(); // 랜덤 변수 생성 및 변수이름 정의

		for (;;) {

			System.out.println();
			for (int i = 0; i < 6; i++) {
				sel[i] = ran.nextInt(45) + 1;
				for (int k = 0; k < i; k++) {
					if (sel[i] == sel[k]) {
						i--;
					}
				}
			}

			for (int i = 0; i < 6; i++) {
				System.out.print(sel[i] + " ");
			}

			System.out.println();

			for (int j = 0; j < 6; j++) {
				Lotto[j] = ran.nextInt(45) + 1;
				for (int k = 0; k < j; k++) {
					if (Lotto[j] == Lotto[k]) {
						j--;
					}
				}
			}

			for (int i = 0; i < 6; i++) {
				if (i < 5) {
					System.out.print("당첨" + (i + 1) + "번호 : " + Lotto[i] + ", ");
				} else if (i == 5) {
					System.out.print("당첨" + (i + 1) + "번호 : " + Lotto[i] + "\n");
				}
			}

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (sel[i] == Lotto[j]) {
						System.out.print("번호일치" + sel[i] + " ");
						count++;
					}

					else {
						continue;
					}
				}
			}

			count1++;

			if (count == 3) {
				System.out.println("\n5등 당첨 축하드립니다.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("이번 회차 5등 당첨 확률 = " + percent +
				 * "% , " + count1 + "번 시도");
				 */
				count = 0;
				// break;
			} else if (count == 4) {
				System.out.println("\n4등 당첨 축하드립니다.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("이번 회차 3등 당첨 확률 = " + percent +
				 * "% , " + count1 + "번 시도");
				 */
				count = 0;
				// break;
			} else if (count == 5) {
				System.out.println("\n3등 당첨 축하드립니다.");

				percent = ((1.0 / count1) * 100);
				System.out.print("이번 회차 3등 당첨 확률 = " + percent + "% , " + count1 + "번 시도");

				count = 0;
				break;
			} else if (count == 6) {
				System.out.println("\n1등!!!!! 당첨 축하드립니다.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("이번 회차 1등 당첨 확률 = " + percent +
				 * "% , " + count1 + "번 시도");
				 */
				count = 0;
				// break;
			} else {
				// System.out.println("\n당첨이 되지않았습니다. 다음에 또 도전하세요. ^^ ");
				count = 0;
			}

		}
	}
}
