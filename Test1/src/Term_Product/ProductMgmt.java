package Term_Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

	public class ProductMgmt {
		
		ProductDAO dao = new ProductDAO();
		Scanner sc = new Scanner(System.in);
		
		public void empListProc() { //1��
		searchVO vo = new searchVO();
		vo.setSearchCondition("hire_date");
		vo.setSearchKeyword("19970101");

		List<ProductDTO> list = dao.getEmpList(vo);
		for (ProductDTO dto : list)
			System.out.println(dto);
	}
		
		public void empDTOProc() { //2�� �Ѱ���ȸ
			System.out.println("��ȸ�� �����ȣ�� �Է��ϼ���.");
			String empNo = sc.nextLine();
			
			ProductDTO dto2 = dao.getEmpDTO("empNo");
			System.out.println(dto2);
		}
		
		public void insertEmpProc() { //3��
		ProductDTO dto = new ProductDTO();
		System.out.println("�����ȣ�� �Է��ϼ���.");
		String empNo = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���");
		String firstName = sc.nextLine();
		System.out.println("���� �Է��ϼ���.");
		String lastName = sc.nextLine();
		System.out.println("�̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("������ �Է��ϼ���.");
		String job = sc.nextLine();
		
		dto.setEmployeeId(empNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setJobId(job);
		//dao.insertEmp(dto);
		dao.insertEmpProc(dto);
		}
		
		public void updateEmpProc() { //4��
			ProductDTO dto = new ProductDTO();
			System.out.println("������ �����ȣ�� �Է��ϼ���.");
			String empNo = sc.nextLine();
			System.out.println("������ �̸��� �Է��ϼ���");
			String firstName = sc.nextLine();
			System.out.println("������ ���� �Է��ϼ���.");
			String lastName = sc.nextLine();
			System.out.println("������ �̸����� �Է��ϼ���.");
			String email = sc.nextLine();
			System.out.println("������ ������ �Է��ϼ���.");
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
			List<ProductDTO> list = dao.getEmpListCursor();
			for(ProductDTO d : list)
				System.out.println(d);
		}
}
