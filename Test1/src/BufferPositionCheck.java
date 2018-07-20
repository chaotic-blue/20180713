import java.nio.ByteBuffer;

public class BufferPositionCheck {
	public static void main(String[] args) {
		
		ByteBuffer bb = ByteBuffer.allocate(1024); //버퍼할당 위치 0
		System.out.println("Position: " + bb.position());
		bb.putInt(120); //int형 데이터 줍줍
		System.out.println("Position: " + bb.position());
		bb.putDouble(0.94); //double형 데이터 줍줍
		System.out.println("Position: " + bb.position());
		bb.flip(); //flip메소드 호출하여 포지션 0에 위치시킴 들어간 데이터 꺼내기 위에 앞에 위치시키기 위함
		System.out.println("Position: " + bb.position());
		int n = bb.getInt(); //int형 데이터 꺼내기
		System.out.println("Position: " + bb.position());
		double d = bb.getDouble(); //double형 데이터 꺼내기
		System.out.println("Position: " + bb.position());
		
		
	}
}
