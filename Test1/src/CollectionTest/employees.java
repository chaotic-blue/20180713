package CollectionTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class employees {
	public static void main(String[] args) {
		//EmployeeDAO dao = new EmployeeDAO();
		EmployeeMgmt emg = new EmployeeMgmt();
		//EmployeeDTO dto = new EmployeeDTO();
		Scanner sc = new Scanner(System.in);
		
		int menu =5; //case �޴� ����
		
		while(true) {
			System.out.println("menu �����ϼ���. 1:��ü��ȸ(����), 2:�ܰ���ȸ, 3:�Է�, 4:����, 5:��ü��ȸ(map), 6:����");
			menu = sc.nextInt();

		switch (menu) {
		case 1: //��� �κ�
			emg.empListProc();
			break;
		case 2:
			emg.empDTOProc();
			break;
		case 3: //������ �Է� ���ִºκ�
			emg.insertEmpProc();
			break;
		case 4:
			emg.updateEmpProc();
			break;
		case 5:
			emg.listMapEmpProc();
			break;
		case 6:
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		} //����ġ�� �ݱ�
	} //while�� �ݱ�
		
		/*EmployeeDTO dto = dao.getEmpDTO("113");
		System.out.println(dto);*/
		
		/*List<EmployeeDTO> list = dao.getEmpList();
		for(EmployeeDTO dto : list)
			System.out.println(dto);*/
		
		
		}
		//pstmt ������ ��
	}


