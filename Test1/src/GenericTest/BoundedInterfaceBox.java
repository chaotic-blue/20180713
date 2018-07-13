package GenericTest;

interface Eatable{
	public String eat();
}

class Apple1 implements Eatable {

	public String toString() {
		return "I am an apple.";
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "It tastes so good!";
	}
}


class Box1<T extends Eatable> {
	T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		System.out.println(ob.eat()); //Eatable�� �����Ͽ��⿡ eat ȣ�Ⱑ��
		return ob;
	}
}


public class BoundedInterfaceBox {
	public static void main(String[] args) {
		Box1<Apple1> box1 = new Box1<>();
		box1.set(new Apple1()); //��� ����

		Apple1 ap = box1.get(); //��� ������
		System.out.println(ap);
	}

}
