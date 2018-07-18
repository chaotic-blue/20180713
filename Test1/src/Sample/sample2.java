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

		Connection conn = null; //커넥션 참조변수 선언

		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB접속환경
		
		List<EmployeeDTO> list = new ArrayList<>(); //EmployeeDTO타입 클래스 리스트에 담겠다.
		String sql = "select employee_id, first_name, last_name, salary, job_id, hire_date from employees "; //sql문 sql에 담음.
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql문 던진다
			ResultSet rs = pstmt.executeQuery(); //실행한다
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
		} //sql연결준비
		
		list.stream().filter(n-> n.getSalary()>700).forEach(s-> System.out.println(s)); //salary 700보다 큰 사람들 출력
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
