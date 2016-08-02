package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestEmployees {

	public static void main(String[] args) {
		
		// 1. Driver Class Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. Connection ��ü ����
		// ����Ŭ���� ���� ��Ʈ��ȣ xe db
		// driver type 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// tnsnames.ora �� �����ִ� ��Ʈ��ȣ 1521
		String user = "hr";
		String pass = "hr";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url,user,pass); // connection �������̽�
			System.out.println(con.getClass().getName()); 
			// 3. Statement ��ü ����
			stmt = con.createStatement(); // Statement �������̽�
			// new OracleStatementrapper �����ʰ� �ϱ� ���� ���������� �����ʱ�����
			System.out.println(stmt.getClass().getName());
			// 4. SQL�� ���� �� SQL ����� ó��
			// String sql = "select * from employees where employee_id=100";
			// String sql = "select * from employees order by employee_id";
			// String sql = "select * from employees";
			String sql = "select * from EMPLOYEES order by EMPLOYEE_ID desc";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getClass().getName());
			while(rs.next()){ // next()Ŀ�� �̵�, ������������ true
				System.out.println(rs.getInt("employee_id")+" "+rs.getString("first_name")+" "+rs.getDate("hire_date"));
			}
			// 5. ����� resource(connection, statement, resultset) ����
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ // �ᱹ���� �ñ������δ� 
			
			try {
				if(stmt != null)stmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
