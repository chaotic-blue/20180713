package CollectionTest;

import java.awt.Transparency;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {

	Connection conn = null;
	public void updateEmp(EmployeeDTO dto) {
		getConnection();
		String sql = "update employees " + 
				"SET employee_id=?, first_name=?, last_name=?, email=? " + 
				"where employee_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getEmployeeId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " ���� �ԷµǾ����ϴ�.");
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

			System.out.println("Database�� ����Ǿ����ϴ�.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : "+ sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} //DB����ȯ��
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
			System.out.println(cnt + " ���� �ԷµǾ����ϴ�.");
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
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql�����غ�
			pstmt.setString(1, emp_id);

			ResultSet rs = pstmt.executeQuery(); //���� �޾Ƽ� ����Ȱ�� rs ����

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
		return dto; //dtoŸ�� �ѰǸ� ����
	}

	public List<EmployeeDTO> getEmpList(searchVO vo) {

		getConnection();
		EmployeeDTO dto = null;
		List<EmployeeDTO> list = new ArrayList<>();
		String whereClause = "where 1=1";


		if(vo.getSearchCondition().equals("first_name"))
			whereClause += " and first_name like '%'||'"+vo.getSearchKeyword()+"'||'%'";

		if(vo.getSearchCondition().equals("hire_date"))
			whereClause += " and hire_date > to_date('" + vo.getSearchKeyword() + "','rrrrmmdd')";

		String sql = "select employee_id, first_name, last_name, email, job_id, hire_date from employees "
				+ whereClause + " order by 1 desc";

		//System.out.println(sql);
		System.out.println("==========================================================================================================");
		System.out.println("Employee_id\t First_name\t Lst_name\t Email\t\t\t Job_Id\t\t Hire_Date\t");
		System.out.println("==========================================================================================================");

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql�����غ�
			ResultSet rs = pstmt.executeQuery(); //���� �޾Ƽ� ����Ȱ�� rs ����

			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				list.add(dto); //dto�Ѱ� ����.. while������ ��� ��

			}
			/*System.out.println(rs.getString("first_name")+"  "+rs.getInt("employee_id"));*/
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}



	public List<Map<String, Object>> getEmpListMap() { //�� ���
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

	/*public void getEmpListCursor() { //���ν��� ���
		getConnection();//������
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			cstmt.setInt(1, 500);
			cstmt.setDate(2, new Date(100,0,1));
			cstmt.registerOutParameter(3, oracle.jdbc.OracleType.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = cstmt.getObject(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
