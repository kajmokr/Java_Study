package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUserInsertPrepareStatement {

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
		PreparedStatement stmt = null;
		
		try {
			con = DriverManager.getConnection(url,user,pass); // connection �������̽�
			System.out.println(con.getClass().getName()); 
			
			// 3. Statement ��ü ����
			String sql = "insert into users values(?,?,?,to_date(?,'YYYY-MM-DD'))"; // �÷��� 4�� userid,name,age,date
			stmt = con.prepareStatement(sql); // Statement �������̽�
			
			// new OracleStatementrapper �����ʰ� �ϱ� ���� ���������� �����ʱ�����
			System.out.println(stmt.getClass().getName());
			
			// 4. SQL�� ���� �� SQL ����� ó��
			stmt.setString(1, userid);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setString(4, date);
			
			int rowCnt = stmt.executeUpdate();
			System.out.println(stmt.toString());
			
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
