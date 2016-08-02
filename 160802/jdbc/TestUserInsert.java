package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUserInsert {

	public static void main(String[] args) {
		
		String userid = args[0];
		String name = args[1];
		int age = Integer.parseInt(args[2]);
		String date = args[3];
		
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
		String user = "scott";
		String pass = "tiger";
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
			StringBuilder sb = new StringBuilder();
			sb.append("insert into users values"+"(")
			.append("'"+userid+"',")
			.append("'"+name+"',")
			.append(age+",")
			.append("to_date('"+date+"','YYYY-MM-DD'))");
			
			System.out.println(sb.toString());
			
			String sql = sb.toString();
			
			int rowCnt = stmt.executeUpdate(sql);
			System.out.println("��ϵ� �Ǽ�" + rowCnt);
			
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
