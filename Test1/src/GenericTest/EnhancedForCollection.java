//552페이지 예제 참조......

package GenericTest;

import java.util.LinkedList;
import java.util.List;

public class EnhancedForCollection {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		//인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		
		//전체 인스턴스 참조
		for(String s : list)
			System.out.println(s+'\t');
		System.out.println();
		
		list.remove(0); //첫 번째 인스턴스 삭제
		
		//전체 인스턴스 참조
		for(String s : list)
			System.out.println(s+'\t');
		System.out.println();
	}
	
}
