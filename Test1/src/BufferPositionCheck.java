import java.nio.ByteBuffer;

public class BufferPositionCheck {
	public static void main(String[] args) {
		
		ByteBuffer bb = ByteBuffer.allocate(1024); //�����Ҵ� ��ġ 0
		System.out.println("Position: " + bb.position());
		bb.putInt(120); //int�� ������ ����
		System.out.println("Position: " + bb.position());
		bb.putDouble(0.94); //double�� ������ ����
		System.out.println("Position: " + bb.position());
		bb.flip(); //flip�޼ҵ� ȣ���Ͽ� ������ 0�� ��ġ��Ŵ �� ������ ������ ���� �տ� ��ġ��Ű�� ����
		System.out.println("Position: " + bb.position());
		int n = bb.getInt(); //int�� ������ ������
		System.out.println("Position: " + bb.position());
		double d = bb.getDouble(); //double�� ������ ������
		System.out.println("Position: " + bb.position());
		
		
	}
}
