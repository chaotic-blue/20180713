import java.util.*;

public class Lotto1 {
	public static void main(String[] args) {

		int Lotto[] = new int[6]; // �ζ� ��÷���� ������ 6�� ��ȣ
		int sel[] = new int[6]; // �ζ� �����ڰ� �̴� 6�� ��ȣ
		int count = 0;
		int count1 = 0;
		double percent = 0.0;

		Random ran = new Random(); // ���� ���� ���� �� �����̸� ����

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
					System.out.print("��÷" + (i + 1) + "��ȣ : " + Lotto[i] + ", ");
				} else if (i == 5) {
					System.out.print("��÷" + (i + 1) + "��ȣ : " + Lotto[i] + "\n");
				}
			}

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (sel[i] == Lotto[j]) {
						System.out.print("��ȣ��ġ" + sel[i] + " ");
						count++;
					}

					else {
						continue;
					}
				}
			}

			count1++;

			if (count == 3) {
				System.out.println("\n5�� ��÷ ���ϵ帳�ϴ�.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("�̹� ȸ�� 5�� ��÷ Ȯ�� = " + percent +
				 * "% , " + count1 + "�� �õ�");
				 */
				count = 0;
				// break;
			} else if (count == 4) {
				System.out.println("\n4�� ��÷ ���ϵ帳�ϴ�.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("�̹� ȸ�� 3�� ��÷ Ȯ�� = " + percent +
				 * "% , " + count1 + "�� �õ�");
				 */
				count = 0;
				// break;
			} else if (count == 5) {
				System.out.println("\n3�� ��÷ ���ϵ帳�ϴ�.");

				percent = ((1.0 / count1) * 100);
				System.out.print("�̹� ȸ�� 3�� ��÷ Ȯ�� = " + percent + "% , " + count1 + "�� �õ�");

				count = 0;
				break;
			} else if (count == 6) {
				System.out.println("\n1��!!!!! ��÷ ���ϵ帳�ϴ�.");
				/*
				 * percent=((1.0/count1)*100); System.out.print("�̹� ȸ�� 1�� ��÷ Ȯ�� = " + percent +
				 * "% , " + count1 + "�� �õ�");
				 */
				count = 0;
				// break;
			} else {
				// System.out.println("\n��÷�� �����ʾҽ��ϴ�. ������ �� �����ϼ���. ^^ ");
				count = 0;
			}

		}
	}
}
