// 490페이지 제네릭 예제 참고.. 
package GenericTest;


class Apple {
	public String toString() {
		return "I am an apple.";
	}
}


class Orange {
	public String toString() {
		return "I am an orange.";
	}
}


class Box<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}

}

public class FruitAndBoxFault_Generic {

	public static void main(String[] args) {


		Box<Apple> aBox = new Box<Apple>();
		Box<Orange> oBox = new Box<Orange>();
		
		aBox.set(new Apple());
		oBox.set(new Orange());
		//aBox.set("Apple"); //프로래머의 실수
		//oBox.set("Orange"); //프로그래머의 실수

		Apple ap = aBox.get();
		Orange og = oBox.get();

		System.out.println(ap);
		System.out.println(og);

	}
}
