package chap15;

import java.util.HashSet;
import java.util.Set;

import jdbc.vo.UserVO;

public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("hello");
		set.add("hello2");
		set.add("hello");
		set.add("hello");
		
		
		
		for (String string : set) {
			System.out.println(string); // String�� �ߺ� ���ŵ�.
		}
		
		Set<UserVO> users = new HashSet<>();
		users.add(new UserVO("dooly", "�Ѹ�", 20, "2000-01-01"));
		users.add(new UserVO("gildong", "�浿", 30, "1990-01-01"));
		users.add(new UserVO("dooly", "�Ѹ�", 20, "2000-01-01"));
		
		for (UserVO userVO : users) {
			System.out.println(userVO); // �ߺ� ���Ű� �ȵ�.
			System.out.println(userVO.hashCode());
		}
		
		// �ߺ� ���� �Ƿ��� UserVO Ŭ���� �ȿ��� equals �޼ҵ�
		
		
	}
}
