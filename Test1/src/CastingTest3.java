
public class CastingTest3 {
	public static void main(String args[]) {
		long l = 1234567890123456789L; //19자리 자리 정수
		float f = l;
		double d = l;
		System.out.println("원래의 long값 : "+l);
		System.out.println("long >> float로 변환 : "+f);
		System.out.println("long >> double로 변환 : "+d);
		long f1 = (long)f;
		long d1 = (long)d;
		System.out.println("long >> float >> long으로 변환 : "+f1);
		System.out.println("long >> double >> long으로 변환 : "+d1);
	}
}