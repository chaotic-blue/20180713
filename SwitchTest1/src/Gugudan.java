import java.util.*;

public class Gugudan {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		int i, j, k = 0;

		for (i = 1; i < 10; i++) {
			System.out.print("구구단 " + i + "단  ");
			for (j = 1; j < 10; j++) {
				System.out.print(i + " * " + j + " = " + (i * j) + "   ");
			}
				System.out.println();
		}

	}
}
