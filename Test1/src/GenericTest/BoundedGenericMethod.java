//505페이지 예제 참조.. dasdasd

package GenericTest;

/* 같은 패키지 내의 다른 클래스에서 Box정의 이미 되어 참고하고 있으므로 주석처리 일단 해둠
class Box<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}
*/

class BoxFactory {
	public static <T extends Number> Box<T> makeBox(T o) {
		Box<T> Box = new Box<T>();
		Box.set(o);
		
		System.out.println("Boxed data: " + o.intValue());
		return Box;
	}
}


class UnBoxer {
	public static <T extends Number> T openBox(Box<T> Box) {
		System.out.println("UnBoxed data: " + Box.get().intValue());
		return Box.get();
	}
}

public class BoundedGenericMethod {
	public static void main(String[] args) {
		Box<Integer> sBox = BoxFactory.makeBox(new Integer(5959));
		int n = UnBoxer.openBox(sBox);
		System.out.println("Returned data: " +n);
	}
}
