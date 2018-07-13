//505������ ���� ����.. dasdasd

package GenericTest;

/* ���� ��Ű�� ���� �ٸ� Ŭ�������� Box���� �̹� �Ǿ� �����ϰ� �����Ƿ� �ּ�ó�� �ϴ� �ص�
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
