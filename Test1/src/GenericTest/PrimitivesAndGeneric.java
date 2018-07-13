// 494페이지 예제 참고
package GenericTest;


/* 똑같은 패키지 안에서는 만들어진 Box<T>를 모두 참조 하므로 이 부분은 불필요
 class Box<T> {
	
	private T ob;
	
	public void set(T o ) {
		ob = o;
	}

	public T get() {
		return ob;
	}
}
*/


public class PrimitivesAndGeneric {
	
	public static void main(String[] args) {
		Box<Integer> iBox = new Box<Integer>();
		iBox.set(125);; //오토 박싱진행
		int num = iBox.get(); //오토 언박싱 진행
		System.out.println(num);
	}
}
