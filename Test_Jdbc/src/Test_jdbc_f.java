import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test_jdbc_f extends JFrame implements ItemListener{
	private JRadioButton rb1, rb2, rb3; //전체,남,여
	private JTextArea txtResult = new JTextArea();
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String sex;
	
	public Test_jdbc_f() {
		setTitle("사원현황");
		
		layInit();
		accDb();
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void layInit() {
		JPanel panel = new JPanel();
		// 라디오 버튼 생성 및 패널에 추가 
		ButtonGroup bg=new ButtonGroup();
		rb1= new JRadioButton("전체", true);
		rb2= new JRadioButton("남자");
		rb3= new JRadioButton("여자");

		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);

		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);

		add("North", panel);
		// 라디오 버튼 생성 및 패널에 추가 
		// 라디오버튼엔 아이템 리스너 장착 
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);

		// 라디오버튼엔 아이템 리스너 장착 
		// 텍스트에어리어 추가
		JScrollPane pane = new JScrollPane(txtResult);
		add("Center", pane);
		// 텍스트에어리어 추가
		
	}
	
	private void accDb() {
//		try {
//			Class.forName("com.mysql.jdbc.Connection");
//		} catch (Exception e) {
//			System.out.println("DB접속오류 : " + e);
//		}
		showdata("");
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == rb1) {
			sex = "all";
		} else if(e.getSource() == rb2) {
			sex = "man";
		} else if(e.getSource() == rb3) {
			sex = "woman";
		} 
		showdata(sex);
	}
	
	private String showdata(String sex) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firsttest", "root", "autoset"); //생성한 테이블 명 입력해준다..
			stmt = conn.createStatement();
			
			String sql = "select id, name, sex"
					+ " from table1 ";
			
			if(sex == "all") {
				sql += " order by id";
			} else if(sex == "man") {
				sql += " where sex = '남' order by id";
			} else if(sex == "woman") {
				sql += " where sex = '여' order by id";
			} 
			rs = stmt.executeQuery(sql);
			txtResult.setText("ID\t이름\t성별\n");
			while(rs.next()) {
				String str = rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("sex") + "\n";
				txtResult.append(str);
			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e2);
		} finally {						// 작업이 끝나면 닫아주어야 한다
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return sex;
	}
	public static void main(String[] args) {
		new Test_jdbc_f();
	}
}

