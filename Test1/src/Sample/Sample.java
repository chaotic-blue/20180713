package Sample;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sample {
	public static void main(String[] args) {
	int[] s = {1,2,3,4,5,6,7,8,9};
	IntStream stm1 = Arrays.stream(s);
	
	int sum = stm1.filter(n -> n%2 == 1).sum();
	
	System.out.println(sum);

	}
}
