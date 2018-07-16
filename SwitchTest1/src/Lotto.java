import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		int lotto1[] = new int[6]; // 1~45���� ��ȣ�� �����ϰ� ���� ����
		int sel[] = new int[6]; // ���� �� ��ȣ �迭�� ����

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
			System.out.print("��÷" + (i + 1) + "��ȣ : " + lotto1[i] + ", ");
		}
		System.out.println("");

		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (sel[i] == lotto1[j]) {
					System.out.print("��ȣ��ġ" + sel[i] + " ");
					count++;
				}

				else {
					continue;
				}
			}
		}

		if (count == 3) {
			System.out.println("\n5�� ��÷ ���ϵ帳�ϴ�.");
		} else if (count == 4) {
			System.out.println("\n4�� ��÷ ���ϵ帳�ϴ�.");
		} else if (count == 5) {
			System.out.println("\n3�� ��÷ ���ϵ帳�ϴ�.");
		} else if (count == 6) {
			System.out.println("\n1��!!!!! ��÷ ���ϵ帳�ϴ�.");
		} else {
			System.out.println("\n��÷�� �����ʾҽ��ϴ�. ������ �� �����ϼ���. ^^ ");
		}

	}
}
