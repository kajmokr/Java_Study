package jdbc;

public class TestDepartments {

	public static void main(String[] args) {
		// 1. Driver Class Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. Connection ��ü ����
		String url = "";
		String user = "";
		String pass = "";
		// 3. Statement ��ü ����
		// 4. SQL�� ���� �� SQL ����� ó��
		// 5. ����� resource(connection, statement, resultset) ����
	}

}
