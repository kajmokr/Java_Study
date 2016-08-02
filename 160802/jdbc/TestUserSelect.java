package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.vo.UserVO;

public class TestUserSelect {

	public static void main(String[] args) {
		
		String userid = args[0];
		
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
			StringBuilder sb = new StringBuilder();
			sb.append("select userid,")
				.append("name,")
				.append("age,")
				.append("to_char(DATEOFBIRTH,'YYYY-MM-DD') dateofbirth ") // ����
				.append("from users ") // ����
				.append("where userid='"+userid+"'");
			
			System.out.println(sb.toString());
			
//			String sql = sb.toString();
//			select userid,name,age,to_char(DATEOFBIRTH,'YYYY-MM-DD') dateofbirth from users
//			String sql = "select * from users where userid='"+userid+"'";
			ResultSet rs = stmt.executeQuery(sb.toString());
			System.out.println(rs.getClass().getName());
			UserVO userVO = null;
			
			List<UserVO> userList = new ArrayList<>();
			
			while(rs.next()){ // next()Ŀ�� �̵�, ������������ true
				userVO = new UserVO(rs.getString("userid"), rs.getString("name"), rs.getInt("age"), rs.getString("dateofbirth"));
//				System.out.println(userVO);
				userList.add(userVO);
			}
			
			for (UserVO userVO2 : userList) {
				System.out.println(userVO2);
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
