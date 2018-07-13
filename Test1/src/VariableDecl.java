import java.util.*;
public class VariableDecl {

	public static void main(String[] args) {
		double num1, num2; //두 개 변수 동시 선언
		double result;
		num1 = 1.0000001;
		num2 = 2.0000001;
		result = num1 + num2;
		System.out.println(result); //3.0000002결과값을 예상하지만 실수의 표현에는 오차가 존재함. 변수에 저장되는값은 이에 가까운 값임.
		
	}
	
}
