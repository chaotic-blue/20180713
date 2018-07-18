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
		
		int menu =5; //case 메뉴 선택
		
		while(true) {
			System.out.println("menu 선택하세요. 1:상품정보, 2:입출고정보, 3:재고정보, 4:창고정보, 6:종료");
			menu = sc.nextInt();

		switch (menu) {
		case 1: //출력 부분
			emg.empListProc();
			break;
		case 2:
			emg.empDTOProc();
			break;
		case 3: //데이터 입력 해주는부분
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
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
			/*
		case 7:
			emg.empListCursor();
			break;
			*/
		} //스위치문 닫기
	} //while문 닫기
		
		/*EmployeeDTO dto = dao.getEmpDTO("113");
		System.out.println(dto);*/
		
		/*List<EmployeeDTO> list = dao.getEmpList();
		for(EmployeeDTO dto : list)
			System.out.println(dto);*/
		
		
		}
		//pstmt 쿼리문 들어감
	}


