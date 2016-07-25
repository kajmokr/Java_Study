package chap05.test;

import chap05.Customer;

public class TestCustomerArray {
	public static void main(String[] args) {
		Customer[] custs = new Customer[3];
		custs[0] = new Customer("ȫ�浿");
		System.out.println(custs[0]); // �ּҿ� �ؽ��ڵ� ����.
//		System.out.println(custs[0].toString());
		custs[1] = new Customer("�Ѹ�");
		custs[2] = new Customer("��ġ");	
		printArray(custs); 
	}//main

	private static void printArray(Customer[] custs) {
		for (int i = 0; i < custs.length; i++) { // for + ctrl + spacebar
			System.out.println(custs[i]);
		}
		for (Customer customer : custs) { // foreach
			System.out.println(customer);
		}
	}
}
