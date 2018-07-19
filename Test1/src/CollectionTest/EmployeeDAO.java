package CollectionTest;

import java.awt.Transparency;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class EmployeeDAO {

	Connection conn = null;
	public void updateEmp(EmployeeDTO dto) {
		getConnection();
		String sql = "update employees " + 
				"SET employee_id=?, first_name=?, last_name=?, email=?, Job_id=? " + 
				"where employee_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getJobId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 건이 입력되었습니다.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public Connection getConnection() {

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
			System.out.println("DB 접속실패 : "+ sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} //DB접속환경
		return conn;
	}

	public void insertEmp(EmployeeDTO dto) {
		getConnection();
		String sql = "insert into employees (employee_id, first_name, last_name, email, hire_date, job_id) " + 
				"values(?, ?, ?, ?,sysdate, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getJobId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 건이 입력되었습니다.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertEmpProc(EmployeeDTO dto) { // 인설트 프로시져 만들어서 사용하는 클라스
		getConnection();
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call insert_emp_proc(?,?,?,?)}");
			cstmt.setString(1, dto.getFirstName());//첫번째 ? 에 들어갈 프로시져
			cstmt.setString(2, dto.getLastName());
			cstmt.setString(3, dto.getEmail());
			cstmt.setString(4, dto.getJobId());
			int r = cstmt.executeUpdate();
			System.out.println(r+"건 입력되었습니다.(Proc)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void updateEmpProc(EmployeeDTO dto) { // 업데이트 프로시져 만들어서 사용하는 클라스
		
		getConnection();
		
		try {
			CallableStatement pstmt = conn.prepareCall("{call update_emp_proc(?,?,?,?,?)}");
			
			pstmt.setString(1, dto.getFirstName());
			pstmt.setString(2, dto.getLastName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getJobId());
			pstmt.setString(5, dto.getEmployeeId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 건이 입력되었습니다.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public EmployeeDTO getEmpDTO(String emp_id) {

		getConnection();
		EmployeeDTO dto = null;
		List<EmployeeDTO> list = new ArrayList<>();

		String sql = "select employee_id, first_name, last_name, email from employees " + "where employee_id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql연결준비
			pstmt.setString(1, emp_id);

			ResultSet rs = pstmt.executeQuery(); //쿼리 받아서 실행된결과 rs 저장

			if (rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));

			}

			/*System.out.println(rs.getString("first_name")+"  "+rs.getInt("employee_id"));*/
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dto; //dto타입 한건만 리턴
	}

	public List<EmployeeDTO> getEmpList(searchVO vo) {

		getConnection();
		EmployeeDTO dto = null;
		List<EmployeeDTO> list = new ArrayList<>();
		String whereClause = "where 1=1";


		if("first_name".equals(vo.getSearchCondition()))
			whereClause += " and first_name like '%'||'"+vo.getSearchKeyword()+"'||'%'";

		if("last_name".equals(vo.getSearchCondition()))
			whereClause += " and last_name like '%'||'"+vo.getSearchKeyword()+"'||'%'";
		
		if("salary".equals(vo.getSearchCondition()))
			whereClause += " and salary like '%'||'"+vo.getSearchKeyword()+"'||'%'";
		
//			whereClause += " and hire_date > to_date('" + vo.getSearchKeyword() + "','rrrrmmdd')";

		String sql = "select employee_id, first_name, last_name, email, job_id, hire_date from employees "
				+ whereClause + " order by 1 desc";

		//System.out.println(sql);
		System.out.println("==========================================================================================================");
		System.out.println("Employee_id\t First_name\t Lst_name\t Email\t\t\t Job_Id\t\t Hire_Date\t");
		System.out.println("==========================================================================================================");

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql연결준비
			ResultSet rs = pstmt.executeQuery(); //쿼리 받아서 실행된결과 rs 저장

			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJobId(rs.getString("job_id"));
				dto.setHireDate(rs.getString("hire_date"));
				list.add(dto); //dto한건 담음.. while문으로 계속 돔

			}
			/*System.out.println(rs.getString("first_name")+"  "+rs.getInt("employee_id"));*/
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}



	public List<Map<String, Object>> getEmpListMap() { //맵 사용
		getConnection();
		String sql = "select employee_id, first_name from employees";
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map=new HashMap<String, Object>();
				map.put("employee_id", rs.getString("employee_id"));
				map.put("first_name", rs.getString("first_name"));
				list.add(map);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<EmployeeDTO> getEmpListCursor() { //프로시져 사용
		getConnection();//연결함
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			cstmt.setInt(1, 500);
			cstmt.setDate(2, new Date(100,0,1));
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet) cstmt.getObject(3);
			
			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJobId(rs.getString("job_id"));
				dto.setHireDate(rs.getString("hire_date"));
				list.add(dto); //dto한건 담음.. while문으로 계속 돔
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public void excelExport() throws IOException, WriteException {
		
		
		EmployeeDAO dao = new EmployeeDAO();
		WritableWorkbook workbook = Workbook.createWorkbook(new File("newExcel.xls")); //엑셀 워크북 만듬
		WritableSheet sheet = workbook.createSheet("employee", 0); //엑셀 시트 만듬
		WritableCellFormat wcf = new WritableCellFormat();
		wcf.setAlignment(Alignment.CENTRE);//셀 형식 꾸미는것들
		wcf.setBackground(Colour.GOLD);
		WritableFont arial10Bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		wcf.setFont(arial10Bold);
		sheet.setColumnView(0, 20); //셀 컬럼 넓이 지정 
		sheet.setColumnView(1, 20);
		sheet.setColumnView(2, 20);

		sheet.addCell(new Label(0, 0, "firstName", wcf)); //셀을 만듬 firstname ~ salary
		sheet.addCell(new Label(1, 0, "lastName", wcf));
		sheet.addCell(new Label(2, 0, "salary", wcf));
		
		searchVO vo = new searchVO();
		List<EmployeeDTO> list = dao.getEmpList(vo);
		//List<EmployeeDTO> list = null;//dao.getEmployeesList();
		
		
		int j = 1;
		for (EmployeeDTO emp : list) { //데이터가 돌면서 담긴다.
			Label lblFirstName = new Label(0, j, emp.getFirstName());
			Label lblLastName = new Label(1, j, emp.getLastName());
			Label lblSalary = new Label(2, j, emp.getSalary());

			sheet.addCell(lblFirstName);
			sheet.addCell(lblLastName);
			sheet.addCell(lblSalary);
			j++;
		}
		workbook.write();
		workbook.close();
		System.out.println("excel completed.");
	}
	
	
}
