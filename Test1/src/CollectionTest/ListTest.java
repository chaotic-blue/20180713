package CollectionTest;
import java.util.List;
import java.util.ArrayList;

class Num{
	int Num;
	public Num(int i) {
		this.Num = i;
	}
}

public class ListTest {
	public static void main(String[] args) {
		List<Num> nlist = new ArrayList<Num>();
		Num num1 = new Num(1);
		Num num2 = new Num(2);
		nlist.add(num1);
		nlist.add(num2);
		
		for(Num n : nlist)
			System.out.println(n);
		
	}
}


/*
package CollectionTest;
import java.util.List;
import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		list.remove(0); //0번째 리스트 지워라
		System.out.println();
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
	}
}
*/
