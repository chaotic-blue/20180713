import java.util.Scanner;

public class BendingMachine {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("���� �������ּ���. ^^ "); // 1������ ����

			int money = stdin.nextInt(); // �� ���� �ݾ�
			if (money <= 0) {
				System.out.println("���� ����� �������ּ���. ^^");
				System.out.println();
			}

			else {
				System.out.println(money + "�� �����ϼ̽��ϴ�."); // ���Աݾ�ǥ��
				System.out.println();
				System.out.println("�ݶ�, ����, �꽺 (800��, 400��, 1000��) �������ּ���.^^ "); // 2������ ����
				System.out.println("���� ���Ա� = " + money + "��");
				System.out.println();
				System.out.println("�Ž������� " + "��ȯ" + " ��ư�� ��������. ^^ ");

				// int drink = stdin.nextInt();
				String drink = stdin.next();

			}
		}

	}
}
