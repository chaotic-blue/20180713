import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		int lotto1[] = new int[6]; // 1~45까지 번호들 랜덤하게 뽑혀 저장
		int sel[] = new int[6]; // 내가 고른 번호 배열에 저장

		Random ran = new Random();
		int i, j;
		int count = 0;

		for (i = 0; i < 6; i++) {
			sel[i] = stdin.nextInt();
		}

		for (i = 0; i < 6; i++) {

			lotto1[i] = ran.nextInt(45) + 1;

			for (j = 0; j < i; j++) {
				if (lotto1[i] == lotto1[j]) {
					i--;
				}
			}
		}

		for (i = 0; i < 6; i++) {
			System.out.print("당첨" + (i + 1) + "번호 : " + lotto1[i] + ", ");
		}
		System.out.println("");

		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (sel[i] == lotto1[j]) {
					System.out.print("번호일치" + sel[i] + " ");
					count++;
				}

				else {
					continue;
				}
			}
		}

		if (count == 3) {
			System.out.println("\n5등 당첨 축하드립니다.");
		} else if (count == 4) {
			System.out.println("\n4등 당첨 축하드립니다.");
		} else if (count == 5) {
			System.out.println("\n3등 당첨 축하드립니다.");
		} else if (count == 6) {
			System.out.println("\n1등!!!!! 당첨 축하드립니다.");
		} else {
			System.out.println("\n당첨이 되지않았습니다. 다음에 또 도전하세요. ^^ ");
		}

	}
}
