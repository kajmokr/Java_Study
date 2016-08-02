package chap15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		// �ؽ� �� ����
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "Hello100");
		map.put(100, "Hello"); // �ߺ� �ȵ�.
		map.put(200, "Hello200");
		map.put(300, "Hello300");
		
		System.out.println(map.get(100)); // Ű�� ������� ���� �������� ����.
		
		for(Integer key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		Set<Map.Entry<Integer, String>> set2 = map.entrySet();
		for(Entry<Integer, String> entry: set2){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}
}
