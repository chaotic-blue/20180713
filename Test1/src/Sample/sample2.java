package Sample;

//import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CollectionTest.EmployeeDTO;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



public class sample2 {
	public static void main(String[] args) {

		Connection conn = null; //Ŀ�ؼ� �������� ����

		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database�� ����Ǿ����ϴ�.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB����ȯ��
		
		List<EmployeeDTO> list = new ArrayList<>(); //EmployeeDTOŸ�� Ŭ���� ����Ʈ�� ��ڴ�.
		String sql = "select employee_id, first_name, last_name, salary, job_id, hire_date from employees "; //sql�� sql�� ����.
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql�� ������
			ResultSet rs = pstmt.executeQuery(); //�����Ѵ�
			EmployeeDTO emp = null; //
			while(rs.next())
			{
				emp=new EmployeeDTO();
				emp.setEmployeeId(rs.getString("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //sql�����غ�
		
		list.stream().filter(n-> n.getSalary()>700).forEach(s-> System.out.println(s)); //salary 700���� ū ����� ���
	}
	/*
	public void excelExport() throws IOException {
		
		WritableWorkbook workbook = Workbook.createWorkbook(new File("newExcel.xls"));
		WritableSheet sheet = workbook.createSheet("employee", 0);
		WritableCellFormat wcf = new WritableCellFormat();
		wcf.setAlignment();
	}
	*/
}
