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
	private JRadioButton rb1, rb2, rb3; //��ü,��,��
	private JTextArea txtResult = new JTextArea();
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String sex;
	
	public Test_jdbc_f() {
		setTitle("�����Ȳ");
		
		layInit();
		accDb();
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void layInit() {
		JPanel panel = new JPanel();
		// ���� ��ư ���� �� �гο� �߰� 
		ButtonGroup bg=new ButtonGroup();
		rb1= new JRadioButton("��ü", true);
		rb2= new JRadioButton("����");
		rb3= new JRadioButton("����");

		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);

		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);

		add("North", panel);
		// ���� ��ư ���� �� �гο� �߰� 
		// ������ư�� ������ ������ ���� 
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);

		// ������ư�� ������ ������ ���� 
		// �ؽ�Ʈ����� �߰�
		JScrollPane pane = new JScrollPane(txtResult);
		add("Center", pane);
		// �ؽ�Ʈ����� �߰�
		
	}
	
	private void accDb() {
//		try {
//			Class.forName("com.mysql.jdbc.Connection");
//		} catch (Exception e) {
//			System.out.println("DB���ӿ��� : " + e);
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firsttest", "root", "autoset"); //������ ���̺� �� �Է����ش�..
			stmt = conn.createStatement();
			
			String sql = "select id, name, sex"
					+ " from table1 ";
			
			if(sex == "all") {
				sql += " order by id";
			} else if(sex == "man") {
				sql += " where sex = '��' order by id";
			} else if(sex == "woman") {
				sql += " where sex = '��' order by id";
			} 
			rs = stmt.executeQuery(sql);
			txtResult.setText("ID\t�̸�\t����\n");
			while(rs.next()) {
				String str = rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("sex") + "\n";
				txtResult.append(str);
			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e2);
		} finally {						// �۾��� ������ �ݾ��־�� �Ѵ�
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

