package CollectionTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jxl.write.WriteException;

	public class EmployeeMgmt { //메인부분을 간단하게 하기위해 여기에 나눠서 작성해놈
		
		EmployeeDAO dao = new EmployeeDAO();
		Scanner sc = new Scanner(System.in);
		
		public void empListProc() { //1번
		searchVO vo = new searchVO();
		vo.setSearchCondition("hire_date");
		vo.setSearchKeyword("19970101");

		List<EmployeeDTO> list = dao.getEmpList(vo);
		for (EmployeeDTO dto : list)
			System.out.println(dto);
	}
		
		public void empDTOProc() { //2번 한건조회
			System.out.println("조회할 사원번호를 입력하세요.");
			String empNo = sc.nextLine();
			
			EmployeeDTO dto2 = dao.getEmpDTO("empNo");
			System.out.println(dto2);
		}
		
		public void insertEmpProc() { //3번
		EmployeeDTO dto = new EmployeeDTO();
		System.out.println("사원번호를 입력하세요.");
		String empNo = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String firstName = sc.nextLine();
		System.out.println("성을 입력하세요.");
		String lastName = sc.nextLine();
		System.out.println("이메일을 입력하세요.");
		String email = sc.nextLine();
		System.out.println("직무를 입력하세요.");
		String job = sc.nextLine();
		
		dto.setEmployeeId(empNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setJobId(job);
		//dao.insertEmp(dto);
		dao.insertEmpProc(dto);
		}
		
		public void updateEmpProc() { //4번
			EmployeeDTO dto = new EmployeeDTO();
			System.out.println("수정할 사원번호를 입력하세요.");
			String empNo = sc.nextLine();
			System.out.println("수정할 이름을 입력하세요");
			String firstName = sc.nextLine();
			System.out.println("수정할 성을 입력하세요.");
			String lastName = sc.nextLine();
			System.out.println("수정할 이메일을 입력하세요.");
			String email = sc.nextLine();
			System.out.println("수정할 직무를 입력하세요.");
			String job = sc.nextLine();
			
			dto.setEmployeeId(empNo);
			dto.setFirstName(firstName);
			dto.setLastName(lastName);
			dto.setEmail(email);
			dto.setJobId(job);
			//dao.insertEmp(dto);
			dao.updateEmpProc(dto);
		}
		
		public void listMapEmpProc( ) {
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		list1 = dao.getEmpListMap();
		for(Map<String, Object> map : list1)
			System.out.println(map);
		}
		
		public void empListCursor() {
			List<EmployeeDTO> list = dao.getEmpListCursor();
			for(EmployeeDTO d : list)
				System.out.println(d);
		}
		
		public void excelExport() throws WriteException, IOException {
			dao.excelExport();
			
			
		}
}
