package Term_Product;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Term_Product.ProductMgmt;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {
	public static void main(String[] args) {
		//EmployeeDAO dao = new EmployeeDAO();
		ProductMgmt emg = new ProductMgmt();
		//EmployeeDTO dto = new EmployeeDTO();
		Scanner sc = new Scanner(System.in);
		
		int menu =5; //case �޴� ����
		
		while(true) {
			System.out.println("menu �����ϼ���. 1:��ǰ����, 2:���������, 3:�������, 4:â������, 6:����");
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
		/*
		case 4:
			emg.updateEmpProc();
			break;
		case 5:
			emg.listMapEmpProc();
			break;
			*/
		case 6:
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
			/*
		case 7:
			emg.empListCursor();
			break;
			*/
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


