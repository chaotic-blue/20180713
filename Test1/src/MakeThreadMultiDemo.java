
public class MakeThreadMultiDemo {
	public static void main(String[] args) {
		
		
		Runnable task1 = () -> {
			try {
				for(int i = 0; i<20; i++) {
					if(i%2==0) //짝수 뽑는 작업
						System.out.println(i + " ");
					Thread.sleep(100);
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () -> {
			try {
				for(int i = 0; i<20; i++) {
					if(i%2==1) //홀수 뽑는 작업
						System.out.println(i + " ");
					Thread.sleep(100);
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		//스레드 작업 1,2 인스턴스 생성뒤 start()메소드로 실행
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
	}
}
