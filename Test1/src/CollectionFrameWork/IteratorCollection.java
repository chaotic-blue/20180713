//555������ ���� ����...

package CollectionFrameWork;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorCollection {
	public static void main(String[] args) {

		List<String> list = new LinkedList<>();
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Box");

		Iterator<String> itr = list.iterator(); //�ݺ��� ó�� ȹ��


		//�ݺ��ڸ� ���� ������ ����

		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		System.out.println();


		itr = list.iterator(); //�ݺ��� �ٽ� ȹ��

		//��� "Box" ����
		String str;
		while(itr.hasNext()) {
			str = itr.next();
			if(str.equals("Box"))
				itr.remove();

		}


		itr = list.iterator(); //�ݺ��� �ٽ� ȹ��

		//���� �� ��� Ȯ��

		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		System.out.println();

	}
}
