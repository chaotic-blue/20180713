
public class Turn_90do {
	public static void main(String[] args) {
		
		int [][] ar = new int [5][5];
		int k =0;
		int num = 0;
		int num1=0;
		int num2=0;
		
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) {
				ar[i][j] = num;
				num++;
			}
		}
		
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.print(ar[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		////////////////////
		for(int i=0; i<ar[0].length; i++) {
			for(int j=4; j>-1; j--) {

				num1=ar[i][k];
				num2=ar[j][i];
				ar[i][k]=num2;
				ar[j][i]=num1;
				k++;
			}
		}
		
		///////////////////////
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.print(ar[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
