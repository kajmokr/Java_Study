package chap15;

import java.util.ArrayList;
import java.util.List;

import jdbc.vo.UserVO;

public class TestArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hello");
		
		// list.add(new Integer(10));
		list.add("hello2");
		list.add(new String("hello"));
		System.out.println("����Ʈ������: "+list.size()+"����Ʈ: "+list.get(1));
		
		// enhanced for loop
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
			String value = list.get(i);
		}
		
		for (String string : list) {
			System.out.println(string);
		}
		
		List<UserVO> users = new ArrayList<>();
		users.add(new UserVO("dooly", "�Ѹ�", 20, "2000-01-01"));
		users.add(new UserVO("gildong", "�浿", 30, "1990-01-01"));
		users.add(new UserVO("dooly", "�Ѹ�", 20, "2000-01-01"));
		
		for (UserVO userVO : users) {
			System.out.println(userVO); // userVO.toString()
		}
		for(int i=0; i<users.size(); i++){
			System.out.println(users.get(i));
		}
	}

}
