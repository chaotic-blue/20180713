/* 다른방법으로도 짜보자 난중에 지금은 힘드니깐 ㅡㅡ;
 * public class moraesigae {
	public static void main(String[] args) {
		
		char[] arr = new char[17];
		int j=0;
		for(int i=65; i<82; i++)
		{
			arr[j++]=i;
			System.out.println(var);
		}
		
	}
	
}
*/









public class moraesigae {
	public static void main(String[] args) {
		for(int i=65; i<82; i++) {
		char a1 = (char) i;
		if(i==70) {
			System.out.println();
			System.out.print("\t"); }
		if(i==73) {
			System.out.println();
			System.out.print("\t\t"); }
		if(i==74) {
			System.out.println();
			System.out.print("\t");}
		if(i==77) { System.out.println(); }
		System.out.print(a1+"\t");
		}
	}
}

/*
public class moraesigae {
	public static void main(String[] main) {
		int array[][] = new int[5][5];
		int row, col;
		char ch = 'A';
		for(row = 0; row <=4; row++) {
			if(row<=2) {
				for(col = row; col <= 4-row; col++) {
					array[row][col] = ch++;
				}
			} 
			else {
				for(col = 4 - row; col <= row; col++) {
					array[row][col] =ch++;
					
				}
			}
		}
	}
	
}
*/